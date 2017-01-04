package com.mastercard.labs.tukuze.agent;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SplashScreenActivityTest3 {

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashScreenActivity.class);

    @Test
    public void splashScreenActivityTest3() {
//        ViewInteraction appCompatButton = onView(
//                allOf(withId(com.mastercard.labs.tukuze_client.R.id.button_english), withText("English"), isDisplayed()));
//        appCompatButton.perform(click());
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(com.mastercard.labs.tukuze_client.R.id.input_mobile_number), isDisplayed()));
//        appCompatEditText.perform(replaceText("admin"));
//
//        ViewInteraction appCompatEditText2 = onView(
//                allOf(withId(com.mastercard.labs.tukuze_client.R.id.input_password), isDisplayed()));
//        appCompatEditText2.perform(replaceText("Nyama@16"));
//
//        ViewInteraction appCompatButton2 = onView(
//                allOf(withId(com.mastercard.labs.tukuze_client.R.id.button_login), withText("Login"), isDisplayed()));
//        appCompatButton2.perform(click());

    }
}
