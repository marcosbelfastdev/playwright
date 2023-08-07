Feature: Start different browser contexts/pages and demonstrate that the page object is updated to the browser and page selected, thus, demonstrates that the page object is shared/reutilised across browsers.

  @sourcedemo
  Scenario: Sample
    Given I start a browser page
    And navigate to https://www.saucedemo.com
    And pause 5 seconds for some quick inspection
    And I start the named browser page Second Browser Main Page
    And navigate to https://www.saucedemo.com
    And pause 5 seconds for some quick inspection
    And In Source Demo, using browser page "default", log in as "standard_user" with password "secret_sauce"
    And In Source Demo 2, using browser page "Second Browser Main Page", log in as "problem_user" with password "secret_sauce"
    And I start the named browser page Third
    And navigate to http://theguardian.co.uk
    And pause 5 seconds for some quick inspection
    And alternate to browser page Second Browser Main Page
    And navigate to http://g1.com.br
    And alternate to default browser page
    And navigate to http://www.apple.com.br
    And pause 30 seconds for some quick inspection


