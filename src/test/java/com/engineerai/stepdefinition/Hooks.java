package com.engineerai.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.engineerai.lib.WebDriverActions;
import com.engineerai.lib.helper.ScumberException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/** <!-- ========================================================================================================== -->
 * Hook class to ensure that we create a single browser per scenario and clean up the browser instance.
 *
 *
 * @author rathore
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

public class Hooks
{
	private static final Logger	Log	= Logger.getLogger(Hooks.class.getName());

	private WebDriver		itsDriver;

	public Hooks()
	{
		Log.info("Constructor: Hooks");
	}

	@Before
	public void before(final Scenario scenario)
		throws ScumberException
	{
		itsDriver = WebDriverActions.openBrowser(scenario);
	}

	@After
	public void after(final Scenario scenario)
		throws ScumberException
	{
		WebDriverActions.closeBrowser(scenario, itsDriver);
		itsDriver = null;
	}
}
