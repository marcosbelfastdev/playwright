package steps.screenContainerModel;

import base.screenContainerModel.ScreenContainer;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

public class StepsDesktopBrowser extends Hooks {

    ScreenContainer app;
    ScreenContainer app1;
    ScreenContainer app2;

    Playwright playwright;

    public void setApp(ScreenContainer app) {
        this.app = app;
    }

    public void switchToApp(String name) {
        ScreenContainer app = null;
        if (app1.name.equals(name))
            app = app1;
        if (app2.name.equals(name))
            app = app2;
        this.app = app;
    }

    public StepsDesktopBrowser(ScreenContainer app) {
        this.app = app;
    }

    @Given("^I start the named browser (.*)")
    public void startStandardBrowser(String browserName) {

        switchToApp(browserName);

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        playwright = Playwright.create();
        app.setInstance(instance);
        app.setBrowser(instance.newContext());
        app.setPage(browser.newPage());
    }

    @Given("^I start the named browser (.*)")
    public void startStandardBrowser(String browserName) {

        switchToApp(browserName);

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        playwright = Playwright.create();
        app.setInstance(instance);
        app.setBrowser(instance.newContext());
        app.setPage(browser.newPage());
    }

    @And("^alternate to browser (.*)")
    public void alternateToNamedBrowser(String browserName) {
        switchToApp(browserName);
        app.page().bringToFront();
    }



}

