package steps.screenContainerModel.apps.sourcedemo;

import base.pages.Pages;
import io.cucumber.java.en.Given;
import steps.screenContainerModel.base.BaseWebSteps;

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

