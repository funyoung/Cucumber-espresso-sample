package com.sniper.bdd.cucumber.espresso

import android.app.Activity
import android.support.annotation.IdRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.view.View
import org.hamcrest.Matcher
import java.lang.Thread.sleep

open class BaseScreenRobot {
    fun launchLoginScreen(testRule: ActivityTestRule<out Activity>) {
        testRule.launchActivity(null)
    }

    fun clickView(id: Int) {
        performClick(onView(withId(id)))
    }

    fun typeViewText(@IdRes id: Int, text: String) {
        onView(withId(id)).perform(typeText(text))
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
        sleep(100)
    }

    fun clickWithText(@IdRes textId: Int) {
        clickWithText(InstrumentationRegistry.getTargetContext().getString(textId))
    }

    private fun clickWithText(text: String) {
        performClick(onView(withText(text)))
    }

    private fun performClick(viewInteraction: ViewInteraction) {
        viewInteraction.perform(click())
    }

    fun matches(@IdRes viewId: Int, matcher: Matcher<View>?) {
        matches(withId(viewId), matcher)
    }

    private fun matches(viewMatcher: Matcher<View>?, matcher: Matcher<View>?) {
        onView(viewMatcher).check(matches(matcher))
    }

    fun matches(viewId: String, matcher: Matcher<View>?) {
        matches(withText(viewId), matcher)
    }
}
