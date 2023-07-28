Feature: Phonebook

  @dev2
  Scenario: Sample
    Given I start a browser
    And navigate to http://www.cnn.com.br/
    And I start the named browser Second
    And alternate to default browser
    And navigate to http://g1.com.br
    And alternate to browser Second
    And navigate to http://theguardian.co.uk
    And alternate to default browser
    And navigate to http://www.bbc.co.uk

