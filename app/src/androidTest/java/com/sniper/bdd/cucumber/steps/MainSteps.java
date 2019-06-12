package com.sniper.bdd.cucumber.steps;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.sniper.bdd.LoginActivity;
import com.sniper.bdd.R;
import com.sniper.bdd.utils.ActivityFinisher;

import java.lang.reflect.Field;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainSteps {
  @Before
  public void setup() {
    //not needed now, but you may needed to setup mock responses before your screen starts
  }

  @After
  public void tearDown() {
    // todo: study about ActivityFinisher
    // java call kotlin non static method of companion class
     ActivityFinisher.Companion.finishOpenActivities(); // Required for test scenarios with multiple activities or scenarios with more cases
  }

  @Given("^I've launched \"([^\"]*)\"$")
  public void I_ve_launched_(String activityClassName) throws Throwable {
    Class<? extends Activity> activityClass =
            (Class<? extends Activity>) Class.forName(activityClassName);

    //String targetPackage = getInstrumentation().getTargetContext().getPackageName();
    //currentActivity = launchActivity(targetPackage, activityClass, null);

    ActivityTestRule activityRule = new ActivityTestRule(activityClass, false, false);
    activityRule.launchActivity(null);
  }

  @When("^I click \"([^\"]*)\" widget$")
  public void I_click_(String id) throws Throwable {
    onView(withId(resolve(id))).perform(click());
  }

  @Then("^I should see \"([^\"]*)\"$")
  public void I_should_see_(String text) {
    onView(withText(text)).check(matches(isDisplayed()));
  }

  private int resolve(String id) throws NoSuchFieldException, IllegalAccessException {
    Class<?> clazz = R.id.class;
    Field field = clazz.getField(id);

    return field.getInt(field);
  }
}
