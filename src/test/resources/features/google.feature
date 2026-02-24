@ui
Feature: Google

Scenario: Search Selenium
Given User opens Google
When User searches "Selenium"
Then Title contains "Selenium"

Scenario: Search Cucumber
Given User opens Google
When User searches "Cucumber"
Then Title contains "Cucumber"