//// package com.mastercard.labs.tukuze.client;
//
//import android.content.res.Resources;
//import android.os.IBinder;
//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.EspressoException;
//import android.support.test.espresso.IdlingResource;
//import android.support.test.espresso.NoMatchingViewException;
//import android.support.test.espresso.Root;
//import android.support.test.espresso.UiController;
//import android.support.test.espresso.ViewAction;
//import android.support.test.espresso.ViewAssertion;
//import android.support.test.espresso.ViewInteraction;
//import android.support.test.espresso.action.GeneralLocation;
//import android.support.test.espresso.action.GeneralSwipeAction;
//import android.support.test.espresso.action.Press;
//import android.support.test.espresso.action.Swipe;
//import android.support.test.espresso.action.ViewActions;
//import android.support.test.espresso.contrib.RecyclerViewActions;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.SeekBar;
//import android.widget.TextView;
//
//import org.hamcrest.Description;
//import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
//
//import java.util.ArrayList;
//
//import static android.support.test.espresso.Espresso.onView;
//import static android.support.test.espresso.action.ViewActions.clearText;
//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static android.support.test.espresso.action.ViewActions.swipeDown;
//import static android.support.test.espresso.action.ViewActions.swipeLeft;
//import static android.support.test.espresso.action.ViewActions.swipeUp;
//import static android.support.test.espresso.action.ViewActions.typeText;
//import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
//import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
//import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
//import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.core.IsNot.not;
//
///**
// * Created by amoi on 21/06/2016.
// */
//public class EspressoUtilities_BackUp {
//    /**
//     * Type text into a android edit text view identified by viewID.
//     *
//     * @param viewID view id identifier
//     * @param text   text to enter.
//     */
//    public static void typeTextOnView(int viewID, String text) {
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                onView(allOf(withId(viewID))).perform(clearText());
//                onView(allOf(withId(viewID))).perform(typeText(text), closeSoftKeyboard());
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(100);
//            }
//        }
//    }
//
//    public static void clearTextOnView(int viewID) {
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                onView(allOf(withId(viewID))).perform(clearText(), closeSoftKeyboard());
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(100);
//            }
//        }
//    }
//
//    public static void clearMultipleTextOnView(int... viewIDs) {
//
//        for (int i = 0; i <viewIDs.length ; ++i) {
//            clearTextOnView(viewIDs[i]);
//        }
//    }
//
//    public static void actionSetProgressBar(int id, int size) {
//
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                onView(withId(id)).perform(setProgress(size));
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//
//            }
//        }
//
//    }
//
//    /**
//     * Check view display
//     */
//    public boolean checkViewDisplay(int id) {
//
//        int count = 3;
//
//        try {
//            onView(allOf(withId(id))).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
//            return true;
//        } catch (Exception | Error e) {
//            return false;
//
//        }
//    }
//
//    /**
//     * Type text into android edit text with matcher.
//     *
//     * @param matcher view matcher
//     * @param text    text to enter.
//     */
//    public static void typeTextOnView(String matcher, String text) {
//        onView(withText(matcher)).perform(typeText(text), closeSoftKeyboard());
//    }
//
//    /**
//     * Clicks on screen view identified by the android viewID.
//     *
//     * @param viewIDs identifier for the android view component.
//     */
//    public static void clickOnView(int viewIDs) {
//
//        isViewDisplayed(viewIDs);
//
//        onView(getMatchesAllOf(viewIDs)).perform(click());
//    }
//
//    /**
//     * clicks on screen view with string matcher.
//     *
//     * @param matchers string matchers for the screen view component.
//     */
//    public static void clickOnView(String... matchers) {
//
//        int count = 3;
//
//        for (int i = 0; i < count; ++i) {
//            try {
//                onView(getMatchesAllOf(matchers)).perform(click());
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(100);
//            }
//
//            onView(getMatchesAllOf(matchers)).perform(click());
//
//        }
//    }
//
//    /**
//     * clicks on screen view with string matcher.
//     *
//     * @param matchers string matchers for the screen view component.
//     */
//    public static void clickWithTrialsOnView(String... matchers) {
//
//        int count = matchers.length;
//
//        for (int i = 0; i < count; ++i) {
//            try {
//                onView(getMatchesAllOf(matchers[i])).perform(click());
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//
//            }
//        }
//    }
//
//    /**
//     * Performs  a long click on a view item
//     *
//     * @param id
//     */
//    public static void clickLongOnView(int id) {
//
//        onView(withId(id)).perform(ViewActions.longClick());
//    }
//
//    /**
//     * @param recycler_view_id
//     * @param itemsCount
//     */
//    public static void isRecyclerListViewCountEquals(int recycler_view_id, int itemsCount) {
//        onView(withId(recycler_view_id)).inRoot(new ToastMatcher()).
//                check(new RecyclerViewItemCountAssertion(itemsCount));
//    }
//
//    /**
//     * clicks on screen view with specified string matchers.
//     *
//     * @param stringMatchers string  matchers list  for the screen view component.
//     */
//    public static void clickOnViewWithAllOf(String... stringMatchers) {
//        onView(getMatchesAllOf(stringMatchers)).perform(click());
//    }
//
//    /**
//     * Clicks on multiple views each multiple selection of checkbox options
//     *
//     * @param matchers display text identifier/matchers for the checkboxes
//     */
//    public static void clickOnMultipleViews(String... matchers) {
//
//        for (int i = 0; i < matchers.length; ++i) {
//
//            isViewDisplayed(matchers[i]);
//
//            clickOnView(matchers[i]);
//
////            onView(allOf(withText(matchers[i])), isDisplayed()).perform(click());
//            // onView(withText(containsString(matchers[i]))).perform(click());
//        }
//    }
//
//    /**
//     * Clicks on multiple views, e.g multiple selection of checkbox options
//     *
//     * @param matchers display text identifier/matchers for the checkboxes
//     */
//    public static void clickOnMultipleViews(int... matchers) {
//
//        for (int i = 0; i < matchers.length; ++i) {
//            isViewDisplayed(matchers[i]);
//            onView(withId(matchers[i])).perform(click());
//            startTiming(100);
//        }
//    }
//
//    /**
//     * Type text into multiple edit text views with specified matchers
//     *
//     * @param textIDs     identifiers for text fileds
//     * @param textEntries text to enter into the text fields
//     */
//    public static void typeTextInMultipleViews(int[] textIDs, String[] textEntries) {
//        for (int count = 0; count < textIDs.length; count++)
//            typeTextOnView(textIDs[count], textEntries[count]);
//    }
//
//    /**
//     * Clicks on a record  at specified position within list view identified by listViewID.
//     *
//     * @param listViewID list view identifier.
//     * @param position   record position reading  top-down, starting  from 0.
//     */
//    public static void clickOnRecordAt(int listViewID, int position) {
//        ViewInteraction listView = onView(withId(listViewID));
//        listView.perform(actionOnItemAtPosition(position, click()), closeSoftKeyboard());
//    }
//
//    /**
//     * Clicks on a record  at specified position within list view with the matcher.
//     *
//     * @param matcher  list view matcher.
//     * @param position record position reading  top-down, starting  from 0.
//     */
//    public static void clickOnRecordAt(String matcher, int position) {
//        ViewInteraction recyclerView = onView(withText(containsString(matcher)));
//        recyclerView.perform(actionOnItemAtPosition(position, click()), closeSoftKeyboard());
//    }
//
//    /**
//     * Checks whether the view containing the matcher string is displayed
//     *
//     * @param matcher
//     */
//    public static void isViewDisplayed(String matcher) {
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                onView(allOf(withText(containsString(matcher)))).inRoot(new ToastMatcher()).
//                        check(matches(isDisplayed()));
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(100);
//            }
//        }
//        onView(withText(containsString(matcher))).inRoot(new ToastMatcher()).
//                check(matches(isDisplayed()));
//
//    }
//
//    /**
//     * Checks whether the view containing the list of matcher strings is displayed
//     *
//     * @param matchers
//     */
//    public static void isViewDisplayedAllOf(String... matchers) {
//        onView(getMatchesAllOf(matchers)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
//    }
//
//    /**
//     * Checks whether each string matcher/text is displayed/present on the app screen view.
//     */
//    public static void isEachViewDisplayed(String... matchers) {
//
//        for (int i = 0; i < matchers.length; ++i) {
//            onView(getMatchesAllOf(matchers[i])).inRoot(new ToastMatcher()).
//                    check(matches(isDisplayed()));
//
//        }
//    }
//
//    /**
//     * Confirms that  the views containing the list of matcher strings are not displayed.
//     * It will fail if the view contains text
//     *
//     * @param matchers list of strings not existing in the view
//     */
//    public static void isViewsNotExist(String... matchers) {
//        for (int i = 0; i < matchers.length; ++i)
//            onView(withText(matchers[i])).inRoot(new ToastMatcher()).check(doesNotExist());
//    }
//
//    /**
//     * Checks wether listed views with specified viewID is displayed.
//     *
//     * @param viewID android view id for the view
//     */
//    public static void isViewDisplayed(int viewID) {
//
//        ViewInteraction view = null;
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                view = onView(withId(viewID));
//                if (!(view == null))
//                    return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(1000);
//            }
//        }
//        onView(withId(viewID)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
//    }
//
//    /**
//     * Checks if recycler view is not displayed(cases where there is no records in the list )
//     *
//     * @param recyclerViewId recycler view list id.
//     */
//    public static void isRecyclerListViewNotDisplayed(int recyclerViewId) {
//        onView(withId(R.id.recycler_view)).check(matches(not(isDisplayed())));
//
//    }
//
//    /**
//     * get ViewInteraction object with specified content description.
//     *
//     * @param contentDescription the content description text.
//     * @return ViewInteraction object
//     */
//    private static ViewInteraction getViewInteractionWithContentDescription(String contentDescription) {
//        return onView(withContentDescription(contentDescription));
//    }
//
//    /**
//     * get ViewInteraction object with specified menu item id.
//     *
//     * @param menuItemId the menu item id.
//     * @return ViewInteraction object
//     */
//    private static ViewInteraction getViewInteractionWithMenuItemId(int menuItemId) {
//        return onView(withId(menuItemId));
//    }
//
//    /**
//     * returns widget ViewInteraction object with specified stringMatcher.
//     *
//     * @param stringMatcher the string matcher in the the view
//     * @return ViewInteraction object
//     */
//    private static ViewInteraction getViewInteractionWithString(String stringMatcher) {
//        return onView(withText(containsString(stringMatcher)));
//    }
//
//    /**
//     * returns widget ViewInteraction object with specified id.
//     *
//     * @param id of the view
//     * @return ViewInteraction object
//     */
//    private static ViewInteraction getViewInteractionWithId(int id) {
//        return onView(withId(id));
//    }
//
//    /**
//     * returns widget ViewInteraction object with specified id.
//     *
//     * @param strings string matchers of the view
//     * @return ViewInteraction object
//     */
//    private static ViewInteraction getViewInteractionWithallOfStrings(String... strings) {
//        return onView(getMatchesAllOf(strings));
//    }
//
//    /**
//     * click on side menu
//     *
//     * @param drawerDescription navigation drawer description for the side menu.
//     */
//    public static void clickOnSideMenu(String drawerDescription) {
//
//        for (int i = 0; i < 3; ++i) {
//            try {
//                getViewInteractionWithContentDescription(drawerDescription).perform(click());
//                return;
//            } catch (android.support.test.espresso.NoMatchingViewException e) {
//                startTiming(100);
//            }
//        }
//    }
//
//    /**
//     * click on menu item
//     *
//     * @param menuItemId item id to click, in the menu.
//     */
//    public static void clickOnMenuItem(int menuItemId) {
//        getViewInteractionWithMenuItemId(menuItemId).perform(click());
//    }
//
//    /**
//     * Returns matcher for all supplied strings
//     *
//     * @param matchers array of strings to match the view or exist in the view.
//     * @return view matcher, matching all supplied strings.
//     */
//    public static Matcher<View> getMatchesAllOf(String... matchers) {
//
//        int numberOfMatchers = matchers.length;
//
//        Matcher<View>[] matcherList = new Matcher[numberOfMatchers];
//
//        for (int i = 0; i < numberOfMatchers; ++i) {
//            matcherList[i] = withText(containsString(matchers[i]));
//        }
//        return allOf(matcherList);
//    }
//
//    /**
//     * Returns matcher for all supplied strings
//     *
//     * @param matchers array of Ids to match the view .
//     * @return view matcher, matching all supplied strings.
//     */
//    public static Matcher<View> getMatchesAllOf(int... matchers) {
//
//        int numberOfMatchers = matchers.length;
//
//        Matcher<View>[] matcherList = new Matcher[numberOfMatchers];
//
//        for (int i = 0; i < numberOfMatchers; ++i) {
//            matcherList[i] = withId(matchers[i]);
//        }
//        return allOf(matcherList);
//    }
//
//    /**
//     * Handler for recycle view
//     *
//     * @param recyclerViewId
//     * @return
//     */
//    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
//        return new RecyclerViewMatcher(recyclerViewId);
//    }
//
//    /**
//     * Set progress for progress task
//     *
//     * @param progress
//     * @return
//     */
//    public static ViewAction setProgress(final int progress) {
//        return new ViewAction() {
//            @Override
//            public void perform(UiController uiController, View view) {
//                SeekBar seekBar = (SeekBar) view;
//                seekBar.setProgress(progress);
//            }
//
//            @Override
//            public String getDescription() {
//                return "Set a progress on a SeekBar";
//            }
//
//            @Override
//            public Matcher<View> getConstraints() {
//                return isAssignableFrom(SeekBar.class);
//            }
//        };
//    }
//
//    /**
//     * Scroll to recycle view item at position
//     */
//    public static void scrollToRecycleViewItemAtPostion(int recyclerViewId, int position) {
//        onView(withId(recyclerViewId)).perform(scrollToPosition(position));
//    }
//
//    /**
//     * Scroll between  recycle view items
//     */
//    public static void scrollRecycleViewItemBetweenPosition(int recyclerViewId, int fromPosition,
//                                                            int toPosition) {
//        if (fromPosition < toPosition) {
//            for (int count = fromPosition; count < toPosition; ++count)
//                onView(withId(recyclerViewId)).perform(scrollToPosition(count));
//        } else {
//            for (int count = fromPosition; count > toPosition; --count)
//                onView(withId(recyclerViewId)).perform(scrollToPosition(count));
//        }
//    }
//
//    /**
//     * Click on a recycler view list item at position
//     */
//    public static void clickOnRecycleViewAtPosition(int recyclerViewId, int position) {
//        scrollToRecycleViewItemAtPostion(recyclerViewId, position);
//        onView(withRecyclerView(recyclerViewId).atPosition(position)).perform(click());
//    }
//
//    /**
//     * Scroll to and click on  a recycler view list item
//     */
//    public static void tapRecyclerViewItemAtPosition(int recyclerViewId, int position) {
//        onView(withId(recyclerViewId)).perform(scrollToPosition(position));
//        onView(withRecyclerView(recyclerViewId).atPosition(position)).perform(click());
//    }
//
//    /**
//     * Clicks on spinner pop-up list item
//     *
//     * @param matchers list of sub-string in the list item
//     */
//    public static void clickOnSpinnerPopUpItem(String... matchers) {
//        onView(getMatchesAllOf(matchers)).inRoot(isPlatformPopup()).perform(click());
//    }
//
//    /**
//     * Swipes up recycler view list items from specified position, specified number of swipes
//     *
//     * @param recyclerViewId identifier for recylcer view
//     * @param itemPosition   position of the item to swipe up from, on the recycler view
//     * @param swipeSteps     number of swipes upwards from @itemPosition
//     */
//    public static void swipeUpRecyclerViewListItemAtPosition(int recyclerViewId, int itemPosition,
//                                                             int swipeSteps) {
//        for (int count = itemPosition; count < swipeSteps + itemPosition; ++count)
//            onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(count,
//                    swipeUp()));
//    }
//
//    /**
//     * Swipes vertically between recycler view list items from specified position,for number of swipes
//     *
//     * @param recyclerViewId identifier for recylcer view
//     * @param fromPosition   swipe  from position, on the recycler view
//     * @param toPosition     swipe to position
//     */
//    public static void swipeVerticalBetweenRecyclerViewItemPositions(
//            int recyclerViewId, int fromPosition, int toPosition) {
//        if (toPosition > fromPosition) {
//            for (int count = fromPosition; count < toPosition; ++count)
//                onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(
//                        count, swipeUp()));
//        } else {
//            for (int count = fromPosition; count > toPosition; --count)
//                onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(
//                        count, swipeDown()));
//        }
//
//    }
//
//    /**
//     * Swipe left android Screen Content View.
//     */
//    public static void swipeLeftContentView() {
//        onView(withId(android.R.id.content)).perform(swipeLeft());
//    }
//
//    /**
//     * Swipe Up android Screen Content View.
//     */
//    public static void swipeUpContentView() {
//        onView(withId(android.R.id.content)).perform(swipeUp());
//    }
//
//    /**
//     * Swipe down android Screen Content View.
//     */
//    public static void swipeDownContentView() {
//        onView(withId(android.R.id.content)).perform(swipeDown());
//    }
//
//    /**
//     * Swipe Up android resource  View.
//     */
//    public static void actionOnViewSwipeUp(int ids, int count) {
//
//
//        for(int i=0;i<count;++i){
//            try{
//                getViewInteraction(ids).perform(swipeUp());
//            }
//            catch (android.support.test.espresso.NoMatchingViewException e) {
//
//                return;
//            }
//        }
//
//    }
//
//    /**
//     * Swipe Up android resource  View.
//     */
//    public static void actionOnViewSwipeDown(int id, int count) {
//
//        for(int i=0;i<count;++i){
//            try{
//                getViewInteraction(id).perform(swipeDown());
//            }
//            catch (android.support.test.espresso.NoMatchingViewException e) {
//                return;
//            }
//        }
//
//    }
//    /**
//     * Swipes down recycler view list items from specified position, specified number of swipes
//     *
//     * @param recyclerViewId identifier for recylcer view
//     * @param itemPosition   position of the item to swipe up from, on the recycler view 10
//     * @param swipeSteps     number of swipes upwards from @itemPosition 2
//     */
//    public static void swipeDownRecyclerViewListItemAtPosition(int recyclerViewId,
//                                                               int itemPosition, int swipeSteps) {
//        for (int count = itemPosition; count > itemPosition - swipeSteps; --count)
//            onView(withId(recyclerViewId)).perform(RecyclerViewActions.actionOnItemAtPosition(count,
//                    swipeDown()));
//        startTiming(50);
//    }
//
//    /**
//     * Swipe up
//     * @return
//     */
//    public static ViewAction swipeViewUp() {
//        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
//                GeneralLocation.TOP_CENTER, Press.FINGER);
//    }
//
//    /**
//     * Swipe up
//     * @return
//     */
//    public static ViewAction swipeViewDown() {
//        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
//                GeneralLocation.BOTTOM_CENTER, Press.FINGER);
//    }
//
//    /**
//     * gets view interaction for a resources identified by ids
//     *
//     * @param ids resource unique identifier.
//     */
//    public static ViewInteraction getViewInteraction(int... ids) {
//
//        ViewInteraction interaction =onView(getMatchesAllOf(ids));
//
//        return onView(getMatchesAllOf(ids));
//    }
//
//    /**
//     * Checks wether both objects are equals, throws an exception if not equals
//     * @param text
//     * @param matcher
//     */
//    public static void isObjectsEquals(String text, String matcher){
//
//        if(!text.equals(matcher)){
//            throw new NullPointerException();
//        }
//    }
//
//    /**
//     * Checks whether 2 array lists are equals.
//     * Need to add log to sort arrays for seamless comparison
//     * @param dataSet
//     * @param comparatorDataSet
//     * @return
//     */
//    public static void  isArrayEquals(String[] dataSet,String[] comparatorDataSet) {
//
//        String[] data_set = dataSet;
//
//        String[] comparator_DataSet = comparatorDataSet;
//
//        int  size=data_set.length;
//
//        if ((comparator_DataSet.length==size)){
//            for(int i=0;i<size;++i)
//                if(!data_set[i].equalsIgnoreCase(comparator_DataSet[i]))
//                    throw new NullPointerException();
//        }
//        else
//            throw new NullPointerException();
//    }
//
//
//    /**
//     * assert that an android view contains the text
//     * @param id
//     * @param text
//     */
//    public static void isViewContains(int id, String text){
//        onView(withId(id)).inRoot(new ToastMatcher()).check(matches(withText(text)));
//
//    }
//
//    /**
//     * Format String based on arguments
//     */
//    public static String formatString(String format, String... arg  ){
//        return  String.format(format,arg);
//    }
//
//    /**
//     * Returns array of viewable text contained  in the supplied id
//     * @param ids
//     * @return
//     */
//
//    public static String[] getTextArray(int... ids){
//
//        int size =ids.length;
//
//        String[] textArray=new String[size];
//
//        for(int i=0;i<size;++i){
//            textArray[i]=getText(ids[i]);
//        }
//
//        return textArray;
//    }
//    /**
//     * get view text
//     * @param id
//     * @return
//     */
//    public static String  getText(int id){
//
//        return getTextMatcher(getMatchesAllOf(id));
//    }
//    /**
//     * Get android  TextView text displayed in espresso
//     *
//     * @param matcher matcher containing the text view
//     * @return
//     */
//    public static String getTextMatcher(final Matcher<View> matcher) {
//        final String[] stringHolder = {null};
//        onView(matcher).perform(new ViewAction() {
//            @Override
//            public Matcher<View> getConstraints() {
//                return isAssignableFrom(TextView.class);
//            }
//
//            @Override
//            public String getDescription() {
//                return "getting text from a TextView";
//            }
//
//            @Override
//            public void perform(UiController uiController, View view) {
//                TextView tv = (TextView) view;
//                stringHolder[0] = tv.getText().toString();
//            }
//        });
//        return stringHolder[0];
//    }
//
//    /**
//     * Converts string to int
//     * @param string
//     * @return
//     */
//    public static Double getDoubleOf(String string){
//
//        return  Double.parseDouble(string);
//    }
//
//    /**
//     * Removes all non-numeric characters from a string
//     *
//     * @param str to remove non-numeric characters
//     * @return
//     */
//    public static String removeNonNumeric(String str) {
//        return removeSpaces(str).replaceAll("[^\\d.]", "");
//    }
//
//    /**
//     * Removes spaces & special characters from a string
//     *
//     * @param str String to remove the characters
//     * @return
//     */
//    public static String removeSpaces(String str) {
//        return str.replaceAll("\\s+", "");
//    }
//
//    /**
//     * Delay handler for espresso starts here
//     *
//     * @param time
//     * @return
//     */
//    public static IdlingResource startTiming(long time) {
//        IdlingResource idlingResource = new ElapsedTimeIdlingResource(time);
//        Espresso.registerIdlingResources(idlingResource);
//        return idlingResource;
//    }
//
//    /**
//     * Delay handler for espresso stops here
//     *
//     * @param idlingResource
//     */
//    public static void stopTiming(IdlingResource idlingResource) {
//        Espresso.unregisterIdlingResources(idlingResource);
//    }
//
//    /**
//     * Capture Screen shot of the App
//     * Not working yet
//     */
//    public static void captureScreenShot() {
//        try {
//            Runtime.getRuntime().exec("adb shell screencap -p | perl -pe 's/\\x0D\\x0A/\\x0A/g' " +
//                    ">/Users/amoi/Desktop/screen56666.png"
//            );
//        } catch (Exception e) {
//            System.out.println("An exception has occured, reason:" + e);
//            System.exit(0);
//        }
//    }
//}
//
///**
// * Provides utilities/capabilities for managing recycler list view on the android screens
// */
//class RecyclerViewMatcher {
//    private final int recyclerViewId;
//
//    public RecyclerViewMatcher(int recyclerViewId) {
//        this.recyclerViewId = recyclerViewId;
//    }
//
//    public Matcher<View> atPosition(final int position) {
//        return atPositionOnView(position, -1);
//    }
//
//    public Matcher<View> atPositionOnView(final int position, final int targetViewId) {
//
//        return new TypeSafeMatcher<View>() {
//            Resources resources = null;
//            View childView;
//
//            public void describeTo(Description description) {
//                String idDescription = Integer.toString(recyclerViewId);
//                if (this.resources != null) {
//                    try {
//                        idDescription = this.resources.getResourceName(recyclerViewId);
//                    } catch (Resources.NotFoundException var4) {
//                        idDescription = String.format("%s (resource name not found)",
//                                new Object[]{Integer.valueOf
//                                        (recyclerViewId)});
//                    }
//                }
//                description.appendText("with id: " + idDescription);
//            }
//
//            public boolean matchesSafely(View view) {
//
//                this.resources = view.getResources();
//
//                if (childView == null) {
//                    RecyclerView recyclerView =
//                            (RecyclerView) view.getRootView().findViewById(recyclerViewId);
//                    if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
//                        childView = recyclerView.getChildAt(position);
//                    } else {
//                        return false;
//                    }
//                }
//                if (targetViewId == -1) {
//                    return view == childView;
//                } else {
//                    View targetView = childView.findViewById(targetViewId);
//                    return view == targetView;
//                }
//            }
//        };
//    }
//}
//
///**
// * Class for managing of idling resources
// */
//class ElapsedTimeIdlingResource implements IdlingResource {
//    private long startTime;
//    private final long waitingTime;
//    private ResourceCallback resourceCallback;
//
//    public ElapsedTimeIdlingResource(long waitingTime) {
//        this.startTime = System.currentTimeMillis();
//        this.waitingTime = waitingTime;
//    }
//
//    @Override
//    public String getName() {
//        return ElapsedTimeIdlingResource.class.getName() + ":" + waitingTime;
//    }
//
//    @Override
//    public boolean isIdleNow() {
//        long elapsed = System.currentTimeMillis() - startTime;
//        boolean idle = (elapsed >= waitingTime);
//        if (idle) {
//            resourceCallback.onTransitionToIdle();
//        }
//        return idle;
//    }
//
//    @Override
//    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
//        this.resourceCallback = resourceCallback;
//    }
//}
//
///**
// * Class provides utilities/capabilities for capturing toast messages on the Android App Screens
// */
//class ToastMatcher extends TypeSafeMatcher<Root> {
//    @Override
//    public void describeTo(Description description) {
//        description.appendText("Toaster Class");
//    }
//
//    public boolean matchesSafely(Root root) {
//        int type = root.getWindowLayoutParams().get().type;
//        if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
//            IBinder windowToken = root.getDecorView().getWindowToken();
//            IBinder appToken = root.getDecorView().getApplicationWindowToken();
//            if (windowToken == appToken) {
//                return true;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * gets view based on android R id.
//     *
//     * @param id resource unique identfier.
//     */
//    public static ViewInteraction getViewInteraction(int... id) {
//
//
//        return onView(allOf(withId(R.id.input_surname), isDisplayed()));
//
//    }
//}
//
///**
// * class provides capabilities to count recycler view list items.
// */
//class RecyclerViewItemCountAssertion implements ViewAssertion {
//
//    private int expectedCount;
//
//    public RecyclerViewItemCountAssertion(int expectedCount) {
//        this.expectedCount = expectedCount;
//    }
//
//    public void check(View view, NoMatchingViewException noViewFoundException) {
//        if (noViewFoundException != null) {
//            throw noViewFoundException;
//        }
//        RecyclerView recyclerView = (RecyclerView) view;
//        RecyclerView.Adapter adapter = recyclerView.getAdapter();
//        assertThat(adapter.getItemCount(), is(expectedCount));
//    }
//}
//
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
// * Ensure handling of exception does not lead to pass
// * Look for ways to manage ambiquoes exception, to cater for case where item names appers 1+
// * Consider  onView(withRecyclerView(id.recycler_view).atPosition(0)).check(matches(hasDescendant(getMatchesAllOf(produces[0]))));
// * consider a
// * Consider date picker autimation
// */
//
