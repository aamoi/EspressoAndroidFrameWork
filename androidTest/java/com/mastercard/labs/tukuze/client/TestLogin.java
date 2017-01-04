//package com.mastercard.labs.tukuze.client;
///**
// * Created by amoi on 08/06/2016.
// */
//
//import android.support.test.espresso.IdlingPolicies;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//
//import com.mastercard.labs.tukuze.agent.SelectLanguageActivity;
//
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
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnMenuItem;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnMultipleViews;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnRecordAt;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnRecycleViewAtPosition;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnSideMenu;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnSpinnerPopUpItem;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.clickOnView;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.getMatchesAllOf;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.getText;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.isEachViewDisplayed;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.isRecyclerListViewNotDisplayed;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.isViewDisplayed;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.isViewDisplayedAllOf;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.isViewsNotExist;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.removeNonNumeric;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.scrollRecycleViewItemBetweenPosition;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.setProgress;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.startTiming;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.swipeDownRecyclerViewListItemAtPosition;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.swipeUpContentView;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.swipeVerticalBetweenRecyclerViewItemPositions;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.typeTextInMultipleViews;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.typeTextOnView;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.withRecyclerView;
//import static com.mastercard.labs.tukuze.client.TestData.buyersList;
//import static com.mastercard.labs.tukuze.client.TestData.produce;
//import static com.mastercard.labs.tukuze.client.TestData.registerFarmers;
//import static org.hamcrest.CoreMatchers.allOf;
//import static org.hamcrest.Matchers.containsString;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)//for ordering the tests
//
//@RunWith(AndroidJUnit4.class)
//public class TestLogin {
//    @Rule
//     //public ActivityTestRule<AgentDrawerActivity> mActivityRule = new ActivityTestRule<>(AgentDrawerActivity.class);
//    //public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);
//    public ActivityTestRule<SelectLanguageActivity> mActivityRule = new ActivityTestRule<>(SelectLanguageActivity.class);
//    //private  IdlingResourceMap idlingResource;
//    /**
//     * Set up method runs before each test method
//     */
//    @Before
//    public void setUp() {
//        IdlingPolicies.setMasterPolicyTimeout(3, TimeUnit.MINUTES);
//        IdlingPolicies.setIdlingResourceTimeout(3, TimeUnit.MINUTES);
//    }
//
//    /**
//     *
//     * This login is for cases where no weighing scale is gona be used.
//     */
////    @Test
//    public void a_firstLogin(){
////      firstTimeLogin("admin", "Nyama@16");
//      firstTimeLogin("agent", "Nyama@16");
//
//    }
//    /**
//     *
//     * This login is for cases where weighing  scale is gona be used.
//     */
//   // @Test
//    public  void A_initializeTest(){
//        firstTimeLogin("agent", "Nyama@16");
//        firstTimeLogin("admin", "Nyama@16");
//        setUpScaleSimulation("admin", "Nyama@16");
//    }
//    /**
//     *
//     *
//     * Tests message for login with invalid credentials.
//     */
//    @Test
//    public void Aa_testInvalidCredentialMSG() {
//        logIn("agent1", "Nyama@16");
//        isViewDisplayed("Sorry, access denied. Your login credentials are invalid.");
//    }
//
//    /**
//     * Test Login with valid credentials
//     */
//    @Test
//    public void B_testValidCredentials() {
//        logIn("admin", "Nyama@16");
//
//        isViewDisplayed("Administrator");
//    }
//
//    /**
//     * Test for agent's farmer(s) registration.
//     */
//    //@Test
//    public void C_addMultipleFarmersAsAgent() {
//
//        logIn("agent", "Nyama@16");
//
//
//        String[][] newFarmers = registerFarmers();
//
//        String[] gender={"Female", "Male"};
//        String[] language={"English", "Swahili"};
//
//        for (int count = 0; count < newFarmers.length; ++count) {
//            startTiming(100);
//            clickOnView(R.id.button_farmer_list);
//
//            startTiming(100);
//            clickOnView(R.id.button_add_farmer);
//            /**
//             *
//             * populate farmer's personal information
//             */
//            String[] farmer = newFarmers[count];
//            int[] id = {R.id.input_surname, R.id.input_other_names, R.id.input_mobile_number,
//                    R.id.input_tin, R.id.input_pob};
//            typeTextInMultipleViews(id, farmer);
//
//            clickOnView(R.id.input_gender);
//            clickOnView( gender[new Random().nextInt(gender.length)]);
//
//            clickOnView(R.id.input_dob);
//            onView(Matchers.allOf(withText("22")));
//            clickOnMultipleViews("OK");
//
//            clickOnView(R.id.input_lang_pref);
//            clickOnView( language[new Random().nextInt(language.length)]);
//
//            clickOnMultipleViews(R.id.button_continue);
//            /**
//             *
//             * Populate farm information
//             */
//            if(count%7==0){
//                typeTextOnView(R.id.input_area, "Kapsabet-East");
//
//                typeTextOnView(R.id.input_address, "413 Kapsabet");
//
//                onView(withId(R.id.seek_bar_land_size)).perform(setProgress(5));
//
//                clickOnView(R.id.input_equipment);
//                clickOnMultipleViews("Tractor", "Hand", "Ok");
//
//                clickOnView(R.id.input_crops);
//                clickOnMultipleViews("Cotton", "Sunflower", "Beans", "Rice", "Maize", "Avocado", "Ok");
//
//                clickOnView(R.id.input_animals);
//                clickOnMultipleViews("Cattle", "Goats", "Bees", "Chicken", "Rabbits", "Ok");
//
//                typeTextOnView(R.id.input_fertilizer, "DAP");
//
//                clickOnView(R.id.button_continue);
//            }
//            else {
//                clickOnView(R.id.button_continue);
//            }
//            /**
//             * populate payment information
//             */
//            clickOnView("Mobile");
//            typeTextOnView(R.id.input_account_number2, "0728067003");
//            //pressBack();
//            clickOnMultipleViews(R.id.button_continue, R.id.button_continue);
//            isViewDisplayed("The farmer has been registered, a confirmation SMS will be sent to the farmer.");
//
//            startTiming(500);
//            onView(Matchers.allOf(withText("Ok"))).perform(click());
//
//            clickOnSideMenu("Open navigation drawer");
//            startTiming(200);
//            onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//        }
//    }
//
//    /**
//     *
//     * Test that agent can search farmer, only searched farmer record should be displayed.
//     */
//    @Test
//    public void D_testSeachFarmerByAgent() {
//        logIn("agent", "Nyama@16");
//
//        startTiming(100);
//        clickOnView(R.id.button_farmer_list);
//
//        typeTextOnView(R.id.input_search, "Anneh");
//        clickOnView(R.id.button_search);
//
//        startTiming(100);
//        isViewDisplayedAllOf("Kihara", "Anneh");
//        isViewsNotExist("Ashford", "Benard", "Bismark");
//    }
//
//    /**
//     *
//     * Test for correct farmer's list display, ordering and swapping up/down.
//     */
//    @Test
//    public void E_testFarmersListAndSwipping() {
//
//        logIn("agent", "Nyama@16");
//
//        startTiming(100);
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
//    //@Test
//    public void F_testRefreshProduceList() {
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
//    public void G_testProduceList() {
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
//    public void H_testAddMultipleBuyers(){
//
//        logIn("admin", "Nyama@16");
//
//
//        String[][] buyers=buyersList();
//
//       for(int i=0;i<buyers.length;++i){
//
//           String[] buyer=buyers[i];
//
//           clickOnView(R.id.button_buyer_list);
//
//           clickOnView(R.id.button_add_buyer);
//
//           typeTextOnView(R.id.txtFirstName,buyer[0]);
//
//           typeTextOnView(R.id.txtLastName, buyer[1]);
//
//           typeTextOnView(R.id.txtPhoneNumber,buyer[2]);
//
//           typeTextOnView(R.id.txtLocation,buyer[3]);
//
//           clickOnView(R.id.button_add_buyer);
//
//           clickOnView("Ok");
//
//           startTiming(100);
//
//           clickOnSideMenu("Open navigation drawer");
//           startTiming(100);
//
//           onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//
//       }
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
//
//    /**
//     *
//     * View buyers
//     */
//    public void testViewBuyers(){
//
//        logIn("admin", "Nyama@16");
//
//        clickOnView(R.id.button_buyer_list);
//
//        isEachViewDisplayed();
//
//    }
//
//    /**
//     *
//     * Test for adding of multiple buy orders.
//     * Please ensure you have populated at the back end with all produce in the produce list.
//     */
//    @Test
//    public void Hh_testAddMultipleBuyOrders() {
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
//                startTiming(100);
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
//                startTiming(200);
//
//              //  isViewDisplayed("Request Successfuly Posted");
//
//                onView(Matchers.allOf(withText("Ok"))).perform(click());
//
//                clickOnSideMenu("Open navigation drawer");
//                startTiming(100);
//                onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
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
//    public void I_testDisplayOfBuyOrdersBeforeFulfillment() {
//
//        logIn("admin", "Nyama@16");
//
//        clickOnMultipleViews(R.id.button_order_list);
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
//                .check(matches(hasDescendant(getMatchesAllOf("18.0"))));
//
//        startTiming(100);
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 1, 8);
//        isViewDisplayed("11.0");
//
//        startTiming(100);
//        swipeVerticalBetweenRecyclerViewItemPositions(R.id.recycler_view, 8, 1);
//        isViewDisplayed("17.0");
//    }
//
//    /**
//     *
//     * Test refresh orders to pull all  new orders from server
//     * add logic to scroll and check if new items are displayed on the screen.
//     */
//    // @Test
//    public void J_testRefreshOrderList() {
//        logIn("admin", "Nyama@16");
//        clickOnView(R.id.button_order_list);
//        clickOnMenuItem(R.id.action_refresh);
//        isViewDisplayed("18.0");
//    }
//
//    /**
//     *
//     * Test for multiple collections without weighing.
//     * Mutually exclusive to with weighing
//     * Be sure to have changed constants value to false fro simulation.
//     */
//    //@Test
//    public void K_testCollectMultipleWithoutWeighing() {
//        logIn("admin", "Nyama@16");
//
//        String[][] farmers = TestData.registerFarmers();
//        String[] produce = TestData.produce();
//        String[] prices = TestData.collectionWithOutPrices();
//        int priceCount = 0;
//
////        for (int i = 0; i < produce.length; ++i) {
//        for (int i = 0; i < produce.length-9; ++i) {
//
//            for (int count = 0; count < farmers.length; ++count) {
//                startTiming(100);
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
//                startTiming(100);
//                clickOnView("Continue");
//
//                String amountDue = removeNonNumeric(getText(withId(R.id.text_amount_due)));
//                double cash_pay = Double.parseDouble(amountDue) * 0.5;
//                double bank_pay = Double.parseDouble(amountDue) * 0.5;
//
//                typeTextOnView(R.id.input_cash, String.valueOf(cash_pay));
//                typeTextOnView(R.id.input_mobile, String.valueOf(bank_pay));
//
//                startTiming(100);
//                clickOnView("Continue");
////                isViewDisplayed(String.format("Transaction Amount: %s",amountDue));
//
//                clickOnView("Ok");
//
//                clickOnSideMenu("Open navigation drawer");
//                startTiming(100);
//                onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//
//                priceCount++;
//            }
//        }
//    }
//
//    /**
//     *
//     * Tests weigh and collect produce
//     * Be sure to have changed simulation value to false in constants file.
//     * Be sure to have paired the weighing scale and configured it in the settings for real devices.
//     */
//    @Test
//    public void L_testCollectProduceWithWeighing() {
//        logIn("admin", "Nyama@16");
//
//        String[][] farmers = TestData.registerFarmers();
//        String[] produce = TestData.produce();
//        String[] prices = TestData.collectionWithOutPrices();
//        int priceCount = 0;
//
//        for (int i = 0; i < produce.length-9; ++i) {
//            for (int count = 0; count < farmers.length; ++count) {
//                startTiming(100);
//                clickOnView(R.id.button_collect_produce);
//
//                startTiming(100);
//                clickOnRecordAt(R.id.recycler_view, i);
//
//                if (count != 0)
//                    scrollRecycleViewItemBetweenPosition(R.id.recycler_view, 1, count + 1);
//                clickOnView(farmers[count][1]);
//
//                startTiming(100);
//                clickOnView("Done");
//
//                startTiming(100);
//                clickOnView("Continue");
//
//                typeTextOnView(R.id.txtCollectedQuantity, String.valueOf(priceCount + 5));
//                typeTextOnView(R.id.txtAgreedAmount, prices[priceCount]);
//
//                startTiming(100);
//                clickOnView("Continue");
//
//                String amountDue = removeNonNumeric(getText(withId(R.id.text_amount_due)));
//                double cash_pay = Double.parseDouble(amountDue) * 0.5;
//                double bank_pay = Double.parseDouble(amountDue) * 0.5;
//
//                typeTextOnView(R.id.input_cash, String.valueOf(cash_pay));
//                typeTextOnView(R.id.input_mobile, String.valueOf(bank_pay));
//
//                startTiming(100);
//                clickOnView("Continue");
////                isViewDisplayed(String.format("Transaction Amount: %s",amountDue));
//
//                clickOnView("Ok");
//
//                clickOnSideMenu("Open navigation drawer");
//                startTiming(100);
//                onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//
//                priceCount++;
//            }
//        }
//    }
//
//    /**
//     *
//     * Test multiple order fulfillment
//     */
//    @Test
//    public void M_testMultipleOrderFulfillment() {
//
//        String[][] prices = TestData.buyOrderPrices();
//        logIn("admin", "Nyama@16");
//
//        String[] paymentModes = {"Cash", "Bank", "Mobile"};
//        String paymentMode = paymentModes[new Random().nextInt(3)];
//
//        // for (int i = 0; i < prices.length; ++i) {
//        for (int i = 0; i < 19; ++i) {
//
//            startTiming(100);
//            clickOnMultipleViews(R.id.button_order_list);
//            clickOnRecycleViewAtPosition(R.id.recycler_view, 0);
//            clickOnView(R.id.sp_payment_mode);
//            clickOnSpinnerPopUpItem(paymentMode);
//
//            typeTextOnView(R.id.input_price, prices[i][0]);
//            typeTextOnView(R.id.input_transport_cost, prices[i][1]);
//            clickOnMultipleViews("Ok");
//            isViewDisplayed("Order complete!");
//            clickOnMultipleViews("Ok");
//
//            startTiming(100);
//            clickOnSideMenu("Open navigation drawer");
//
//            startTiming(100);
//            clickOnView("Home");
//        }
//    }
//
//    /**
//     *
//     * Test display of buy order list after fulfillment, list should be empty.
//     * Correct values to be filled during actual tests.
//     */
//    @Test
//    public void N_testDisplayOfBuyOrdersAfterFulfillment() {
//        logIn("admin", "Nyama@16");
//        clickOnMultipleViews(R.id.button_order_list);
//        isRecyclerListViewNotDisplayed(R.id.recycler_view);
//    }
//
//    /**
//     *
//     * Test for display of all pending cash payments before payment.
//     * To be edited with correct data during tests.
//     */
//    @Test
//    public void O_testDisplayPendingCashBeforePayments() {
//
//        logIn("admin", "Nyama@16");
//        startTiming(100);
//
//        for(int i=0;i<3;i++)//Swipe up 3 times to display cash payments
//        swipeUpContentView();
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
//     * Test for several serial cash payment on the App.
//     * To be added logic for bulk payment.
//     */
//    @Test
//    public void P_testDoSeveralCashPayment() {
//
//        logIn("admin", "Nyama@16");
//
//        for(int i=0;i<3;i++)//Swipe up 3 times to display cash payments
//            swipeUpContentView();
//
//        //Please change 36 to your preferredd record number
//        for (int i = 0; i < 36; ++i) {
//            startTiming(100);
//            clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//
//            clickOnRecordAt(R.id.recycler_view, 0);
//            clickOnView(R.id.button_pay_farmer);
//            isViewDisplayed("Thank you!\nPayments have been marked as paid!");
//            clickOnView("Ok");
//
//            startTiming(100);
//            clickOnSideMenu("Open navigation drawer");
//            startTiming(100);
//            clickOnView("Home");
//        }
//    }
//
//    /**
//     * Test for display of all pending cash payments after payment.
//     * To be edited with correct data during tests.
//     */
//    @Test
//    public void Q_testDisplayPendingCashAfterPayments() {
//        logIn("admin", "Nyama@16");
//
//        startTiming(100);
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//        isRecyclerListViewNotDisplayed(R.id.recycler_view);
//    }
//
//    /**
//     *
//     * Test for display of all pending cash payments after payment.
//     * To be edited with correct data during tests.
//     */
//    // @Test
//    public void R_testDisplayPendingCashAfterPaymentsInCurrentSession() {
//        //  logIn("admin", "Nyama@16");
//
//        startTiming(100);
//        clickOnMultipleViews(R.id.button_reports, R.id.button_search);
//        isRecyclerListViewNotDisplayed(R.id.recycler_view);
//    }
//
//    //@Test
//    public void S_testMenu() {
//        clickOnView(R.id.button_english);
//        logIn("admin", "Nyama@16");
//        clickOnSideMenu("Open navigation drawer");
//
//        onView(allOf(withText(containsString("llect"))));
//        getMatchesAllOf("llect", "roduce");
//    }
//
//    /**
//     * Logs into the 2kuze application with specified username and password
//     */
//    public void logIn(String username, String password) {
//        clickOnView("English");
//        typeTextOnView(R.id.input_mobile_number, username);
//        typeTextOnView(R.id.input_password, password);
//        clickOnView(R.id.button_login);
//    }
//    /**
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
//        startTiming(100);
//        clickOnSideMenu("Open navigation drawer");
//
//        startTiming(100);
//        clickOnView("Logout");
//
//        startTiming(100);
//        clickOnView("Ok");
//
//    }
//    /**
//     * Set up device to use simulation for weighing scale
//     */
//    public  void setUpScaleSimulation(String username, String password){
//        if(username.equals("admin")){
//
//            logIn(username, password);
//
//            startTiming(100);
//            clickOnSideMenu("Open navigation drawer");
//
//            startTiming(100);
//            clickOnView("Setting");
//
//            startTiming(100);
//            clickOnMenuItem(R.id.btnSetBluetoothDevice);
//        }
//    }
//}
///**
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
