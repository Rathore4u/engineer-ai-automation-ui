package com.engineerai.stepdefinition;

import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.engineerai.lib.WebDriverActions;
import com.engineerai.lib.helper.ScumberException;
import com.engineerai.page.functions.HomePageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSD
{
	private final static Logger	Log	= Logger.getLogger(LoginSD.class.getName());

	private WebDriver		itsDriver;
	private HomePageObject itsLoginPage;

	public LoginSD()
	{
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario)
		throws ScumberException
	{
		itsDriver = WebDriverActions.openBrowser(scenario);
		itsLoginPage = PageFactory.initElements(itsDriver, HomePageObject.class);
	}

	@Given("^user navigates to URL : \"([^\"]*)\" application$")
	public void navigateAdminUI(final String appURL)
	{
		itsDriver.get(appURL);
	}

	@Given("^that I am on Google Home page$")
	public void checkHomePageIsDisplayed()
	{
		itsLoginPage.verifyHomePageDisplayed();
	}

	@When("^I type the \"([^\"]*)\" slowly$")
	public void typeSearchKeywordSlowly(String keyword)
	{
		itsLoginPage.enterSearchKeywordSlowly(keyword);
	}

	@Then("^I verify each list item of auto suggestion contains \"([^\"]*)\"$")
	public void verifyAutoSuggestions(String keyword)
	{
		itsLoginPage.getListOfAutoSuggestions(keyword);
	}
}
