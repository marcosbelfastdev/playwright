Feature: Phonebook

  @dev
  Scenario: Sample
    Given I start the default browser
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Second | firefox |
    And navigate to http://g1.com.br
    And I start a named browser of type
      | Third | chromium |
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Fourth | firefox |
    And navigate to http://g1.com.br
    And I start a named browser of type
      | Fifth | chromium |
    And navigate to http://www.cnn.com.br/
    And I start a named browser of type
      | Sixth | firefox |
    And navigate to http://g1.com.br
    And switch to browser named as Second
    And navigate to http://www.google.com
    And switch to the standard browser
    And navigate to http://www.bbc.co.uk
    #And switch to named browser Fourth
    #And alternate to default browser
    #And alternate to the browser named
    And wait 100000

