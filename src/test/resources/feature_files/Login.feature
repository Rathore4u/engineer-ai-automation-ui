Feature: Google.com Basic Search Auto Suggestion Feature Test

Background:
    Given user navigates to URL : "${application.url}" application

@Login @SmokeReady
Scenario: Verify that Google Search Auto Suggestion Works fine
	Given that I am on Google Home page
	When I type the "${searchKeyword}" slowly
	Then I verify each list item of auto suggestion contains "${searchKeyword}"