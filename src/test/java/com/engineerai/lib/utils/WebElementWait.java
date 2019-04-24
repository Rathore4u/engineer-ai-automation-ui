package com.engineerai.lib.utils;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebElementWait
{
	private final static Logger	Log			= Logger.getLogger(WebElementWait.class.getName());
	public final static int		WAIT_TIMEOUT_DEFAULT	= 40;
	protected final WebDriver	itsDriver;
	protected final WebDriverWait	itsWait;

	public WebElementWait(final WebDriver driver)
	{
		itsDriver = driver;
		PageFactory.initElements(driver, this);
		itsWait = createWebWaitDriver(WAIT_TIMEOUT_DEFAULT);
	}

	public WebDriver getDriver()
	{
		return itsDriver;
	}

	/**
	 * <!-- ================================================================================================== -->
	 * @param message
	 * @param element
	 *
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	private void assertCheckIfNotNull(final String message, final WebElement element)
	{
		Assert.assertNotNull(message, element);
	}

	/**
	 * <!-- ================================================================================================== -->
	 * This method will wait till element is Clickable
	 * @param element
	 * @return
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	protected WebElement waitUntilElementIsClickable(final WebElement element)
	{
		final String message = String.format("FAIL : Element with these details is NULL : '%s'", element);
		assertCheckIfNotNull(message, element);
		return itsWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * <!-- ================================================================================================== -->
	 * This method creates a WebDriverWait
	 * @param timeOutInSeconds
	 * @return
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	protected WebDriverWait createWebWaitDriver(final long timeOutInSeconds)
	{
		return new WebDriverWait(itsDriver, timeOutInSeconds);
	}

	/**
	 * This method waits until the element is visible
	 *
	 * @param element
	 *            - WebElement
	 */
	protected WebElement waitUntilElementIsVisible(final WebElement element)
	{
		final String message = String.format("FAIL : Element with these details is NULL : '%s'", element);
		assertCheckIfNotNull(message, element);
		return itsWait.until(ExpectedConditions.visibilityOf(element));
	}

	/**Waits for given amount of time, Since it affects state in the driver we should undo it using a finally.
	 * @param time
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	public void implicitWait(final int time)
	{
		itsDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**Waits for element to be visible within 30 sec
	 * @param webElement
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	public void waitForVisible(final WebElement webElement)
	{
		itsWait.until(ExpectedConditions.visibilityOf(webElement));
	}
}
