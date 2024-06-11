@googlepage
Feature: All tests for Google page

  @googlepage1
  Scenario: user fills all required fields
	Given user is on the google page
	When they search for Cucumber Selenium
	And they proceed with the result
	Then the right page is opened
	And they accepts cookies