//package com.mastercard.labs.tukuze.client;
//
//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.IdlingPolicies;
//import android.support.test.espresso.action.ViewActions;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//import com.mastercard.labs.tukuze.agent.SelectLanguageActivity;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
//import static com.mastercard.labs.tukuze.client.TestData.buyersList;
//import static com.mastercard.labs.tukuze.client.TestData.produce;
//import static com.mastercard.labs.tukuze.client.TestData.registerFarmers;
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.Matchers.containsString;
//
///**
// * Created by amoi on 18/08/2016.
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)//for ordering the tests
//
//@RunWith(AndroidJUnit4.class)
//public class TukuzeTests_Swahili {
//
//
//    @Rule
//    public ActivityTestRule<SelectLanguageActivity> mActivityRule = new ActivityTestRule<>(SelectLanguageActivity.class);
//
//    /**
//     * Set up method runs before each test method
//     */
//    @Before
//    public void setUp() {
//        IdlingPolicies.setMasterPolicyTimeout(1, TimeUnit.MINUTES);
//        IdlingPolicies.setIdlingResourceTimeout(1, TimeUnit.MINUTES);
//    }
//
//    // @After
//    public void tearDown() {
//
//        try{
//            for(int i=0;i<10;++i)
//                Espresso.pressBack();
//        }
//        catch( Exception e){
//
//        }
//    }
//
//    /**
//     * Verifies whether launch screen has the specified views.
//     */
//    @Test
//    public void A_testLaunchScreen(){
//
//        isEachViewDisplayed("English", "Kiswahili","Select Language / Chagua Lugha");
//    }
//
//    /**
//     * This login is for cases where no weighing scale is gona be used.
//     */
//    //@Test
//    public void B_testFirstLogin(){
//        firstTimeLogin("admin", "Nyama@16");
//        firstTimeLogin("agent", "Nyama@16");
//    }
//
//    /**
//     *
//     * This login is for cases where weighing  scale is  used for emulators.
//     */
//    @Test
//    public  void C_testInitializeWS(){
//
//        logIn("admin", "Nyama@16");
//        clickOnSideMenu("Open navigation drawer");
//        clickOnView("Mipangilio");
//        EspressoUtililities.clickOnSideMenu();
//      //  clickOnMenuItem(R.id.btnSetBluetoothDevice);
//    }
//
//    /**
//     *
//     * Tests message for login with invalid credentials.
//     */
//    @Test
//    public void D_testInvalidCredentialMSG() {
//        logIn("agent1", "Nyama@16");
//        isViewDisplayed("Samahani, Hauwezi kutumia. Maelezo yako haya kukubaliwa");
//    }
//
//    /**
//     *
//     * Test Login with valid credentials
//     */
//    @Test
//    public void E_testValidCredentials() {
//
//        logIn("admin", "Nyama@16");
//        isViewDisplayed("Administrator");
//    }
//
//    /**
//     * Test for agent's farmer(s) registration.
//     */
//    @Test
//    public void F_addMultipleFarmersAsAgent() {
//
//        logIn("agent", "Nyama@16");
//
//        String[][] newFarmers = registerFarmers();
//
//        String[] gender={"Kike", "Kiume"};
//        String[] language={"Kiingereza", "Swahili"};
//
//        for (int count = 0; count < newFarmers.length; ++count) {
//
//            clickOnView(R.id.button_farmer_list);
//
//            clickOnView(R.id.button_add_farmer);
//
//            //populate farmer's personal information
//            String[] farmer = newFarmers[count];
//            int[] id = {R.id.input_surname, R.id.input_other_names, R.id.input_mobile_number,
//                    R.id.input_tin, R.id.input_pob};
//
//            typeTextInMultipleViews(id, farmer);
//
//            clickOnView(R.id.input_gender);
//
//            clickOnView(gender[new Random().nextInt(gender.length)]);
//
//            clickOnView(R.id.input_dob);
//
//            clickOnView("OK");
//
//            clickOnView(R.id.input_lang_pref);
//
//            clickOnView( language[new Random().nextInt(language.length)]);
//
//            clickOnView(R.id.button_continue);
//
//            // Populate farm information
//            if(count%7==0){
//
//                typeTextOnView(R.id.input_area, "Kapsabet-East");
//
//                typeTextOnView(R.id.input_address, "413 Kapsabet");
//
//                actionSetProgressBar(R.id.seek_bar_land_size, 5);
//
//                clickOnView(R.id.input_equipment);
//                clickOnMultipleViews("Tinga", "Jembe", "Sawa");
//
//                clickOnView(R.id.input_crops);
//                clickOnMultipleViews("Pamba", "Alizeti", "Maharagwe", "Mchele", "Mahindi", "Parachichi", "Sawa");
//
//                clickOnView(R.id.input_animals);
//                clickOnMultipleViews("Ngombe", "Mbuzi", "Nyuki", "Kuku", "Sungura", "Sawa");
//
//                typeTextOnView(R.id.input_fertilizer, "DAP");
//
//                clickOnView(R.id.button_continue);
//            }
//            else {
//                clickOnView(R.id.button_continue);
//            }
//            //populate payment information
//            clickOnView("Fedha ya simu");
//            typeTextOnView(R.id.input_account_number2, "0728067003");
//
//            clickOnMultipleViews(R.id.button_continue, R.id.button_continue);
//
//            isViewDisplayed("Mkulima amesajiliwa, ujumbe mfupi utatumwa kwa mkulima.");
//
//            clickOnView("Sawa");
//
//            clickOnSideMenu("Open navigation drawer");
//
//            clickOnView("Mwanzo");
//        }
//    }
//
//    /**
//     *
//     * Test that agent can search farmer, only searched farmer record should be displayed.
//     */
//    @Test
//    public void G_testSeachFarmerByAgent() {
//        logIn("agent", "Nyama@16");
//
//        clickOnView(R.id.button_farmer_list);
//
//        typeTextOnView(R.id.input_search, "Anneh");
//        clickOnView(R.id.button_search);
//
//        isViewDisplayedAllOf("Kihara", "Anneh");
//        isViewsNotExist("Ashford", "Benard", "Bismark");
//    }
//
//    /**
//     *
//     * Test for correct farmer's list display, ordering and swapping up/down.
//     */
//    @Test
//    public void H_testFarmersListAndSwipping() {
//
//        logIn("agent", "Nyama@16");
//
//        clickOnView(R.id.button_farmer_list);
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(getMatchesAllOf("Kihara", "Anneh"))));
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(2))
//                .check(matches(hasDescendant(getMatchesAllOf("Akummu", "Aynsola"))));
//
//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 18);
//        isViewDisplayed("Yvonneh");
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 17, 1);
//
//        isViewDisplayed("Anneh");
//    }
//
//    /**
//     *
//     * Test refresh produce to pull new produces from server
//     * add logic to scroll and check if new items are displayed on the screen.
//     */
//    @Test
//    public void I_testRefreshProduceList() {
//        logIn("admin", "Nyama@16");
//        clickOnView(R.id.button_collect_produce);
//        clickOnMenuItem(R.id.action_refresh);
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 1, 10);
//        isViewDisplayed("watermelon");
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 10, 1);
//        isViewDisplayed("avocado");
//    }
//
//    /**
//     *
//     * Test for correct produce's list display, ordering and swapping up/down.
//     */
//    @Test
//    public void J_testProduceList() {
//
//        logIn("admin", "Nyama@16");
//        clickOnView(R.id.button_collect_produce);
//        String[] produces = produce();
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(getMatchesAllOf(produces[0]))));
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(2))
//                .check(matches(hasDescendant(getMatchesAllOf(produces[2]))));
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(8))
//                .check(matches(hasDescendant(getMatchesAllOf(produces[8]))));
//
//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, 10);
//        isViewDisplayed(produces[9]);
//
//        swipeDownRecyclerViewListItemAtPosition(R.id.recycler_view, 10, 1);
//        isViewDisplayed(produces[2]);
//    }
//
//    /**
//     *
//     * Test adding of multiple buyers
//     */
//    @Test
//    public void K_testAddMultipleBuyers(){
//
//        logIn("admin", "Nyama@16");
//
//
//        String[][] buyers=buyersList();
//
//        for(int i=0;i<buyers.length;++i){
//
//            String[] buyer=buyers[i];
//
//            clickOnView(R.id.button_buyer_list);
//
//            clickOnView(R.id.button_add_buyer);
//
//            typeTextOnView(R.id.txtFirstName,buyer[0]);
//
//            typeTextOnView(R.id.txtLastName, buyer[1]);
//
//            typeTextOnView(R.id.txtPhoneNumber,buyer[2]);
//
//            typeTextOnView(R.id.txtLocation,buyer[3]);
//
//            clickOnView(R.id.button_add_buyer);
//
//            clickOnView("Ok");
//
//            clickOnSideMenu("Open navigation drawer");
//
//            onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//        }
//
//        clickOnView(R.id.button_buyer_list);
//
//        isEachViewDisplayed("Sola","Michael", "Hillary","Gilbert");
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 1,4);
//
//        isEachViewDisplayed( "Francis", "Daniel",  "Charles", "Benard");
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 4,6);
//
//        isEachViewDisplayed( "Alex");
//
//
//    }
//    /**
//     * Test for adding of multiple buy orders.
//     * Please ensure you have populated at the back end with all produce in the produce list.
//     */
//    @Test
//    public void L_testAddMultipleBuyOrders() {
//        logIn("admin", "Nyama@16");
//
//        String[] buyers = TestData.buyers();
//        String[] produce = TestData.produce();
//
//        int quantity = 1;
//
//        for (int count = 0; count < buyers.length; ++count) {
//            //for (int i = 0; i < produce.length; ++i) {
//            for (int i = 0; i < produce.length-9; ++i) {
//
//                clickOnMultipleViews(R.id.button_order_list, R.id.button_add_order);
//
//                clickOnView(R.id.input_produce);
//                clickOnView(produce[i]);
//
//                typeTextOnView(R.id.input_quantity, String.valueOf(quantity));
//
//                clickOnMultipleViews(R.id.input_buyer, R.id.input_buyer);//click on buyer has issues
//                clickOnView(buyers[count]);
//
//                clickOnView(R.id.input_date_needed);
//                onView(Matchers.allOf(withText("23")));
//                clickOnMultipleViews("OK");
//
//                clickOnView(R.id.button_add_order);
//
//                isViewDisplayed("Request Successfully Posted");
//
//                onView(Matchers.allOf(withText("Ok"))).perform(click());
//
//                clickOnSideMenu("Open navigation drawer");
//
//                onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//                quantity++;
//            }
//        }
//    }
//
//    /**
//     *
//     * Test display of buy order list before fulfillment.
//     * Correct values to be filled during actual tests.
//     */
//    @Test
//    public void M_testDisplayOfBuyOrdersBeforeFulfillment() {
//
//        logIn("admin", "Nyama@16");
//
//        clickOnMultipleViews(R.id.button_order_list);
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(getMatchesAllOf("18.0"))));
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 1, 8);
//        isViewDisplayed("11.0");
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 8, 1);
//        isViewDisplayed("17.0");
//    }
//
//    /**
//     *
//     * Test for multiple collections without weighing.
//     * Mutually exclusive to with weighing
//     * Be sure to have changed constants value to false fro simulation.
//     */
//    //@Test
//    public void N_testCollectMultipleWithoutWeighing() {
//        logIn("admin", "Nyama@16");
//
//        String[][] farmers = TestData.registerFarmers();
//        String[] produce = TestData.produce();
//        String[] prices = TestData.collectionWithOutPrices();
//        int priceCount = 0;
//
//        for (int i = 0; i < produce.length-9; ++i) {
//
//            for (int count = 0; count < farmers.length; ++count) {
//                clickOnView(R.id.button_collect_produce);
//                clickOnRecordAt(R.id.recycler_view, i);
//                if (count != 0)
//                    scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, count + 1);
//                clickOnView(farmers[count][1]);
//
//
//                typeTextOnView(R.id.txtCollectedQuantity, String.valueOf(priceCount + 5));
//                typeTextOnView(R.id.txtAgreedAmount, prices[priceCount]);
//
//                clickOnView("Endelea");
//
//                String amountDue = removeNonNumeric(getText(withId(R.id.text_amount_due)));
//                double cash_pay = Double.parseDouble(amountDue) * 0.5;
//                double bank_pay = Double.parseDouble(amountDue) * 0.5;
//
//                typeTextOnView(R.id.input_cash, String.valueOf(cash_pay));
//                typeTextOnView(R.id.input_mobile, String.valueOf(bank_pay));
//
//                clickOnView("Endelea");
////                isViewDisplayed(String.format("Transaction Amount: %s",amountDue));
//
//                clickOnView("Ok");
//
//                clickOnSideMenu("Open navigation drawer");
//                onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//                priceCount++;
//            }
//        }
//    }
//
//    /**
//     *
//     * Tests weigh and collect produce
//     * Be sure to have changed simulation value to true in constants file.
//     * Be sure to have paired the weighing scale and configured it in the settings for real devices.
//     */
//    @Test
//    public void O_testCollectProduceWithWeighing() {
//        logIn("admin", "Nyama@16");
//
//        String[][] farmers = TestData.registerFarmers();
//        String[] produce = TestData.produce();
//        String[] prices = TestData.collectionWithOutPrices();
//        int priceCount = 0;
//
//        for (int i = 0; i < produce.length-9; ++i) {
//            for (int count = 0; count < farmers.length; ++count) {
//                clickOnView(R.id.button_collect_produce);
//
//                clickOnRecordAt(R.id.recycler_view, i);
//
//                if (count != 0)
//                    scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, count + 1);
//                clickOnView(farmers[count][1]);
//
//                clickOnView("Maliza");
//
//                clickOnView("Endelea");
//
//                typeTextOnView(R.id.txtCollectedQuantity, String.valueOf(priceCount/2 + 5));
//                typeTextOnView(R.id.txtAgreedAmount, prices[priceCount]);
//
//                clickOnView("Endelea");
//
//                String amountDue = removeNonNumeric(getText(withId(R.id.text_amount_due)));
//                double cash_pay = Double.parseDouble(amountDue) * 0.5;
//                double bank_pay = Double.parseDouble(amountDue) * 0.5;
//
//                typeTextOnView(R.id.input_cash, String.valueOf(cash_pay));
//                typeTextOnView(R.id.input_mobile, String.valueOf(bank_pay));
//
//                clickOnView("Endelea");
////                isViewDisplayed(String.format("Transaction Amount: %s",amountDue));
//
//                clickOnView("Sawa");
//
//                clickOnSideMenu("Open navigation drawer");
//
//                onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//                priceCount++;
//            }
//        }
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        startTiming(100);
//        clickOnView(R.id.button_reports);
//        clickOnView(R.id.button_search);
//
//        startTiming(100);
//       // isRecyclerListViewCountEquals(R.id.recycler_view,((produce.length-9)*farmers.length));
//    }
//
//    /**
//     *
//     * Test multiple order fulfillment
//     */
//    @Test
//    public void P_testMultipleOrderFulfillment() {
//
//        String[][] prices = TestData.buyOrderPrices();
//        logIn("admin", "Nyama@16");
//
//        String[] paymentModes = {"Fedha", "Benki", "Mkoba wa Simu"};
//        String paymentMode = paymentModes[new Random().nextInt(3)];
//
//        // for (int i = 0; i < prices.length; ++i) {
//        for (int i = 0; i < 18; ++i) {
//            clickOnMultipleViews(R.id.button_order_list);
//
//            clickOnRecycleViewAtPosition(R.id.recycler_view, 0);
//            clickOnView(R.id.sp_payment_mode);
//            clickOnSpinnerPopUpItem(paymentMode);
//
//            typeTextOnView(R.id.input_price, prices[i][0]);
//
//            typeTextOnView(R.id.input_transport_cost, prices[i][1]);
//
//            clickOnMultipleViews("Sawa");
//
//            isViewDisplayed("Agizo limekamilishwa!");
//
//            clickOnMultipleViews("Sawa");
//
//            clickOnSideMenu("Open navigation drawer");
//
//            clickOnView("Mwanzo");
//        }
//        clickOnMultipleViews(R.id.button_order_list,R.id.action_refresh);
//    }
//
//    /**
//     *
//     * Test display of buy order list after fulfillment, list should be empty.
//     * Correct values to be filled during actual tests.
//     */
//    @Test
//    public void Q_testNoBuyerOrderAfterFulfillment() {
//
//        logIn("admin", "Nyama@16");
//        clickOnMultipleViews(R.id.button_order_list);
//        clickOnView(R.id.action_refresh);
//        isViewDisplayed("Samahani, hakuna maagizo katika mfumo.");
//    }
//
//    /**
//     *
//     * Test for display of all pending cash payments before payment.
//     * To be edited with correct data during tests.
//     */
//    @Test
//    public void R_testDisplayPendingCashBeforePayments() {
//
//        logIn("admin", "Nyama@16");
//
//        for(int i=0;i<3;i++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(getMatchesAllOf("60.00"))));
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view,1,17);
//        isViewDisplayed("220.00");
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view,16,35);
//        isViewDisplayed("400.00");
//    }
//
//    /**
//     *
//     * Test for several individual cash payment on the App.
//     * To be added logic for bulk payment.
//     */
//    @Test
//    public void S_testDoIndividualCashPayment() {
//
//        logIn("admin", "Nyama@16");
//
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//
//        for (int i = 0; i < 5; ++i) {//pays 5 payments individually, left with 36-5=31 payments
//            clickOnRecordAt(R.id.recycler_view, 0);
//            clickOnView(R.id.button_pay_farmer);
//            isViewDisplayed("Ahsante! \nMalipo uliyoidhinisha yamekamilika.");
//            clickOnView("Sawa");
//        }
//
//        onView(withId(R.id.recycler_view)).inRoot(new ToastMatcher()).
//                check(new RecyclerViewItemCountAssertion(31));
//
//    }
//
//    /**
//     *
//     * Test for select &  pay  a few cash payment on the App.
//     * To be added logic for bulk payment.
//     */
//    @Test
//    public void T_testSelectAfewAndDoCashPayment() {
//
//        logIn("admin", "Nyama@16");
//
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//
//        for (int i = 0; i < 5; ++i) // checks 5 payments, left with 31-5=26 payments
//            clickOnRecordAt(R.id.recycler_view, i);
//
//        clickOnView(R.id.button_pay_farmer);
//        isViewDisplayed("Ahsante! \nMalipo uliyoidhinisha yamekamilika.");
//        clickOnView("Sawa");
//
//        onView(withId(R.id.recycler_view)).inRoot(new ToastMatcher()).
//                check(new RecyclerViewItemCountAssertion(26));
//    }
//
//    @Test
//    public void U_testSelectAllCashPayment() {
//
//        logIn("admin", "Nyama@16");
//
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view,3,0);
//
//        clickOnView(R.id.action_select_all);
//
//        clickOnView(R.id.button_pay_farmer);
//
//        isViewDisplayed("Ahsante! \nMalipo uliyoidhinisha yamekamilika.");
//        clickOnView("Sawa");
//
//        onView(withId(R.id.recycler_view)).inRoot(new ToastMatcher()).
//                check(new RecyclerViewItemCountAssertion(0));
//    }
//
//    /**
//     * Test for display of all pending cash payments after payment.
//     * To be edited with correct data during tests.
//     */
//    @Test
//    public void V_testNoPendingCashPaymentMSG() {
//
//        logIn("admin", "Nyama@16");
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//        isRecyclerListViewNotDisplayed(R.id.recycler_view);
//    }
//
//    /**
//     *
//     * Tests collect produce without weighing.
//     * Be sure to have changed simulation value to false in constants file.
//     * Be sure to have paired the weighing scale and configured it in the settings for real devices.
//     */
//    @Test
//    public void W_testCollectProduceWithOutWeighing() {
//
//        logIn("admin", "Nyama@16");
//
//        clickOnSideMenu("Open navigation drawer");
//        clickOnView("Mipangilio");
//
//        clickLongOnView(R.id.btnSetBluetoothDevice);
//
//        clickOnSideMenu("Open navigation drawer");
//        onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//        String[][] farmers = TestData.registerFarmers();
//        String[] produce = TestData.produce();
//        String[] prices = TestData.collectionWithOutPrices();
//
//        int priceCount = 0;
//
//        for (int i = 0; i < produce.length-9; ++i) {
//
//            for (int count = 0; count < farmers.length-16; ++count) {
//                clickOnView(R.id.button_collect_produce);
//
//                clickOnRecordAt(R.id.recycler_view, i);
//
//                if (count != 0)
//                    scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, count + 1);
//                clickOnView(farmers[count][1]);
//
//                typeTextOnView(R.id.txtCollectedQuantity, String.valueOf(priceCount/2 + 5));
//                typeTextOnView(R.id.txtAgreedAmount, prices[priceCount]);
//
//                clickOnView("Endelea");
//
//                String amountDue = removeNonNumeric(getText(withId(R.id.text_amount_due)));
//                double cash_pay = Double.parseDouble(amountDue) * 0.5;
//                double bank_pay = Double.parseDouble(amountDue) * 0.5;
//
//                typeTextOnView(R.id.input_cash, String.valueOf(cash_pay));
//                typeTextOnView(R.id.input_mobile, String.valueOf(bank_pay));
//
//                clickOnView("Endelea");
//
//                clickOnView("Sawa");
//
//                clickOnSideMenu("Open navigation drawer");
//
//                onView(Matchers.allOf(withText(containsString("Mwanzo")))).perform(click());
//
//                priceCount++;
//            }
//        }
//
//        for(int k=0;k<1;k++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        startTiming(100);
//        clickOnView(R.id.button_reports);
//        clickOnView(R.id.button_search);
//
//        isRecyclerListViewCountEquals(R.id.recycler_view,4);
//
//    }
//    /**
//     *
//     * Test for display of all pending cash payments after payment.
//     * To be edited with correct data during tests.
//     */
//    // @Test
//    public void R_testDisplayPendingCashAfterPaymentsInCurrentSession() {
//        //  logIn("admin", "Nyama@16");
//
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//        isRecyclerListViewNotDisplayed(R.id.recycler_view);
//    }
//
//    /**
//     * test for update of farmer information on the App.
//     */
//    @Test
//    public void X_testUpdateFarmer() {
//
//        logIn("agent", "Nyama@16");
//
//        clickOnView(R.id.button_farmer_list);
//
//        clickOnView("Anneh");
//
//        EspressoUtililities.swipeUpContentView();
//
//        onView(allOf(withText("Badilisha"), isDisplayed())).perform(click());
//
//
//        String[] farmer = TestData.getUpdateFarmer();
//
//        int[] id = {R.id.input_surname, R.id.input_other_names, R.id.input_mobile_number,
//                R.id.input_tin, R.id.input_pob};
//
//        typeTextInMultipleViews(id, farmer);
//
//        String[] gender={"Kike", "Kiume"};
//
//        String[] language={"Kiingereza", "Swahili"};
//
//
//
//        clickOnView(R.id.input_gender);
//
//        clickOnView(gender[new Random().nextInt(gender.length)]);
//
//        clickOnView(R.id.input_dob);
//
//        clickOnView("OK");
//
//        clickOnView(R.id.input_lang_pref);
//
//        clickOnView(language[new Random().nextInt(language.length)]);
//
//        onView(allOf(withText("Hifadhi"), isDisplayed())).perform(click());
//        isViewDisplayed("Maelezo ya mkulima yamebadilishwa kikamilifu");
//        clickOnView("Sawa");
//
//        /**
//         * update farm information
//         */
//
//        onView(allOf(withText("Shamba"), isDisplayed())).perform(click());
//        onView(allOf(withText("Badilisha"), isDisplayed())).perform(click());
//
//        typeTextOnView(R.id.input_area, "Kapsaran-East");
//
//        typeTextOnView(R.id.input_address, "413 Kapsaran");
//
//        actionSetProgressBar(R.id.seek_bar_land_size, 8);
//
//        clickOnView(R.id.input_equipment);
//        clickOnMultipleViews("Tinga", "Jembe", "Sawa");
//
//        clickOnView(R.id.input_crops);
//        clickOnMultipleViews("Pamba", "Alizeti", "Maharagwe", "Mchele", "Mahindi", "Parachichi", "Sawa");
//
//        clickOnView(R.id.input_animals);
//        clickOnMultipleViews("Ngombe", "Mbuzi", "Nyuki", "Kuku", "Sungura", "Sawa");
//
//
//        typeTextOnView(R.id.input_fertilizer, "CAN");
//
//        onView(allOf(withText("Hifadhi"), isDisplayed())).perform(click());
//        isViewDisplayed("Maelezo ya mkulima yamebadilishwa kikamilifu");
//        clickOnView("Sawa");
//
//
//        isViewDisplayed("Annieh");
//
//    }
//    /**
//     * Logs into the 2kuze application with specified username and password
//     */
//    public void logIn(String username, String password) {
//
//        clickOnView("Kiswahili");
//
//        typeTextOnView(R.id.input_mobile_number, username);
//
//        typeTextOnView(R.id.input_password, password);
//
//        clickOnView(R.id.button_login);
//    }
//
//    /**
//     *
//     * First time login, to agree terms and conditions
//     * @param username
//     * @param password
//     */
//    public  void firstTimeLogin(String username, String password) {
//
//        logIn(username, password);
//
//        clickOnView("Agree");
//
//        clickOnSideMenu("Open navigation drawer");
//
//        swipeUpContentView();
//
//        clickOnView("Logout");
//
//        clickOnView("Ok");
//    }
//}
//
///**
// *
// * Action points.
// * Check behaviour of new list items in current session(start from agent drawer activities)
// * check reason why amount due during collection isDisplayed fails
// * Multiple cash payments
// * Add functionality to check if displayed as you scroll/swipe
// * To add logic for selecting adb on start.
// * Used to test multiple devices/emulators
// * Check on espresso cloud tests
// * Services to connect to db, server for things like screen capture, update test case document
// * Add logic for weighing scale device connectivity
// */
//
//
