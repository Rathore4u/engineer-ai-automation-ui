# About Test Automation Framework

This framework is basically developed and designed to automate application product suite test cases. 

# Tools , Approaches and Technologies Used

* Gherkin
* Core Java
* Selenium WebDriver API 3.3.1
* geckodriver 15
* Cucumber
* Page Object Model Design pattern
* Junit
* Maven
* Firefox 52 or lesserfor WD 3 and FF 47 or below for Selenum 2 


# How to Setup & Configure

  1. Should have java8 jdk, maven installed.
  2. Use git lfs clone to download the automation framework to your local system , GIT URL 
  3. Locate pom.XML and right click and choose Run As -> Maven Build
  4. In the run configurations provide below values and click apply and run.

		Goals : generate-resources
		Profiles: <profile-to-be-used>

  5. Check whether the build is successful

# Alternate easier way to run from command line ( given that you have jdk and maven in your system installed)

  6. From command prompt goto project level and execute following command :
	
	mvn -P local clean install -Dtest=LoginTest

# How to run feature specific tests : Only for development purpose.

To run feature specific tests , please edit test runner class ConfigureTest.java and update the tags = "@<feature-name>".

	Examples :
		tags = "@Login"
		tags = "@Home"

To run whole Smoke suite, please edit the test runner class ConfigureTest.java and update the tags = "@SmokeReady"

