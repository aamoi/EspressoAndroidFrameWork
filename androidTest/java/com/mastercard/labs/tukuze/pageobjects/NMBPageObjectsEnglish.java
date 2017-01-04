//package com.mastercard.labs.tukuze.pageobjects;
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
//import static org.hamcrest.Matchers.containsString;
//
//import com.mastercard.labs.tukuze.client.R;
//
//import org.hamcrest.Matchers;
//
///**
// * Created by amoi on 13/10/2016.
// */
//
//public class NMBPageObjectsEnglish {
//
//    public static void goToFarmerList() {
//
//        clickOnView(R.id.button_farmer_list);
//    }
//
//    public static void goToCollectProduce() {
//
//        clickOnView(R.id.button_collect_produce);
//    }
//
//    public static void goToPriceList() {
//
//        clickOnView(R.id.text_price_list);
//    }
//
//    public static void goToReports() {
//
//        clickOnView(R.id.button_reports);
//    }
//
//    public static void goToHome() {
//
//        clickOnSideMenu("Open navigation drawer");
//
//        onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
//    }
//
//    /**
//     *
//     * page object for farmer collection screen
//     */
//
//    static class  CreateFarmerForm {
//
//        public static void typeSurName(String surname){typeTextOnView(R.id.input_surname,surname);}
//
//        public static void typeOtherName(String othername){typeTextOnView(R.id.input_other_names,othername);}
//
//        public static void typeMobileNo(String mobile){typeTextOnView(R.id.input_mobile_number,mobile);}
//
//        public static void typePIN(String id){typeTextOnView(R.id.input_tin,id);}
//
//        public static void typePOB(String pob){typeTextOnView(R.id.input_tin,pob);}
//
//        public static void clickOnGender() {clickOnView(R.id.input_gender);}
//
//        public static void selectGender(String gender) {clickOnView(gender);}
//
//        public static void clickOnDOB() {clickOnView(R.id.input_dob);}
//
//        public static void selectCurrentDate() {clickWithTrialsOnView("Done", "Ok", "OK");}
//
//        public static void clickOnLanguagePref() {clickOnView(R.id.input_lang_pref);}
//
//        public static void selectLanguage(String language) {clickOnView(language);}
//
//        public static void clickOnContinue() {clickOnView(R.id.button_continue);}
//
//        /**
//         * Farm information
//         * @param area
//         */
//
//        public static void  typeArea(String area){typeTextOnView(R.id.input_area, area);}
//
//        public static void  typeAddress(String address){typeTextOnView(R.id.input_address, address);}
//
//        public static void selectLandSize(int size){actionSetProgressBar(R.id.seek_bar_land_size, size);}
//
//        public static void clickOnEquipments() {clickOnView(R.id.input_equipment);}
//        public static void selectEquipment(String... equipment) {clickOnMultipleViews(equipment);clickOnView("Ok");}
//
//        public static void clickOnCrops() {clickOnView(R.id.input_crops);}
//        public static void selectCrops(String... crops) {clickOnMultipleViews(crops);clickOnView("Ok");}
//
//
//        public static void clickOnAnimals() {clickOnView(R.id.input_animals);}
//        public static void selectAnimals(String... animals) {clickOnMultipleViews(animals);clickOnView("Ok");}
//
//        public static void  typeFertilizer(String fertilizer){typeTextOnView(R.id.input_fertilizer, fertilizer);}
//
//        /**
//         * Payment information
//         */
//        public static void clickMoMoPaymentOption() {clickOnView("Mobile");}
//
//        public static void  typeMoMoAccount(String mobileNo){typeTextOnView(R.id.input_account_number2, mobileNo);}
//
//    }
//
//}
