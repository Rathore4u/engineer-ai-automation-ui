package com.engineerai.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriverException;

import com.engineerai.lib.helper.ScumberException;

import cucumber.api.Scenario;

/** <!-- ========================================================================================================== -->
 * Several actions that can be performed on a webdriver.
 * This class also contains a cache of active WebDrivers based on scenarios so that they
 * can be reused accross step definitions.
 *
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

public class WebDriverActions
{
	private static final Logger		Log		= Logger.getLogger(WebDriverActions.class.getName());

	private static Map<String, WebDriver>	DRIVER_CACHE	= new HashMap<>();
	private static Object			MONITOR		= new Object();

	private WebDriverActions()
	{
		// Should not be instantiated directly
	}

	public static WebDriver openBrowser(final Scenario scenario)
		throws ScumberException
	{
		Log.info("Called openBrowser Name: " + scenario.getName() + " ID: " + scenario.getId());

		final String id = scenario.getId();

		synchronized (MONITOR)
		{
			final WebDriver driver = DRIVER_CACHE.get(id);

			if (driver != null)
			{
				// Driver already exists, thus lets reuse it.
				return driver;
			}

			final WebDriver newDriver = WebDriverFactory.createWebDriver();

			initDriver(newDriver);

			DRIVER_CACHE.put(id, newDriver);

			return newDriver;
		}
	}

	private static void freeDriver(final String id)
	{
		synchronized (MONITOR)
		{
			final WebDriver driver = DRIVER_CACHE.remove(id);

			assert driver != null : "Expected to have a driver to free: " + id;
			if (driver != null)
			{
				driver.quit();
			}
		}
	}

	private static void initDriver(final WebDriver driver)
	{
		final String userDir = System.getProperty("user.dir");

		Log.info("Initializing new driver for user: " + userDir);

		final Options manage = driver.manage();

		manage.deleteAllCookies();
		manage.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		manage.window().maximize();
	}

	public static void closeBrowser(final Scenario scenario, final WebDriver driver)
	{
		Log.info("Called closeBrowser Name: " + scenario.getName() + " ID: " + scenario.getId());

		try
		{
			if (scenario.isFailed())
				embedScreenShot(scenario, driver);

			// Close driver
			driver.quit();
		}
		finally
		{
			freeDriver(scenario.getId());
		}
	}

	public static void embedScreenShot(final Scenario scenario, final WebDriver driver)
	{
		Log.info("Called embedScreenShot Name: " + scenario.getName() + " ID: " + scenario.getId());

		try
		{
			scenario.write("Current Page URL is " + driver.getCurrentUrl());

			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		catch (final WebDriverException somePlatformsDontSupportScreenshots)
		{
			Log.warning(somePlatformsDontSupportScreenshots.getMessage());
		}
	}
}
