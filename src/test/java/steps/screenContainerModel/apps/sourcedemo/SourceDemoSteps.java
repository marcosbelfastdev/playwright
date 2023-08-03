package steps.screenContainerModel.apps.sourcedemo;

import base.Applications;
import io.cucumber.java.en.Given;
import pages.saucedemo.LoginPage;
import steps.screenContainerModel.base.BaseWebSteps;

public class SourceDemoSteps extends BaseWebSteps {

    public SourceDemoSteps(Applications apps) {
        super(apps);
    }

    @Given("In Source Demo, using browser {string}, log in as {string} with password {string}")
    public void fillElement(String browserName, String user, String password) {
        apps.select(browserName);
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(user, password);
        //loginPage.get("login button error");
    }


}

