package steps.screenContainerModel.base;

import base.Applications;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import pages.saucedemo.LoginPage;

import java.util.function.Supplier;

public class ActionsWebSteps extends BaseWebSteps {

    protected Applications apps;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;

    public ActionsWebSteps(Applications apps) {
        super(apps);
    }

}

