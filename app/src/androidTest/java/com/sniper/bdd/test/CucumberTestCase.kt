package com.sniper.bdd.test

import cucumber.api.CucumberOptions

@CucumberOptions(features = ["features"],
        glue = ["com.sniper.bdd.cucumber.steps"],
        tags = ["@e2e", "@smoke", "@main"])
@Suppress("unused")
class CucumberTestCase
