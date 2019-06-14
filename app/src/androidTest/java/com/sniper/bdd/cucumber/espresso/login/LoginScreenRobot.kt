package com.sniper.bdd.cucumber.espresso.login
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.sniper.bdd.R
import com.sniper.bdd.cucumber.espresso.BaseScreenRobot

class LoginScreenRobot : BaseScreenRobot() {
    fun selectEmailField() {
        clickView(R.id.email)
    }

    fun selectPasswordField() {
        clickView(R.id.password)
    }

    fun enterEmail(email: String) {
        typeViewText(R.id.email, email)
    }

    fun enterPassword(password: String) {
        typeViewText(R.id.password, password)
    }

    fun clickSignInButton() {
        clickWithText(R.string.action_sign_in)
    }

    fun isSuccessfulLogin() {
        matches(R.id.successful_login_text_view, isDisplayed())
        matches(R.id.successful_login_text_view, withText(R.string.successful_login))
//        onView(withId(R.id.successful_login_text_view)).check(matches(isDisplayed()))
//        onView(withId(R.id.successful_login_text_view)).check(matches(withText(R.string.successful_login)))
    }
}
