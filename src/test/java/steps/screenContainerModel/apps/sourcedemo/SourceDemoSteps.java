package steps.screenContainerModel.apps.sourcedemo;

import base.Applications;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.saucedemo.LoginPage;
import steps.screenContainerModel.base.BaseWebSteps;

import java.util.ArrayList;
import java.util.List;

public class SourceDemoSteps extends BaseWebSteps {

    LoginPage loginPage = new LoginPage(page());

    public SourceDemoSteps(Applications apps) {
        super(apps);
    }

    @Given("fill {string} in {string}")
    public void fillElement(String text, String element) {
        loginPage.locator(element).fill(text);
    }

}

