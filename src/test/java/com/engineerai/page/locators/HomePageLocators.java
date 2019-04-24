package com.engineerai.page.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!-- ========================================================================================================== -->
 * This Class contains all locators specific to Login page of Google application
 * @author rathore
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class HomePageLocators
{
	@Autowired
	public HomePageLocators(final WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBys(@FindBy(xpath = "//ul[@role='listbox']/li//span"))
	public WebElement[] autoSuggestionList;

	@FindBy(xpath = "//input[@name='q']")
	public WebElement googleHomeSearchBar;
}