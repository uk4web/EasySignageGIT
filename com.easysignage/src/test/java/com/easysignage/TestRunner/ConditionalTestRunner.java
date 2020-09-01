package com.easysignage.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.easysignage.common.ConfigFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//, plugin = {
//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\java\\com\\easysignage\\features" }, glue = {
		"com.easysignage.steps" }, monochrome = true, tags = {
						"@DeletePlayList " })

public class ConditionalTestRunner {

	@AfterClass
	public static void writeExtentReport() {
	//	Reporter.loadXMLConfig(new File(ConfigFileReader.getInstance().getReportConfigPath()));
	}

}
