Notes before we start about framework:
1. This is an incremental commits for automation project done.
2. the major chunk of utils, helpers, driver management is taken from existing project
3. Further problem specific code is written during this 1 hour of problem and added via commits.
4. Question 1 & 2 are fully attended. For question 3 - part 2 - Not reporting Failures looks like invalid question,
As a quality Assurance person, i would never suggest to hide failures. Its doable via iTestListener by just adding @OnFailure do nothing,
but due to short time given as well as this being against quality assurance aspects, i did not attend it.
5. Since this is not a node JS project where its possible to manage drivers via NPM package and automatically download whole bunch which can be used per browser and OS,
hence here i have added only "chromedriver" for OSX, for any other operating system or browser you need to add respective driver, such as for windows Chome one need to add Chromedriver.exe to "resource/*" location
6. Follow command line execution given below, as that's easiest to execute if you have jdk8 installed, maven & respective driver in given location of project
7. Many aspects can be more generalized and optimized, but given just 1 hour for this problem, i did what i could. 


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

