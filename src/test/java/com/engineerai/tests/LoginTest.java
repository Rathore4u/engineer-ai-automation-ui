package com.engineerai.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = { "classpath:feature_files/" }, glue = {
	"com.engineerai.stepdefinition" }, tags = "@Login", plugin = { "pretty", "json:target/cucumber","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output/extent.html" })
public class LoginTest
{

	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void setup()
	{
		// Initiates the extent report and generates the output in the
		// output/Run_<unique timestamp>/report.html file by default.
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// extent.createTest("MyFirstTest", "Test Description").pass("details");


	}
}
