package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    AppController app;

    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;

    public Steps(AppController app) {
        this.app = app;
    }

    @Given("^I start the standard browser$")
    public void startStandardBrowser() {

        Assert.assertNull(app.browser());

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        app.setPlaywright(playwright);
        app.addBrowser(browser);
        app.addContext("standard browser", context);
        app.addPage("first page", page);
    }

    @Given("^I start the browser named as (.*)$")
    public void startNamedBrowser(String browserName) {

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        app.setPlaywright(playwright);
        app.addBrowser(browser);
        app.addContext(browserName, context);
        app.switchToContext(browserName);
        app.addPage("first page", page);
        app.switchToPage("first page");
    }

    @And("^navigate to home page$")
    public void navigateToHomePage() {
        app.page().navigate("http://www.cnn.com.br/");
    }
}

