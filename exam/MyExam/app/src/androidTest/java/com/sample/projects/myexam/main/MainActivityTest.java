package com.sample.projects.myexam.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.sample.projects.myexam.BaseTest;
import com.sample.projects.myexam.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by Chyron-MACBOOK on 10/11/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testGetData() throws Exception {
        doSleep(1000);

        viewAction(R.id.mButtonGetData, click());
    }

    @Test
    public void testGetData_ClearCache() throws Exception {
        doSleep(1000);

        viewAction(R.id.mButtonGetData, click());
        doSleep(1000);

        viewAction(R.id.mButtonClearCache, click());
        doSleep(1000);
    }

    @Test
    public void testClearCache() throws Exception {
        doSleep(1000);

        viewAction(R.id.mButtonClearCache, click());
        doSleep(1000);
    }

    @Test
    public void testClearCache_GetData() throws Exception {
        doSleep(1000);

        viewAction(R.id.mButtonClearCache, click());
        doSleep(1000);

        viewAction(R.id.mButtonGetData, click());
        doSleep(1000);
    }

    @Test
    public void testClickItemInRecycler() throws Exception {
        doSleep(1000);

        scrollRecyclerViewToPositionAndClick(R.id.mRecyclerView, 2);
        doSleep(1000);
    }
}