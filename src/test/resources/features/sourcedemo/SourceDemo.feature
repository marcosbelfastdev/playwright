Feature: Phonebook

  @sourcedemo
  Scenario: Sample
    Given I start a browser
    And navigate to https://www.saucedemo.com
    And I start the named browser Second
    And navigate to https://www.saucedemo.com
    And Using browser "default", log in to the application as "standard_user" and password "secret_sauce"
    And Using browser "Second", log in to the application as "problem_user" and password "secret_sauce"


