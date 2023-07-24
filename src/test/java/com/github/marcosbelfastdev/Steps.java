package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    AppContext app;

    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;

    public Steps(AppContext app) {
        this.app = app;
    }

    @Given("^I start the standard browser$")
    public void startStandardBrowser() {

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        app.setPlaywright(Playwright.create());
        app.setBrowser(app.playwright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)));
        app.setContext(app.browser().newContext());
        app.setPage(app.context().newPage());
    }

    @Given("^I start the browser named as (.*)$")
    public void startNamedBrowser(String browserName) {

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        playwright = Playwright.create();
        switch (browserName) {
            case "Main":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
                break;
        }
        this.context = browser.newContext();
        this.page = context.newPage();

        //page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        //Thread.sleep(10000);

    }

    @And("^navigate to home page$")
    public void navigateToHomePage() {
        app.page().navigate("http://www.cnn.com.br/");
    }
}

