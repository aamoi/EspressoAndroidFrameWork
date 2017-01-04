//package com.mastercard.labs.tukuze.client;
//
//import android.support.test.espresso.IdlingPolicies;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//import android.util.Log;
//import com.mastercard.labs.tukuze.agent.SelectLanguageActivity;
//import static com.mastercard.labs.tukuze.client.CreateFarmerForm.typeFertilizer;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
//import static com.mastercard.labs.tukuze.client.NMBPageObjectsEnglish.getCashBalance;
//import static com.mastercard.labs.tukuze.client.NMBPageObjectsEnglish.getWalletBalance;
//import static com.mastercard.labs.tukuze.client.SplitPaymentScreen.getTotals;
//import static com.mastercard.labs.tukuze.pageobjects.NMBPageObjectsEnglish.*;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.mastercard.labs.tukuze.client.R.id;
//import static com.mastercard.labs.tukuze.client.TestData.registerFarmers;
//import static org.hamcrest.CoreMatchers.allOf;
//
///**
// * Created by amoi on 18/08/2016.
// */
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)//for ordering the tests
//
//@RunWith(AndroidJUnit4.class)
//public class NMBEnglishTests {
//
//    @Rule
//    public ActivityTestRule<SelectLanguageActivity> mActivityRule = new ActivityTestRule<>(SelectLanguageActivity.class);
//
//    @Before
//    public void setUp() {
//        IdlingPolicies.setMasterPolicyTimeout(180, TimeUnit.SECONDS);
//    }
//
//    /**
//     * Verifies whether launch screen has the specified views.
//     */
//    @Test
//    public void A_testLaunchScreen() {
//        isEachViewDisplayed("English", "Kiswahili", "Select Language / Chagua Lugha");
//    }
//
//    /**
//     * test that all modules/buttons are displayed on home screen
//     */
//    @Test
//    public void B_testHomeScreen() {
//        logIn("meruagent", "Nyama@16");
//        isEachViewDisplayed("Price\nList", "Collect\nProduce", "Farmer\nList");
//        isObjectsEquals(removeNonNumeric(getCashBalance()),"828207.11");
//        isObjectsEquals(removeNonNumeric(getWalletBalance()),"659751.35");
//
//    }
//
//    /**
//     * This login is for cases where no weighing scale is gona be used.
//     */
//    @Test
//    public void B_testFirstLogin() {
//        firstTimeLogin("meruadmin", "Nyama@16");
//        firstTimeLogin("meruagent", "Nyama@16");
//    }
//
//    /**
//     * This login is for cases where weighing  scale is  used for emulators.
//     */
//    @Test
//    public void C_testInitializeWS() {
//
//        logIn("meruadmin", "Nyama@16");
//
//        clickOnSideMenu("Open navigation drawer");
//
//        clickOnView("Setting");
//
//        clickOnView(id.btnSetBluetoothDevice);
//    }
//
//    /**
//     * Tests message for login with invalid credentials.
//     */
//    @Test
//    public void D_testInvalidCredentialMSG() {
//        logIn("agent1", "Nyama@16");
//        isViewDisplayed("Sorry, access denied. Your login credentials are invalid.");
//    }
//
//    /**
//     * Test Login with valid credentials
//     */
//    @Test
//    public void E_testValidCredentials() {
//
//        logIn("meruagent", "Nyama@16");
//        isViewDisplayed("Meru Agent");
//    }
//
//    /**
//     * Test for agent's farmer(s) registration.
//     */
//    @Test
//    public void F_addMultipleFarmers() {
//
//        logIn("meruadmin", "Nyama@16");
//
//        String[][] newFarmers = registerFarmers();
//
//        String[] gender = {"Female", "Male"};
//        String[] language = {"English", "Swahili"};
//
//        // for (int k = 0; k < 15; ++k) {//////
//
//        for (int count = 0; count < newFarmers.length; ++count) {
//
//            goToFarmerList();
//
//            FarmerList.clickOnAddFarmer();
//
//            //populate farmer's personal information
//            String[] farmer = newFarmers[count];
//
//            CreateFarmerForm.typeSurName(farmer[0] + "-meru");
//
//            CreateFarmerForm.typeOtherName(farmer[1] + "-meru");
//
//            CreateFarmerForm.typeMobileNo(farmer[2]);
//
//            CreateFarmerForm.typePIN(farmer[3]);
//
//            CreateFarmerForm.typePOB(farmer[4]);
//
//            CreateFarmerForm.clickOnGender();
//
//            CreateFarmerForm.selectGender(gender[new Random().nextInt(gender.length)]);
//            CreateFarmerForm.clickOnDOB();
//            CreateFarmerForm.selectCurrentDate();
//
//            CreateFarmerForm.clickOnLanguagePref();
//            CreateFarmerForm.selectLanguage(language[new Random().nextInt(language.length)]);
//            CreateFarmerForm.clickOnContinue();
//
//            // Populate farm information
//            if (count % 7 == 0) {
//
//                CreateFarmerForm.typeArea("Kapsabet area");
//                CreateFarmerForm.typeAddress("kapsabet-East");
//
//                CreateFarmerForm.selectLandSize(5);
//
//                CreateFarmerForm.clickOnEquipments();
//                CreateFarmerForm.selectEquipment("Tractor", "Hand");
//
////                CreateFarmerForm.clickOnCrops();
////                CreateFarmerForm.selectCrops("meru-coffee");
//
//
//                CreateFarmerForm.clickOnAnimals();
//                CreateFarmerForm.selectAnimals("meru-chicken");
//
//                typeFertilizer("DAP");
//
//            }
//            CreateFarmerForm.clickOnContinue();
//
//            //populate payment information
//            CreateFarmerForm.clickMoMoPaymentOption();
//            CreateFarmerForm.typeMoMoAccount("0674361932");
//
//            CreateFarmerForm.clickOnContinue();
//            CreateFarmerForm.clickOnContinue();
//
//            isViewDisplayed("The farmer has been registered, a confirmation SMS will be sent to the farmer.");
//
//            clickOnView("Ok");
//
//            actionOnViewSwipeDown(R.id.text_other_names, 4);
//
//            goToHome();
//        }
//        // }
//    }
//
//
//    /**
//     * Test that agent can search farmer, only searched farmer record should be displayed.
//     */
//    @Test
//    public void G_testSeachFarmer() {
//
//        logIn("meruagent", "Nyama@16");
//
//        NMBPageObjectsEnglish.goToFarmerList();
//
//        String[] farmer = TestData.registerFarmers()[TestData.registerFarmers().length-1];
//
//        FarmerList.typeSearchFarmer(farmer[0]);
//
//        FarmerList.clickOnSearchFarmer();
//
////      isEachViewDisplayed("Daniel-meru", "Daureen-meru", "David-meru");
//
//        isEachViewDisplayed(farmer[0]+"-meru", farmer[1]+"-meru", farmer[2]);
//
//
//        logOut();
//    }
//
//    /**
//     * Test for correct farmer's list display, ordering and swapping up/down.
//     */
//    @Test
//    public void H_testSwipeFarmersList() {
//
//        logIn("meruagent", "Nyama@16");
//
//        NMBPageObjectsEnglish.goToFarmerList();
//
//        String[][] farmers = TestData.registerFarmers();
//
//        isEachViewDisplayed(farmers[0][1] + "-meru", farmers[1][1] + "-meru", farmers[2][1] + "-meru");
//
//        scrollRecycleViewItemBetweenPosition(id.recycler_view, 1, 18);
//
//        isEachViewDisplayed(farmers[17][1] + "-meru", farmers[16][1] + "-meru", farmers[15][1] + "-meru");
//    }
//
//
//    /**
//     * Test for correct produce's list display, ordering and swapping up/down.
//     */
//    @Test
//    public void J_testProduceList() {
//
//        logIn("meruadmin", "Nyama@16");
//
//        NMBPageObjectsEnglish.goToPriceList();
//
//        ProduceList.clickRefreshPriceList();
//
//        isEachViewDisplayed("meru-avocado", "meru-beans", "meru-chicken");
//
////                scrollRecycleViewItemBetweenPosition(id.recycler_view, 1, 18);
////
////                 isEachViewDisplayed("meru-avocado", "meru-beans", "meru-chicken");
//    }
//
//    /**
//     * test for update of farmer information on the App.
//     */
//    @Test
//    public void X_testUpdateFarmer() {
//
//        logIn("meruagent", "Nyama@16");
//
//        NMBPageObjectsEnglish.goToFarmerList();
//
//        clickOnView("Anneh");
//
//        EspressoUtililities.swipeUpContentView();
//
//        onView(allOf(withText("Edit"), isDisplayed())).perform(click());
//
//        String[] farmer = TestData.getUpdateFarmer();
//
//        Object[] id = {R.id.input_surname, R.id.input_other_names,
//                R.id.input_mobile_number, R.id.input_tin, R.id.input_pob};
//
//        clearMultipleTextOnView(id);
//
//
//        typeTextInMultipleViews(id, farmer);
//
//        String[] gender = {"Male"};
//        String[] language = {"English", "Swahili"};
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
//        onView(allOf(withText("Save"), isDisplayed())).perform(click());
//
//        isViewDisplayed("Farmer details was successfully updated!");
//        clickOnView("Ok");
//
//        /**
//         * update farm information
//         */
//
//        onView(allOf(withText("Farm"), isDisplayed())).perform(click());
//        onView(allOf(withText("Edit"), isDisplayed())).perform(click());
//        clearMultipleTextOnView(R.id.input_area, R.id.input_address, R.id.input_fertilizer);
//
//        actionSetProgressBar(R.id.seek_bar_land_size, 8);
//
//        clickOnView(R.id.input_equipment);
//        clickOnMultipleViews("Tractor", "Ok");
//
//        clickOnView(R.id.input_crops);
//        clickOnMultipleViews("meru-avocado", "Ok");
//
//        clickOnView(R.id.input_animals);
//        clickOnMultipleViews("meru-chicken", "Ok");
//
//        typeTextOnView(R.id.input_fertilizer, "CAN");
//
//        onView(allOf(withText("Save"), isDisplayed())).perform(click());
//
//        isViewDisplayed("Farmer details was successfully updated!");
//        clickOnView("Ok");
//
//        isViewDisplayed("Annieh");
//    }
//
//    /**
//     * tests produce collection process
//     */
//    @Test
//    public void testCollectProduce(){
//
//        String[][] allProduces=TestData.getNMBProduceList();
//        String[][] allfarmers=TestData.getNMBFarmers();
//
//
//        logIn("meruagent", "Nyama@16");
//
//        for(int produceCocunt=0;produceCocunt<allProduces.length; ++produceCocunt){
//
//            String[] produce=allProduces[produceCocunt];
//            String produceName=produce[0];
//            String produceUnitOfMeasure=produce[1];
//            double producePrice=getDoubleOf(produce[2]);
//
//            for(int farmerCount=0; farmerCount<allfarmers.length;++farmerCount){
//
//                String[] farmer=allfarmers[farmerCount];
//                String farmerName="shimoli";//                String farmerName=farmer[1];
//                String farmerMobile=farmer[2];
//
//
//                goToCollectProduce();
//
//                ProduceList.selectProduce( produceName,1);
//
//                FarmerList.selectFarmer(farmerName, 20);
//
//                String totalWeight=WeighingScreen.getTotalWeight();
//                String currentWeight=WeighingScreen.getCurrentWeight();
//
//                // isEachViewDisplayed("Daniel");
//
//                WeighingScreen.clickOnDone();
//                WeighingScreen.clickOnContinue();
//
//                /**
//                 * impurities screen
//                 */
//                isEachViewDisplayed("Item","Produce Weight","Impurities (KGS)", "Amount", "Total");
//
//                isObjectsEquals(ImpuritieScreen.getProduceName(),produceName);
//
//                isObjectsEquals(removeNonNumeric(ImpuritieScreen.getProduceWeight()), removeNonNumeric(totalWeight));//assert produce weight
//
//                String impurities="0.00";
//                ImpuritieScreen.typeImpurities(impurities);
//
////                double totals=(getDoubleOf(removeNonNumeric(totalWeight))-getDoubleOf(impurities))*producePrice;
//                double totals=(getDoubleOf(removeNonNumeric(totalWeight))-getDoubleOf(impurities))*1031.45;
//
//                totals=formatDoubleDecimals(totals);
//
////                isObjectsEquals(removeNonNumeric(ImpuritieScreen.getAmountDue()), String.valueOf(totals));//assert amount due based on weight* price
////
////                isObjectsEquals(ImpuritieScreen.getTotal(), String.valueOf(totals));//assert gross amount including bonus
//
//                WeighingScreen.clickOnContinue();
//
//                isEachViewDisplayed("Amount Due", "Mobile Money","Cash", "Still Need");
//
//                double MoMo=formatDoubleDecimals(totals*0.60);
//
//                SplitPaymentScreen.typeMoMo(String.valueOf(MoMo));
//                SplitPaymentScreen.typeCash(String.valueOf(formatDoubleDecimals((totals*0.40))));
//
//
//
////                SplitPaymentScreen.typeMoMo(String.valueOf(formatDoubleDecimals(Totals*0.60)));
//
////                isObjectsEquals(removeNonNumeric(SplitPaymentScreen.getStillNeeded()), String.valueOf(formatDoubleDecimals(Totals*0.40)));
//
////                SplitPaymentScreen.typeCash(String.valueOf(formatDoubleDecimals(Totals*0.40)));
//
//                String totality=removeNonNumeric(getTotals());
//
//                Log.d("NMBEnglishTests", "Totality is: "+totality);
//
//                Log.d("NMBEnglishTests", "Totals is: "+totals);
//
//                String getTotals=String.valueOf(formatDoubleDecimals(getDoubleOf(removeNonNumeric(getTotals()))));
//
//                Log.d("NMBEnglishTests", "Totals issssssss: "+getTotals);
//
////                isObjectsEquals(removeNonNumeric(getTotals()), String.valueOf(totals));
////                isObjectsEquals(getTotals, String.valueOf(totals));
//
//
//                WeighingScreen.clickOnContinue();
//
//                isViewDisplayed("Your collection has been recorded");
//
//               // isViewDisplayed(formatString("Transaction Amount: %s",String.valueOf(totals)));
//
//                clickOnView("Ok");
//
//                goToHome();
//            }
//
//        }
//    }
//    @Test
//    public void testCollectionReports() {
//
//        logIn("meruagent", "Nyama@16");
//        goToReports();
//        Reports.clickOnSelectProduce();
//        Reports.selectProduce("meru-beans");
//        Reports.selectDateFrom();
//        Reports.selectDateTo();
//        Reports.clickOnSearch();
//
//        isObjectsEquals(Reports.getTotalCollection(), "5");
//        isObjectsEquals(Reports.getTotalWeight(), "121.84");
//        isObjectsEquals(Reports.getTotalPrice(), "4046.0");
//
//        isObjectsEquals(Reports.getSummaryReportTitle(), formatString("%s Summary", "Meru-beans"));
//
//        isEachViewDisplayed("Total Collections", "Total Weight (KGS)", "Total Price");
//
//        // isViewContains(R.id.text_total_collections, "0");
//    }
//
//    @Test
//    public void SummaryReport() {
//
//        logIn("meruagent", "Nyama@16");
//        goToReports();
//        Reports.clickOnSelectProduce();
//        Reports.selectProduce("meru-beans");
//        Reports.selectDateFrom();
//        Reports.selectDateTo();
//        Reports.clickOnSearch();
//        Reports.clickOnViewDetailedSummary();
//
//        actionOnViewSwipeUp(id.recycler_view,3);
//
//        clickOnView("Annieh");
//
//        /**
//         * Check the selected  farmer profile details
//         */
//        isEachViewDisplayed("Kiharia","Annieh", "meru-beans");
//
//        isObjectsEquals(SummaryReports.getSurName(), "Surname: Kiharia");
//        isObjectsEquals(SummaryReports.getOtherName(), "Names: Annieh");
//        isObjectsEquals(SummaryReports.getProduce(), "Produce: meru-beans");
//
//        /**
//         * Check the selected farmer collection summary
//         */
//        isObjectsEquals(Reports.getTotalCollection(), "5");
//        isObjectsEquals(Reports.getTotalWeight(), "121.84");
//        isObjectsEquals(Reports.getTotalPrice(), "4,046.00");
//
//        /**
//         * Check the selected farmer's last 5 transactions
//         */
//        String[] transaction_1={"20/10/2016", "20.21","680.00","0.00"};
//        isArrayEquals(SummaryReports.getTransaction_1(),transaction_1 );
//
//        String[] transaction_2={"20/10/2016", "27.98","918.00","0.00"};
//        isArrayEquals(SummaryReports.getTransaction_2(),transaction_2 );
//
//        String[] transaction_3={"20/10/2016", "30.29","1,020.00","0.00"};
//        isArrayEquals(SummaryReports.getTransaction_3(),transaction_3 );
//
//        String[] transaction_4={"20/10/2016", "22.75","748.00","0.00"};
//        isArrayEquals(SummaryReports.getTransaction_4(),transaction_4 );
//
//        String[] transaction_5={"20/10/2016", "20.61","680.00","0.00"};
//        isArrayEquals(SummaryReports.getTransaction_5(),transaction_5 );
//
//    }
//
//    /**
//     * Logs into the 2kuze application with specified username and password
//     */
//    public void logIn(String username, String password) {
//
//        clickOnView("English");
//
//        typeTextOnView(id.input_mobile_number, username);
//
//        typeTextOnView(id.input_password, password);
//
//        clickOnView(id.button_login);
//    }
//
//    /**
//     * log out from the App
//     */
//
//    public void logOut() {
//        MainMenu.goToMainMenu();
////            MainMenu.clickOnLogout();
//        MainMenu.clickOnSettings();
//    }
//
//    /**
//     * First time login, to agree terms and conditions
//     *
//     * @param username
//     * @param password
//     */
//    public void firstTimeLogin(String username, String password) {
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