package com.tbfajri.academy.ui.academy;

import com.tbfajri.academy.R;
import com.tbfajri.academy.testing.SingleFragmentActivity;
import com.tbfajri.academy.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AcademyFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private AcademyFragment academyFragment = new AcademyFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(academyFragment);
    }

    @Test
    public void loadCourses() {

        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()));

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        onView(withId(R.id.rv_academy)).check(new RecyclerViewItemCountAssertion(5));
    }
}