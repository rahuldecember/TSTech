@featureTest
Feature: UI data Test

@Scenario1
Scenario: Search of Images on Flikr App
	Given User is on Home Screen
	When User searches for images with "continents" text.
	Then Search Result displayed Successfully
	Then Get Data using API "continents"
	Then Titles verified Successfully

