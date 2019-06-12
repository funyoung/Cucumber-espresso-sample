package com.sniper.bdd.cucumber.runner;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import com.sniper.bdd.BuildConfig;
import cucumber.api.android.CucumberInstrumentationCore;

@SuppressWarnings("unused")
public class CucumberTestRunner extends AndroidJUnitRunner {

    private static final String CUCUMBER_TAGS_KEY = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        parseTestTags(bundle);
        parseTestScenario(bundle);
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    private void parseTestScenario(Bundle bundle) {
        String scenario = BuildConfig.TEST_SCENARIO;
        if (!scenario.isEmpty()) {
            scenario = scenario.replaceAll(" ", "\\\\s");
            bundle.putString(CUCUMBER_SCENARIO_KEY, scenario);
        }
    }

    private void parseTestTags(Bundle bundle) {
        String tags = BuildConfig.TEST_TAGS;
        if (!tags.isEmpty()) {
            tags = tags.replaceAll("\\s", "");
            bundle.putString(CUCUMBER_TAGS_KEY, tags);
        }
    }

    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
