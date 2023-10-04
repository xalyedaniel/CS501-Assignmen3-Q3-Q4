package com.bignerdranch.android.geoquiz

import android.content.pm.ActivityInfo
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Q34InstrumentedTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun teardown() {
        scenario.close()
    }

    @Test
    //Instrumented Test for Q4
    fun checkCheatActivityResult() {
        onView(withId(R.id.cheat_button)).perform(click())
        onView(withId(R.id.show_answer_button)).perform(click())
        onView(withId(R.id.answer_text_view)).check(ViewAssertions.matches(ViewMatchers.withText("True")))
    }

    @Test
    //Instrumented Test for Q3
    fun checkAfterRotate() {
        onView(withId(R.id.cheat_button)).perform(click())
        onView(withId(R.id.show_answer_button)).perform(click())
        scenario.onActivity { activity -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE}
        onView(withId(R.id.answer_text_view)).check(ViewAssertions.matches(ViewMatchers.withText("True")))
    }
}
