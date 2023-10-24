package steps.mixedModel.apps.sourcedemo.steps;

import base.pages.Pages;
import io.cucumber.java.en.Given;
import steps.mixedModel.apps.sourcedemo.pages.SauceDemoPageModels;
import steps.mixedModel.base.BaseWebSteps;

public class SauceDemoSteps2 extends BaseWebSteps {

    protected final SauceDemoPageModels model = new SauceDemoPageModels(() -> page);

    public SauceDemoSteps2(Pages pages) {
        super(pages);
    }

    @Given("In Source Demo 2, using browser page {string}, log in as {string} with password {string}")
    public void fillElement(String alias, String user, String password) {
        page = pages.get(alias);
        model.loginPage.login(user, password);
    }
}

