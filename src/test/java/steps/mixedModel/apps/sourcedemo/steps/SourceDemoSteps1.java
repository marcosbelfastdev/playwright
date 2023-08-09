package steps.mixedModel.apps.sourcedemo.steps;

import base.pages.Pages;
import io.cucumber.java.en.Given;
import steps.mixedModel.apps.sourcedemo.pages.SourceDemoPageModels;
import steps.mixedModel.base.BaseWebSteps;

@SuppressWarnings("unchecked")
public class SourceDemoSteps1 extends BaseWebSteps {


    protected final SourceDemoPageModels model = new SourceDemoPageModels(() -> page);

    public SourceDemoSteps1(Pages pages) {
        super(pages);
    }

    @Given("In Source Demo, using browser page {string}, log in as {string} with password {string}")
    public void fillElement(String alias, String user, String password) {
        page = pages.get(alias);
        model.loginPage.login(user, password);
    }
}

