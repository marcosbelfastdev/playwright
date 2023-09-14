package steps.mixedModel.apps.sourcedemo.steps;

import web.base.pages.Pages;
import io.cucumber.java.en.Given;
import steps.mixedModel.apps.sourcedemo.pages.SauceDemoPageModels;
import steps.mixedModel.base.BaseWebSteps;

@SuppressWarnings("unchecked")
public class SauceDemoSteps1 extends BaseWebSteps {


    protected final SauceDemoPageModels model = new SauceDemoPageModels(() -> page);

    public SauceDemoSteps1(Pages pages) {
        super(pages);
    }

    @Given("In Source Demo, using browser page {string}, log in as {string} with password {string}")
    public void fillElement(String alias, String user, String password) {
        page = pages.get(alias);
        model.loginPage.login(user, password);
    }
}

