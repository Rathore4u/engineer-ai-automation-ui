package com.engineerai.page.functions;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.engineerai.lib.helper.PropertiesLoader;
import com.engineerai.lib.utils.AbstractBasePage;
import com.engineerai.page.locators.HomePageLocators;

/**
 * <!-- ========================================================================================================== -->
 * This Class contains all method's specific to Login page of Google application
 * @author rathore
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class HomePageObject extends AbstractBasePage
{
	final HomePageLocators homePageLocators;

	@Autowired
	public HomePageObject(final WebDriver driver)
	{
		super(driver);
		homePageLocators = PageFactory.initElements(driver, HomePageLocators.class);
	}

	public Properties testProps()
	{
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void enterSearchKeywordSlowly(final String keyword)
	{
		waitForVisible(homePageLocators.googleHomeSearchBar);
		typeEditBox(homePageLocators.googleHomeSearchBar, keyword);
	}

	public void getListOfAutoSuggestions(String keyword)
	{
		getDriver().switchTo().defaultContent();
		List<WebElement> elements = itsDriver.findElements(By.xpath("//ul[@role='listbox']/li//span"));
		System.out.println("Size of Element list is : "+ elements.size());
		for(int j=0;j<elements.size();j++){
			String elementText="";
			elements = itsDriver.findElements(By.xpath("//ul[@role='listbox']/li//span"));
			elementText = elements.get(j).getText();
			System.out.println("Element Text is: "+ elementText);
			assertCheckIfTrue("Given Keyword not found in current suggestion and it is: "+ elementText, elementText.contains(keyword.toLowerCase()));
		}
	}

	public void verifyHomePageDisplayed()
	{
		waitForVisible(homePageLocators.googleHomeSearchBar);
		assertElementIsVisible(homePageLocators.googleHomeSearchBar, "Home Page is not displayed");
	}
}