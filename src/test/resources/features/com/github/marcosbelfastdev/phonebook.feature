Feature: Phonebook

  @dev
  Scenario: Sample
    Given I start the default browser
    And navigate to http://www.cnn.com.br/
    And I start the browser
      | Second | firefox |
    And switch to browser named as Second
    And navigate to http://www.google.com
    And wait 10000

