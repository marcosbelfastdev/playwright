Feature: Phonebook

  @dev
  Scenario: Sample
    Given I start the default browser
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Second | firefox |
    And I start a named browser of type
      | Third | chromium |
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Fourth | firefox |
    And I start a named browser of type
      | Fifth | chromium |
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Sixth | firefox |
    And switch to browser named as Second
    And navigate to http://g1.com.br
    #And alternate to default browser
    #And alternate to the browser named
    And wait 10000

