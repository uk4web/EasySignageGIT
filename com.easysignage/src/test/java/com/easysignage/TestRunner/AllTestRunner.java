package com.easysignage.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\java\\com\\easysignage\\features" }, glue = { "com.easysignage.steps" })
public class AllTestRunner {

}
