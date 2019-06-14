package com.sniper.bdd.cucumber.steps;

import com.sniper.bdd.cucumber.espresso.BaseScreenRobot;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class MainSteps extends BaseSteps {
  private final BaseScreenRobot robot = new BaseScreenRobot();

  @Before
  public void setup() {
    //not needed now, but you may needed to setup mock responses before your screen starts
  }

  @After
  public void tearDown() {
    finishOpenActivities(); // Required for test scenarios with multiple activities or scenarios with more cases
  }

  @Given("^I've launched \"([^\"]*)\"$")
  public void I_ve_launched_(String activityClassName) throws Throwable {
//    Class<? extends Activity> activityClass =
//            (Class<? extends Activity>) Class.forName(activityClassName);

    //String targetPackage = getInstrumentation().getTargetContext().getPackageName();
    //currentActivity = launchActivity(targetPackage, activityClass, null);

//    ActivityTestRule activityRule = new ActivityTestRule(activityClass, false, false);
//    activityRule.launchActivity(null);
    launchScreen(robot, activityClassName);
  }

  @When("^I click \"([^\"]*)\" widget$")
  public void I_click_(String id) throws Throwable {
//    onView(withId(resolve(id))).perform(click());
    robot.clickView(resolve(id));
  }

  @Then("^I should see \"([^\"]*)\"$")
  public void I_should_see_(String text) {
//    onView(withText(text)).check(matches(isDisplayed()));
    //robot.closeKeyboard();
    robot.matches(text, isDisplayed());
  }
}
