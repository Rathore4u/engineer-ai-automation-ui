package com.engineerai.tests;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = { "classpath:feature_files/" }, glue = { "com.engineerai.stepdefinition"}, plugin = { "pretty", "json:target/cucumber" })
public class MasterTest
{

}