@featureTest
Feature: Login Action

@Scenario1
Scenario: Successful Search of Images on Flikr App
	Given User is on Home Screen
	When User searches for "continents"
#	And  User Navigate to LogIn Page
	Then Search Result displayed Successfully

@Scenario2
Scenario: Verify Images Titles
	When Get Data using API
	Then Titles verified Successfully

