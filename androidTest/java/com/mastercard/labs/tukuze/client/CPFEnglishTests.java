package com.mastercard.labs.tukuze.client;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.mastercard.labs.tukuze.agent.SelectLanguageActivity;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
import static com.mastercard.labs.tukuze.client.TestData.buyersList;
import static com.mastercard.labs.tukuze.client.TestData.registerFarmers;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static com.mastercard.labs.tukuze.client.CPFPageObjects.*;

/**
 * Created by amoi on 18/08/2016.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//for ordering the tests

@RunWith(AndroidJUnit4.class)
public class CPFEnglishTests {

    @Rule
    public ActivityTestRule<SelectLanguageActivity> mActivityRule =
            new ActivityTestRule<>(SelectLanguageActivity.class);

    /**
     * Set up method runs before each test method
     */
    @Before
    public void setUp() {
        IdlingPolicies.setMasterPolicyTimeout(900, TimeUnit.SECONDS);
        // IdlingPolicies.setIdlingResourceTimeout(1, TimeUnit.MINUTES);
    }

    // @After
    public void tearDown() {

        try {
            for (int i = 0; i < 10; ++i)
                Espresso.pressBack();
        } catch (Exception e) {

        }
    }

    /**
     * Verifies whether launch screen has the specified views.
     */
    @Test
    public void A_testLaunchScreen() {

        isEachViewDisplayed("English", "Kiswahili", "Select Language / Chagua Lugha");
    }

    /**
     * This login is for cases where no weighing scale is gona be used.
     */
    //@Test
    public void B_testFirstLogin() {
        firstTimeLogin("admin", "Nyama@16");
        firstTimeLogin("agent", "Nyama@16");
    }

    /**
     * This login is for cases where weighing  scale is  used for emulators.
     */
    //@Test
    public void C_testInitializeWS() {

        logIn("admin", "Nyama@16");
        clickOnSideMenu("Open navigation drawer");
        clickOnView("Setting");
//        clickOnMenuItem(R.id.btnSetBluetoothDevice);
    }

    /**
     * Tests message for login with invalid credentials.
     */
    @Test
    public void D_testInvalidCredentialMSG() {
        logIn("agent1", "Nyama@16");
        isViewDisplayed("Sorry, access denied. Your login credentials are invalid.");
    }

    /**
     * Test Login with valid credentials
     */
    @Test
    public void E_testValidCredentials() {

        logIn("nandiadmin", "Nyama@16");
        isViewDisplayed("Nandi User");
    }

    /**
     * Test for agent's farmer(s) registration.
     */
   // @Test
    public void F_addMultipleFarmers() {

        logIn("nandiadmin", "Nyama@16");

        String[][] newFarmers = registerFarmers();

        String[] gender = {"Female", "Male"};
        String[] language = {"English", "Swahili"};

        for (int count = 0; count < newFarmers.length; ++count) {

            goToFarmerList();

            FarmerList.clickOnAddFarmer();

            //populate farmer's personal information
            String[] farmer = newFarmers[count];

            CreateFarmerForm.typeSurName(farmer[0] + "-nandi");

            CreateFarmerForm.typeOtherName(farmer[1] + "-nandi");

            CreateFarmerForm.typeMobileNo(farmer[2]);

            CreateFarmerForm.typePIN(farmer[3]);

            CreateFarmerForm.typePOB(farmer[4]);

            CreateFarmerForm.clickOnGender();

            CreateFarmerForm.selectGender(gender[new Random().nextInt(gender.length)]);
            CreateFarmerForm.clickOnDOB();
            CreateFarmerForm.selectCurrentDate();

            CreateFarmerForm.clickOnLanguagePref();
            CreateFarmerForm.selectLanguage(language[new Random().nextInt(language.length)]);
            CreateFarmerForm.clickOnContinue();

            // Populate farm information
            if (count % 7 == 0) {

                CreateFarmerForm.typeArea("Kapsabet area");
                CreateFarmerForm.typeAddress("kapsabet-East");

                CreateFarmerForm.selectLandSize(5);

                CreateFarmerForm.clickOnEquipments();
                CreateFarmerForm.selectEquipment("Tractor", "Hand");

                CreateFarmerForm.clickOnCrops();
                CreateFarmerForm.selectCrops("nandi-beans");


                CreateFarmerForm.clickOnAnimals();
                CreateFarmerForm.selectAnimals("nandi-chicken");

                CreateFarmerForm.typeFertilizer("DAP");

            }
            CreateFarmerForm.clickOnContinue();

            //populate payment information
            CreateFarmerForm.clickMoMoPaymentOption();
            CreateFarmerForm.typeMoMoAccount("+254728067003");

            CreateFarmerForm.clickOnContinue();
            CreateFarmerForm.clickOnContinue();

            isViewDisplayed("The farmer has been registered, a confirmation SMS will be sent to the farmer.");

            clickOnView("Ok");

            actionOnViewSwipeDown(R.id.text_other_names, 4);

            goToHome();
        }
    }

    /**
     * Test that agent can search farmer, only searched farmer record should be displayed.
     */
    @Test
    public void G_testSeachFarmerByAgent() {

        logIn("nandiagent", "Nyama@16");
        goToFarmerList();
        FarmerList.typeSearchFarmer("yvonneh");
        FarmerList.clickOnSearchFarmer();
        FarmerList.clearSearchFarmer();

        isEachViewDisplayed("Yvonneh");

        isViewsNotExist("Kihara", "Kuria", "Akummu", "Munyiri", "Munyiri");
    }

    /**
     * Test for correct farmer's list display, ordering and swapping up/down.
     */
    @Test
    public void H_testSwipeFarmersList() {

        logIn("nandiagent", "Nyama@16");

        goToFarmerList();

        String[][] farmers = TestData.registerFarmers();

        isEachViewDisplayed(farmers[0][1] + "-nandi", farmers[1][1] + "-nandi", farmers[2][1] + "-nandi");

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 18);

        isEachViewDisplayed(farmers[17][1] + "-nandi", farmers[16][1] + "-nandi", farmers[15][1] + "-nandi");
    }

    /**
     * Test refresh produce to pull new produces from server
     * add logic to scroll and check if new items are displayed on the screen.
     */
    @Test
    public void I_testProduceList() {
        logIn("nandiadmin", "Nyama@16");
        goToCollectProduce();

        String[] produces = TestData.produce();

        isEachViewDisplayed("nandi-" + produces[0], "nandi-" + produces[5]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 19);

        isEachViewDisplayed("nandi-" + produces[10], "nandi-" + produces[15], "nandi-" + produces[18]);


        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 17, 26);

        isEachViewDisplayed("nandi-" + produces[18], "nandi-" + produces[23], "nandi-" + produces[25]);
    }

    /**
     * Test for correct produce's list display, ordering and swapping up/down.
     */
    @Test
    public void J_testRefreshProduceList() {

        logIn("nandiadmin", "Nyama@16");
        goToCollectProduce();

        clickOnRefreshList();

        String[] produces = TestData.produce();

        isEachViewDisplayed("nandi-" + produces[0], "nandi-" + produces[5]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 19);

        isEachViewDisplayed("nandi-" + produces[10], "nandi-" + produces[15], "nandi-" + produces[18]);


        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 17, 26);

        isEachViewDisplayed("nandi-" + produces[18], "nandi-" + produces[23], "nandi-" + produces[25]);
    }

    /**
     * Test adding of multiple buyers
     */
    @Test
    public void K_testAddMultipleBuyers() {

        logIn("nandiadmin", "Nyama@16");


        String[][] buyers = buyersList();

        for (int i = 0; i < buyers.length; ++i) {

            String[] buyer = buyers[i];

            goToBuyerList();
            BuyerList.clickOnAddBuyer();

            CreateBuyerForm.typeFirstName(buyer[0]);
            CreateBuyerForm.typeLastName(buyer[1]);
            CreateBuyerForm.typePhoneNo(buyer[2]);
            CreateBuyerForm.typeLocation(buyer[3]);
            BuyerList.clickOnAddBuyer();

            clickOnView("Ok");

            clickOnSideMenu("Open navigation drawer");

            onView(Matchers.allOf(withText(containsString("Home")))).perform(click());

        }
    }

    /**
     * Test for buyer list
     */
    @Test
    public void L_testBuyerListing() {
        logIn("nandiadmin", "Nyama@16");
        goToBuyerList();

        String[][] buyers = TestData.buyersList();

        isEachViewDisplayed(buyers[21][0], buyers[24][0], buyers[25][0]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 4, 10);
        isEachViewDisplayed(buyers[16][0], buyers[19][0], buyers[20][0]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 9, 16);
        isEachViewDisplayed(buyers[10][0], buyers[13][0], buyers[14][0]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 16, 21);
        isEachViewDisplayed(buyers[5][0], buyers[7][0], buyers[9][0]);

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 21, 26);
        isEachViewDisplayed(buyers[0][0], buyers[2][0], buyers[4][0]);

    }

    /**
     * Test for adding of multiple buy orders.
     * Please ensure you have populated at the back end with all produce in the produce list.
     */
    @Test
    public void M_testAddMultipleBuyOrders() {

        logIn("nandiadmin", "Nyama@16");

        String[][] buyers = TestData.buyersList();
        String[] produce = TestData.produce();

        int quantity = 10;

        for (int count = 0; count < buyers.length; ++count) {

            for (int i = 0; i < produce.length; ++i) {//pick only 2 crops

                if ((i == 0 || i == produce.length - 1)
                        && (!buyers[count][0].equalsIgnoreCase("Quenteen"))
                       // && (!produce[i].equalsIgnoreCase("Titus"))
                        ) {

                    goToOrderList();

                    BuyerOrderList.clickOnAddBuyOrder();

                    CreateBuyerOrderForm.selectProduce("nandi-" + produce[i]);
                    CreateBuyerOrderForm.typeQuantity(String.valueOf(quantity));
                    CreateBuyerOrderForm.selectBuyer(buyers[count][0]);
                    pressBack();
                    CreateBuyerOrderForm.selectDate();

                    clickWithTrialsOnView("Done", "Ok", "OK");

                    clickOnView(R.id.button_add_order);

                    isViewDisplayed("Request Successfully Posted");

                    clickOnView("Ok");
                    goToHome();
                    quantity++;
                }
            }
        }
    }

    /**
     * Test display of buy order list before fulfillment.
     * Correct values to be filled during actual tests.
     */
    @Test
    public void N_testDisplayOfBuyOrdersBeforeFulfillment() {

        logIn("nandiadmin", "Nyama@16");

       goToOrderList();

        isEachViewDisplayed("58.0", "59.0");

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 10);
        isEachViewDisplayed("50.0", "51.0");

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 10, 50);
        isEachViewDisplayed("10.0", "11.0");

