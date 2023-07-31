Feature: Start different browser contexts/pages and demonstrate that the page object is updated to the browser and page selected, thus, demonstrates that the page object is shared/reutilised across browsers.

  @sourcedemo
  Scenario: Sample
    Given I start a browser
    And navigate to https://www.saucedemo.com
    And I start the named browser Second
    And navigate to https://www.saucedemo.com
    And In Source Demo, using browser "default", log in as "standard_user" with password "secret_sauce"
    And In Source Demo, using browser "Second", log in as "problem_user" with password "secret_sauce"
    And navigate to http://g1.com.br


