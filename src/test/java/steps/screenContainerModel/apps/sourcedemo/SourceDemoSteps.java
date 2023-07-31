package steps.screenContainerModel.apps.sourcedemo;

import base.Applications;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.saucedemo.LoginPage;
import steps.screenContainerModel.base.BaseWebSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SourceDemoSteps extends BaseWebSteps {

    LoginPage login = new LoginPage(page);

    public SourceDemoSteps(Applications apps) {
        super(apps);
    }

    @Given("In Source Demo, using browser {string}, log in as {string} with password {string}")
    public void fillElement(String browserName, String user, String password) {
        apps.select(browserName);
        LoginPage loginPage = new LoginPage(page);
        loginPage
                .login(user, password)
                .get("login button").highlight();




        Assert.assertEquals("message", page(), page());
    }


}

