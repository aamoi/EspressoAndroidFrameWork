//package com.mastercard.labs.tukuze.client;
//
//import android.util.Log;
//import org.hamcrest.Matchers;
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
//import static org.hamcrest.Matchers.containsString;
//
///**
// * Created by amoi on 13/10/2016.
// */
//
//public class NMBPageObjectsEnglish {
//
//    public static void selectEnglishLangauge() {clickOnView("");}
//
//    public static String  getCashBalance(){return getText(R.id.text_agent_cash_bal);}
//
//    public static String  getWalletBalance(){return getText(R.id.text_agent_wallet_bal);}
//
//    public static void goToFarmerList() {clickOnView(R.id.button_farmer_list);}
//
//    public static void goToCollectProduce() {clickOnView(R.id.button_collect_produce);}
//
//    public static void goToPriceList() {clickOnView(R.id.text_price_list);}
//
//    public static void goToReports() {clickOnView(R.id.button_reports);}
//
//    public static void goToHome() {
//
//        clickOnSideMenu("Open navigation drawer");
//
//        onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//    }
//}
//
///**
// * Farmers list.
// */
//class FarmerList{
//
//    public static void clickOnAddFarmer() {clickOnView(R.id.button_add_farmer);}
//
//    public static void typeSearchFarmer(String searchFarmer){typeTextOnView(R.id.input_search,searchFarmer);}
//
//    public static void clickOnSearchFarmer() {clickOnView(R.id.button_search);}
//
//    public static void selectFarmer(String name, int FarmersRecordSize) {
//
//        clickOnRecyclerViewListItem(R.id.recycler_view,0,FarmersRecordSize,name);
//
//        //scrollRecycleViewItemBetweenPosition(R.id.recycler_view,0,position);clickOnView(name);
//    }
//    public static void clickOnContinue() {clickOnView(R.id.button_continue);}
//}
//
///**
// * Produces Price list.
// */
//class ProduceList{
//    public static void clickRefreshPriceList() {clickOnView(R.id.action_refresh);}
//    public static void selectProduce(String name, int position) {
//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view,0,position);clickOnView(name);
//    }
//}
//
///**
// * Weighing screen
// */
//class WeighingScreen{
//
//    /**
//     * farmer information
//     * @return
//     */
//    public static String  getFarmerName(){return getText(R.id.text_farmer_name);}
//    public static String  getFarmerPhone(){return getText(R.id.text_mobile_number);}
//    public static String  getProduceName(){return getText(R.id.text_produce_name);}
//
//    /**
//     * weight information
//     */
//    public static String  getCurrentWeight(){return getText(R.id.text_current_weight);}
//    public static String  getTotalWeight(){return getText(R.id.text_total_weight);}
//
//    /**
//     * action buttons
//     */
//    public static void clickOnAddMore() {clickOnView(R.id.button_add_more);}
//    public static void clickOnDone() {clickOnView(R.id.button_done);}
//    public static void clickOnContinue() {startTiming(timer*4);clickOnView(R.id.button_pay);}
//}
///**
// * Class for impurities screen resources.
// */
//class ImpuritieScreen{
//
//    public static String  getProduceName(){return getText(R.id.text_produce_name);}
//
//    public static String  getProduceWeight(){return getText(R.id.text_quantity);}
//
////        public static String  getProduceWeight(){return getHiddentext(R.id.text_total_weight);}
//
//    public static void typeImpurities(String impurities){typeTextOnView(R.id.input_impurities,impurities);}
//    public static String  getAmountDue(){
//
//        Log.d("TESTTTT","TTTTTTTTTTTTT:"+getText(R.id.text_amount));
//
//        return getText(R.id.text_amount);
//    }
//    public static String  getTotal(){return getText(R.id.text_total_price);}
//}
///**
// * Class for split payment resources.
// */
//class SplitPaymentScreen{
//    public static String  getAmountDue(){return getText(R.id.text_amount_due);}
//    public static void typeMoMo(String MoMo){typeTextOnView(R.id.input_mobile,MoMo);}
//    public static void typeCash(String cash){typeTextOnView(R.id.input_cash,cash);}
//    public static String  getStillNeeded(){return getText(R.id.text_remaining_balance);}
//    public static String  getTotals(){return getText(R.id.text_total_payment);}
//}
///**
// * Reports module.
// */
//class Reports{
//
//    public static void clickOnSelectProduce() {clickOnView(R.id.text_crops);}
//
//    public static void selectProduce(String produceName) {clickOnView(produceName);}
//
//    public static void selectDateFrom() {clickWithTrialsOnView("Done", "Ok", "OK");}
//
//    public static void selectDateTo() {clickWithTrialsOnView("Done", "Ok", "OK");}
//
//    public static void clickOnSearch(){clickOnView(R.id.button_search);}
//
//    public static String  getTotalCollection(){return getText(R.id.text_total_collections);}
//
//    public static String getTotalWeight(){return getText(R.id.text_total_units);}
//
//    public static String getTotalPrice(){return getText(R.id.text_total_price);}
//
//    public static String getSummaryReportTitle(){return getText(R.id.title);}
//
//    public static void clickOnViewDetailedSummary(){clickOnView(R.id.button_detailed_summary);}
//}
///**
// * Summary Reports
// *
// */
//class SummaryReports{
//    /**
//     * farmer profile
//     * @return
//     */
//    public static String getSurName(){return getText(R.id.text_farmer_surname);}
//    public static String getOtherName(){return getText(R.id.text_farmer_names);}
//    public static String getProduce(){return getText(R.id.text_produce);}
//    public static void clickOnSortBy() {clickOnView(R.id.text_sort_by);}
//    public static void typeSearch(String searchFarmer){typeTextOnView(R.id.input_search,searchFarmer);}
//    public static void clickOnSearch(){clickOnView(R.id.button_search);}
//    public static String[] getTransaction_1(){return getTextArray(R.id.text_date_1,R.id.text_weight_1,R.id.text_price_1, R.id.text_bonus_1);}
//    public static String[] getTransaction_2(){return getTextArray(R.id.text_date_2,R.id.text_weight_2,R.id.text_price_2, R.id.text_bonus_2);}
//    public static String[] getTransaction_3(){return getTextArray(R.id.text_date_3,R.id.text_weight_3,R.id.text_price_3, R.id.text_bonus_3);}
//    public static String[] getTransaction_4(){return getTextArray(R.id.text_date_4,R.id.text_weight_4,R.id.text_price_4, R.id.text_bonus_4);}
//    public static String[] getTransaction_5(){return getTextArray(R.id.text_date_5,R.id.text_weight_5,R.id.text_price_5, R.id.text_bonus_5);}
//}
///**
// *
// * page object for farmer collection screen
// */
//
//class  CreateFarmerForm {
//
//    public static void typeSurName(String surname){typeTextOnView(R.id.input_surname,surname);}
//
//    public static void typeOtherName(String othername){typeTextOnView(R.id.input_other_names,othername);}
//
//    public static void typeMobileNo(String mobile){typeTextOnView(R.id.input_mobile_number,mobile);}
//
//    public static void typePIN(String id){typeTextOnView(R.id.input_tin,id);}
//
//    public static void typePOB(String pob){typeTextOnView(R.id.input_pob,pob);}
//
//    public static void clickOnGender() {clickOnView(R.id.input_gender);}
//
//    public static void selectGender(String gender) {clickOnView(gender);}
//
//    public static void clickOnDOB() {clickOnView(R.id.input_dob);}
//
//    public static void selectCurrentDate() {clickWithTrialsOnView("Done", "Ok", "OK");}
//
//    public static void clickOnLanguagePref() {clickOnView(R.id.input_lang_pref);}
//
//    public static void selectLanguage(String language) {clickOnView(language);}
//
//    public static void clickOnContinue() {clickOnView(R.id.button_continue);}
//
//    /**
//     * Farm information
//     * @param area
//     */
//
//    public static void  typeArea(String area){typeTextOnView(R.id.input_area, area);}
//
//    public static void  typeAddress(String address){typeTextOnView(R.id.input_address, address);}
//
//    public static void selectLandSize(int size){actionSetProgressBar(R.id.seek_bar_land_size, size);}
//
//    public static void clickOnEquipments() {clickOnView(R.id.input_equipment);}
//    public static void selectEquipment(String... equipment) {clickOnMultipleViews(equipment);clickOnView("Ok");}
//
//    public static void clickOnCrops() {clickOnView(R.id.input_crops);}
//    public static void selectCrops(String... crops) {clickOnMultipleViews(crops);clickOnView("Ok");}
//
//
//    public static void clickOnAnimals() {clickOnView(R.id.input_animals);}
//    public static void selectAnimals(String... animals) {clickOnMultipleViews(animals);clickOnView("Ok");}
//
//    public static void  typeFertilizer(String fertilizer){typeTextOnView(R.id.input_fertilizer, fertilizer);}
//
//    /**
//     * Payment information
//     */
//    public static void clickMoMoPaymentOption() {clickOnView("Mobile");}
//
//    public static void  typeMoMoAccount(String mobileNo){typeTextOnView(R.id.input_account_number2, mobileNo);}
//
//}
//
///**
// * Main menu options
// */
//class MainMenu{
//
//    public static void goToMainMenu() { clickOnSideMenu("Open navigation drawer");}
//
//    public static void clickOnPriceList() {clickOnView("Price List");}
//
//    public static void clickOnFarmerList() {clickOnView("Farmer List");}
//
//    public static void clickOnReports() {clickOnView("Reports");}
//
//    public static void clickOnSettings() {clickOnView("Settings");}
//
//    public static void clickOnLogout() {clickOnView("Logout");}
//}
