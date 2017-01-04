package com.mastercard.labs.tukuze.client;

/**
 * Created by amoi on 28/11/2016.
 */

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mastercard.labs.tukuze.client.EspressoUtililities.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by amoi on 13/10/2016.
 */

public class CPFPageObjects {

    public static void clickOnContinue() {
        clickWithTrialsOnView(R.id.button_continue, "Continue", "Done");
    }

    public static void selectLangauge(String language) {
        clickOnView(language);
    }

    public static void goToCollectProduce() {
        clickOnView(R.id.button_collect_produce);
    }

    public static void goToOrderList() {
        clickOnView(R.id.button_order_list);
    }

    public static void goToFarmerList() {
        clickOnView(R.id.button_farmer_list);
    }

    public static void goToBuyerList() {
        clickOnView(R.id.button_buyer_list);
    }

    public static void goToReports() {
        clickOnView(R.id.button_reports);
    }

    public static void clickOnRefreshList() {
        clickOnView(R.id.action_refresh);
    }

    public static void goToHome() {

        clickOnSideMenu("Open navigation drawer");

        onView(Matchers.allOf(withText(containsString("Home")))).perform(click());
    }

    public static void logOut() {
        clickOnSideMenu("Open navigation drawer");
        clickOnView("Logout");
        clickOnView("Ok");


    }
}

/**
 * Farmers list.
 */
class FarmerList {
    static int input_farmer_search = R.id.input_search;

    public static void clickOnAddFarmer() {
        clickOnView(R.id.button_add_farmer);
    }

    public static void typeSearchFarmer(String searchFarmer) {
        typeTextOnView(input_farmer_search, searchFarmer);
    }

    public static void clearSearchFarmer() {
        clearTextOnView(input_farmer_search);
    }

    public static void clickOnSearchFarmer() {
        clickOnView(R.id.button_search);
    }

    public static void searchFarmer(String searchFarmer) {
        typeSearchFarmer(searchFarmer);
        clickOnSearchFarmer();
        clearSearchFarmer();
    }

    public static void selectFarmer(String name, int FarmersRecordSize) {

        clickOnRecyclerViewListItem(R.id.recycler_view, 0, FarmersRecordSize, name);

//        scrollRecycleViewItemBetweenPosition(R.id.recycler_view,0,position);clickOnView(name);
    }

    public static void clickOnContinue() {
        clickOnView(R.id.button_continue);
    }
}

/**
 * Produces Price list.
 */
class ProduceList {
    public static void clickRefreshPriceList() {
        clickOnView(R.id.action_refresh);
    }

    public static void selectProduce(String produceName) {
        clickOnRecyclerViewListItem(R.id.recycler_view, 1, 26, produceName);
    }
}

/**
 * Weighing screen
 */
class WeighingScreen {
    /**
     * farmer information
     *
     * @return
     */
    public static String getFarmerName() {
        return getText(R.id.text_farmer_name);
    }

    public static String getFarmerPhone() {
        return getText(R.id.text_mobile_number);
    }

    public static String getProduceName() {
        return getText(R.id.text_produce_name);
    }

    /**
     * weight information
     */
    public static String getCurrentWeight() {
        return getText(R.id.text_current_weight);
    }

    public static String getTotalWeight() {
        return getText(R.id.text_total_weight);
    }

    /**
     * action buttons
     */
    public static void clickOnAddMore() {
        clickOnView(R.id.button_add_more);
    }

    public static void clickOnDone() {
        clickOnView(R.id.button_done);
    }

    public static void clickOnContinue() {
        startTiming(timer * 4);
        clickOnView(R.id.button_pay);
    }
}

/**
 * Class for split payment resources.
 */
class SplitPaymentScreen {
    public static String getAmountDue() {
        return getText(R.id.text_amount_due);
    }

    public static void typeMoMo(String MoMo) {
        typeTextOnView(R.id.input_mobile, MoMo);
    }

    public static void typeCash(String cash) {
        typeTextOnView(R.id.input_cash, cash);
    }

    public static String getStillNeeded() {
        return getText(R.id.text_remaining_balance);
    }

    public static String getTotals() {
        return getText(R.id.text_total_payment);
    }
}

/**
 * Class for entering payment and quantity
 */
class PopulatePayment {
    public static void typeQuantity(String quantity) {
        typeTextOnView(R.id.txtCollectedQuantity, quantity);
    }

    public static void typeAmount(String amount) {
        typeTextOnView(R.id.txtAgreedAmount, amount);
    }

    public static void clickOnAddMore() {
        clickOnView(R.id.button_add_more);
    }

    //    public static void clickOnDone() {clickOnView(R.id.button_done);}
    public static void clickOnDone() {
        clickOnView("Done");
    }

}

/**
 * Cash Payment
 */
class CashPayments {
    public static void selectDateFrom() {
        clickOnView(R.id.text_from_date);
        clickWithTrialsOnView("Done", "Ok", "OK");
    }

    public static void typeSearchName(String name) {
        typeTextOnView(R.id.input_search, name);
    }

    public static void clickOnSearch() {
        clickOnView(R.id.button_search);
    }

    public static void clickOnPayFarmer() {
        clickOnView(R.id.button_pay_farmer);
    }

    public static void clickOnSelectAll() {
        clickOnView(R.id.action_select_all);
    }
}

/**
 * Reports module.
 */
class Reports {

    public static void clickOnSelectProduce() {
        clickOnView(R.id.text_crops);
    }

    public static void selectProduce(String produceName) {
        clickOnView(produceName);
    }

    public static void selectDateFrom() {
        clickWithTrialsOnView("Done", "Ok", "OK");
    }

    public static void selectDateTo() {
        clickWithTrialsOnView("Done", "Ok", "OK");
    }

