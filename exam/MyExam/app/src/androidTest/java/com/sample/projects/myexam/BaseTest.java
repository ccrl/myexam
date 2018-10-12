package com.sample.projects.myexam;


import android.support.test.espresso.ViewAction;

import org.junit.After;
import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Chyron-MACBOOK on 10/11/18.
 */

public class BaseTest {

    @Before
    public void setUp() throws Exception {
        doSleep(1000);
    }

    @After
    public void tearDown() throws Exception {
        doSleep(1000);
    }

    public void doSleep(int sleepTime) throws Exception {
        Thread.sleep(sleepTime);
    }

    public void viewAction(int id, ViewAction action) {
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(action);
    }

    public void scrollRecyclerViewToPositionAndClick(int id, int position) {
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(actionOnItemAtPosition(position, click()));
    }

}
