package com.sniper.bdd.cucumber.steps

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import com.sniper.bdd.R
import com.sniper.bdd.cucumber.espresso.BaseScreenRobot
import com.sniper.bdd.utils.ActivityFinisher

// important notes:
// MUST NOT move setup() and tearDown() into this super class, or
// it will fail to run tests.
open class BaseSteps {
    @Throws(Throwable::class)
    protected fun launchScreen(robot: BaseScreenRobot, activityClassName: String) {
        val activityClass = Class.forName(activityClassName) as Class<Activity>
        launchScreen(robot, activityClass)
    }

    protected fun launchScreen(robot: BaseScreenRobot, activityClass: Class<out Activity>) {
        val activityRule = ActivityTestRule(activityClass, false, false)
        robot.launchLoginScreen(activityRule)
        //activityRule.launchActivity(null);
    }

    @Throws(NoSuchFieldException::class, IllegalAccessException::class)
    protected fun resolve(id: String): Int {
        val clazz = R.id::class.java
        val field = clazz.getField(id)

        return field.getInt(field)
    }

    protected fun finishOpenActivities() {
        // todo: study about ActivityFinisher
        // java call kotlin non static method of companion class
        ActivityFinisher.finishOpenActivities()
    }
}