    public static void clickOnSearch() {
        clickOnView(R.id.button_search);
    }

    public static String getTotalCollection() {
        return getText(R.id.text_total_collections);
    }

    public static String getTotalWeight() {
        return getText(R.id.text_total_units);
    }

    public static String getTotalPrice() {
        return getText(R.id.text_total_price);
    }

    public static String getSummaryReportTitle() {
        return getText(R.id.title);
    }

    public static void clickOnViewDetailedSummary() {
        clickOnView(R.id.button_detailed_summary);
    }
}

/**
 * page object for farmer collection screen
 */

class CreateFarmerForm {

    public static void typeSurName(String surname) {
        typeTextOnView(R.id.input_surname, surname);
    }

    public static void typeOtherName(String othername) {
        typeTextOnView(R.id.input_other_names, othername);
    }

    public static void typeMobileNo(String mobile) {
        typeTextOnView(R.id.input_mobile_number, mobile);
    }

    public static void typePIN(String id) {
        typeTextOnView(R.id.input_tin, id);
    }

    public static void typePOB(String pob) {
        typeTextOnView(R.id.input_pob, pob);
    }

    public static void clickOnGender() {
        clickOnView(R.id.input_gender);
    }

    public static void selectGender(String gender) {
        clickOnView(gender);
    }

    public static void clickOnDOB() {
        clickOnView(R.id.input_dob);
    }

    public static void selectCurrentDate() {
        clickWithTrialsOnView("Done", "Ok", "OK");
    }

    public static void clickOnLanguagePref() {
        clickOnView(R.id.input_lang_pref);
    }

    public static void selectLanguage(String language) {
        clickOnView(language);
    }

    public static void clickOnContinue() {
        clickOnView(R.id.button_continue);
    }

    /**
     * Farm information
     *
     * @param area
     */

    public static void typeArea(String area) {
        typeTextOnView(R.id.input_area, area);
    }

    public static void typeAddress(String address) {
        typeTextOnView(R.id.input_address, address);
    }

    public static void selectLandSize(int size) {
        actionSetProgressBar(R.id.seek_bar_land_size, size);
    }

    public static void clickOnEquipments() {
        clickOnView(R.id.input_equipment);
    }

    public static void selectEquipment(String... equipment) {
        clickOnMultipleViews(equipment);
        clickOnView("Ok");
    }

    public static void clickOnCrops() {
        clickOnView(R.id.input_crops);
    }

    public static void selectCrops(String... crops) {
        clickOnMultipleViews(crops);
        clickOnView("Ok");
    }


    public static void clickOnAnimals() {
        clickOnView(R.id.input_animals);
    }

    public static void selectAnimals(String... animals) {
        clickOnMultipleViews(animals);
        clickOnView("Ok");
    }

    public static void typeFertilizer(String fertilizer) {
        typeTextOnView(R.id.input_fertilizer, fertilizer);
    }

    /**
     * Payment information
     */
    public static void clickMoMoPaymentOption() {
        clickOnView("Mobile");
    }

    public static void typeMoMoAccount(String mobileNo) {
        typeTextOnView(R.id.input_account_number2, mobileNo);
    }
}

/**
 * Form for creating buyers
 */
class CreateBuyerForm {
    public static void typeFirstName(String first_name) {
        typeTextOnView(R.id.txtFirstName, first_name);
    }

    public static void typeLastName(String last_name) {
        typeTextOnView(R.id.txtLastName, last_name);
    }

    public static void typePhoneNo(String phone) {
        typeTextOnView(R.id.txtPhoneNumber, phone);
    }

    public static void typeLocation(String location) {
        typeTextOnView(R.id.txtLocation, location);
    }
}

/**
 * Buyer list
 */
class BuyerList {
    public static void clickOnAddBuyer() {
        clickOnView(R.id.button_add_buyer);
    }
}

/**
 * Form for creating buyer orders
 */
class CreateBuyerOrderForm {
    public static void selectProduce(String produceName) {
        clickOnView(R.id.input_produce);
        clickOnDropDownItem(1, 27, produceName);
    }

    public static void typeQuantity(String quantity) {
        typeTextOnView(R.id.input_quantity, quantity);
    }

    public static void selectBuyer(String BuyerName) {
        clickOnMultipleViews(R.id.input_buyer, R.id.input_buyer);
        clickOnDropDownItem(1,27, BuyerName);
    }

    public static void selectDate() {
        clickOnView(R.id.input_date_needed);
    }
}

/**
 * Deliver buy order
 */
class DeliverOrder {
    public static void selectPaymentMode(String paymentMode) {
        clickOnView(R.id.sp_payment_mode);
        clickOnSpinnerPopUpItem(paymentMode);
    }

    public static void typeSellPrice(String price) {
        typeTextOnView(R.id.input_price, price);
    }

    public static void typeSellTransport(String transport) {
        typeTextOnView(R.id.input_transport_cost, transport);
    }
}

/**
 * Buyer order list
 */
class BuyerOrderList {
    public static void clickOnAddBuyOrder() {
        clickOnView(R.id.button_add_order);
    }

    public static void clickOnDeliver() {
        clickWithTrialsOnView("Deliver", R.id.button_deliver);
    }
}

/**
 * Main menu options
 */
class MainMenu {

    public static void goToMainMenu() {
        clickOnSideMenu("Open navigation drawer");
    }

    public static void clickOnPriceList() {
        clickOnView("Price List");
    }

    public static void clickOnFarmerList() {
        clickOnView("Farmer List");
    }

    public static void clickOnReports() {
        clickOnView("Reports");
    }

    public static void clickOnSettings() {
        clickOnView("Settings");
    }

    public static void clickOnLogout() {
        clickOnView("Logout");
    }
}