//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 10, 20);
//        isEachViewDisplayed("31.0", "32.0");

//        isEachViewDisplayed("10.0", "11.0");
//
//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 10);
//        isEachViewDisplayed("21.0", "22.0");
//
//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 10, 20);
//        isEachViewDisplayed("31.0", "32.0");

    }

    /**
     * Test for multiple collections without weighing.
     * Mutually exclusive to with weighing
     * Be sure to have changed constants value to false fro simulation.
     */
    @Test
    public void O_testCollectMultipleWithoutWeighing() {

        logIn("nandiadmin", "Nyama@16");
        String[][] farmers = TestData.registerFarmers();
        String[] produce = TestData.produce();
        int farmerCount=farmers.length;
        int produceCount=produce.length;
        int pricesCount= produceCount*farmerCount;

        int[] prices = TestData.collectionWithOutPrices(pricesCount);
        int priceCount = 0;

        for (int i = 0; i < produce.length; ++i) {

            if(i==0||i==produce.length-1){

                int maxPriceIndex=((i+1)*(farmerCount));

                Log.d("Espressi", "maxPriceIndex="+maxPriceIndex+", i="+i+"farm count="+farmerCount
                        +"Count(), @:"+ count+"Prices counting"+prices.length);

                int farmIndex=0;

                for (int count = maxPriceIndex-farmerCount; count < maxPriceIndex; ++count) {

                    int price=prices[count];

                    Log.d("Espressi","PriceIndex Count(), @:"+ count);

                    goToCollectProduce();
                    ProduceList.selectProduce(produce[i]);

                    FarmerList.searchFarmer(farmers[farmIndex][0]);
                    clickOnView(farmers[farmIndex][0]);

                    PopulatePayment.typeQuantity(String.valueOf(count+1));

                    PopulatePayment.typeAmount(String.valueOf(price));
                    PopulatePayment.clickOnDone();

                    CPFPageObjects.clickOnContinue();

                    SplitPaymentScreen.typeMoMo(String.valueOf(0.6*price));
                    SplitPaymentScreen.typeCash(String.valueOf(0.4*price));
                    CPFPageObjects.clickOnContinue();

                    clickOnView("Ok");

                    goToHome();

                    farmIndex++;
                }

            }
        }
    }

    /**
     * Tests weigh and collect produce
     * Be sure to have changed simulation value to true in constants file.
     * Be sure to have paired the weighing scale and configured it in the settings for real devices.
     */
    //@Test
    public void Oo_testCollectProduceWithWeighing() {}
    /**
     * Test multiple order fulfillment
     */
    @Test
    public void P_testMultipleOrderFulfillment() {

        int buyerCount= buyersList().length;
        int produceCount=TestData.produce().length;
        int[] orderPrices = TestData.buyOrderPrices(buyerCount*produceCount);

        logIn("nandiadmin", "Nyama@16");

        String[] paymentModes = {"Cash", "Bank", "Mobile"};

        String paymentMode = paymentModes[new Random().nextInt(3)];

        for (int i = 0; i < produceCount; ++i) {

            if (i == 0 || i == produceCount - 1) {

                int maxPriceIndex = ((i + 1) * (buyerCount));

                Log.d("Espressi", "maxPriceIndex=" + maxPriceIndex + ", i=" + i + "farm count=" + buyerCount
                        + "Count(), @:" + count + "Prices counting" + orderPrices.length);

                int buyerIndex = 0;

                for (int count = maxPriceIndex-buyerCount; count < maxPriceIndex; ++count) {

                    goToOrderList();
                    clickOnFirstView(R.id.button_deliver);
                    DeliverOrder.selectPaymentMode(paymentMode);
                    DeliverOrder.typeSellPrice(String.valueOf(orderPrices[count]));
                    DeliverOrder.typeSellTransport(String.valueOf(orderPrices[count]/4));

                    clickOnContinue();
                    isViewDisplayed("Order complete!");
                    clickOnMultipleViews("Ok");

                    goToHome();
                }
            }
        }
        clickOnMultipleViews(R.id.button_order_list, R.id.action_refresh);
    }

    /**
     * Test display of buy order list after fulfillment, list should be empty.
     * Correct values to be filled during actual tests.
     */
    @Test
    public void Q_testNoBuyerOrderAfterFulfillment() {

        logIn("nandiadmin", "Nyama@16");
        goToOrderList();
        isViewDisplayed("Sorry, no purchase orders available at the moment.");
        clickOnView(R.id.action_refresh);
        isViewDisplayed("Sorry, no purchase orders available at the moment.");
        logOut();

        logIn("nandiagent", "Nyama@16");
        goToOrderList();
        isViewDisplayed("Sorry, no purchase orders available at the moment.");
        clickOnView(R.id.action_refresh);
        isViewDisplayed("Sorry, no purchase orders available at the moment.");
    }

    /**
     * Search pending cash payments
     */
    @Test
    public void Qi_testSearchCashPayment(){
        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();
        CashPayments.typeSearchName("Yvonneh");
//        isEachViewDisplayed();
        isRecyclerListViewCountEquals(R.id.recycler_view, 2);
    }

    /**
     * Test for display of all pending cash payments before payment.
     * To be edited with correct data during tests.
     */
    @Test
    public void R_testDisplayPendingCashBeforePayments() {

        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();
        isEachViewDisplayed("48.0");

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 17);
        isEachViewDisplayed("168");

        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 16, 35);
        isEachViewDisplayed("3,776.00");
    }

    /**
     * Test for several individual cash payment on the App.
     * To be added logic for bulk payment.
     */
    @Test
    public void S_testDoIndividualCashPayment() {

        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();

        for (int i = 0; i < 5; ++i) {//pays 5 payments individually, left with 36-5=31 payments
            clickOnRecordAt(R.id.recycler_view, 0);
            CashPayments.clickOnPayFarmer();
            isViewDisplayed("Thank you!\nPayments have been marked as paid!");
            clickOnView("Ok");
        }

        isRecyclerListViewCountEquals(R.id.recycler_view, 31);

    }

    /**
     * Test for select &  pay  a few cash payment on the App.
     * To be added logic for bulk payment.
     */
    @Test
    public void T_testSelectAfewAndDoCashPayment() {

        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();

        for (int i = 0; i < 5; ++i) // checks 5 payments, left with 31-5=26 payments
            clickOnRecordAt(R.id.recycler_view, i);

        CashPayments.clickOnPayFarmer();

        isViewDisplayed("Thank you!\nPayments have been marked as paid!");
        clickOnView("Ok");

        isRecyclerListViewCountEquals(R.id.recycler_view, 26);
    }

    @Test
    public void U_testSelectAllCashPayment() {

        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();
        CashPayments.clickOnSelectAll();

        isViewDisplayed("Thank you!\nPayments have been marked as paid!");

        clickOnView("Ok");
        isRecyclerListViewNotDisplayed(R.id.recycler_view);

       // isRecyclerListViewCountEquals(R.id.recycler_view, 12);
    }

    /**
     * Test for display of all pending cash payments after payment.
     * To be edited with correct data during tests.
     */
    @Test
    public void V_testNoPendingCashPaymentMSG() {

        logIn("nandiadmin", "Nyama@16");
        for (int i = 0; i < 3; i++)//Swipe up 3 times to display cash payments
            swipeUpContentView();
        goToReports();
        CashPayments.clickOnSearch();

        isRecyclerListViewNotDisplayed(R.id.recycler_view);
    }

    /**
     * Test for display of all pending cash payments after payment.
     * To be edited with correct data during tests.
     */
    // @Test
    public void R_testDisplayPendingCashAfterPaymentsInCurrentSession() {
        //  logIn("admin", "Nyama@16");

        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
        isRecyclerListViewNotDisplayed(R.id.recycler_view);
    }

    /**
     * test for update of farmer information on the App.
     */
    @Test
    public void X_testUpdateFarmer() {

        logIn("nandiagent", "Nyama@16");

        clickOnView(R.id.button_farmer_list);

        clickOnView("Anneh");

//        onView(allOf(withId(android.R.id.list), isDisplayed()));

        // EspressoUtililities.clickOnMultipleViews("Payment", "Personal");

        EspressoUtililities.swipeUpContentView();

        onView(allOf(withText("Edit"), isDisplayed())).perform(click());

        typeTextOnView(R.id.input_surname,"Annieh"+"-nandi" );


        String[] farmer = TestData.getUpdateFarmer();

        int[] id = {R.id.input_surname, R.id.input_other_names, R.id.input_mobile_number,
                R.id.input_tin, R.id.input_pob};

        // typeTextInMultipleViews(id, farmer);

        String[] gender = {"Male"};
        String[] language = {"English", "Swahili"};


        clickOnView(R.id.input_gender);

        clickOnView(gender[new Random().nextInt(gender.length)]);

        clickOnView(R.id.input_dob);

        clickOnView("OK");

        clickOnView(R.id.input_lang_pref);

        clickOnView(language[new Random().nextInt(language.length)]);

        onView(allOf(withText("Save"), isDisplayed())).perform(click());

        isViewDisplayed("Farmer details was successfully updated!");
        clickOnView("Ok");

        /**
         * update farm information
         */

        onView(allOf(withText("Farm"), isDisplayed())).perform(click());
        onView(allOf(withText("Edit"), isDisplayed())).perform(click());

        typeTextOnView(R.id.input_area, "Kapsaran-East");

        typeTextOnView(R.id.input_address, "413 Kapsaran");

        actionSetProgressBar(R.id.seek_bar_land_size, 8);

        clickOnView(R.id.input_equipment);
        clickOnMultipleViews("Tractor", "Ok");

        clickOnView(R.id.input_crops);
        clickOnMultipleViews("cotton", "Ok");

        clickOnView(R.id.input_animals);
        clickOnMultipleViews("fish", "Ok");

        typeTextOnView(R.id.input_fertilizer, "CAN");

        onView(allOf(withText("Save"), isDisplayed())).perform(click());

        isViewDisplayed("Farmer details was successfully updated!");
        clickOnView("Ok");


        /**
         * Go back to home screen
         */

//        EspressoUtililities.swipeDownContentView();
//
//        clickOnSideMenu("Open navigation drawer");
//
//        clickOnView("Home");
//
//        clickOnView(R.id.button_farmer_list);
//
//        onView(withId(R.id.recycler_view)).inRoot(new ToastMatcher()).
//                check(new RecyclerViewItemCountAssertion(18));

        isViewDisplayed("Annieh");

    }

    /**
     * Logs into the 2kuze application with specified username and password
     */
    public void logIn(String username, String password) {

        clickOnView("English");

        typeTextOnView(R.id.input_mobile_number, username);

        typeTextOnView(R.id.input_password, password);

        clickOnView(R.id.button_login);
    }

    /**
     * First time login, to agree terms and conditions
     *
     * @param username
     * @param password
     */
    public void firstTimeLogin(String username, String password) {

        logIn(username, password);

        clickOnView("Agree");

        clickOnSideMenu("Open navigation drawer");

        swipeUpContentView();

        clickOnView("Logout");

        clickOnView("Ok");
    }
}

/**
 * Action points.
 * Check behaviour of new list items in current session(start from agent drawer activities)
 * check reason why amount due during collection isDisplayed fails
 * Multiple cash payments
 * Add functionality to check if displayed as you scroll/swipe
 * To add logic for selecting adb on start.
 * Used to test multiple devices/emulators
 * Check on espresso cloud tests
 * Services to connect to db, server for things like screen capture, update test case document
 * Add logic for weighing scale device connectivity
 */


