package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

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

        Assert.assertNull(app.playwright());

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        Playwright playwright = Playwright.create();
        app.setPlaywright(playwright);
        app.newBrowser("chromium", new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        app.newContext("standard");
        app.newPage("first");
    }

    @Given("^I start the browser named as (.*)$")
    public void startNamedBrowser(String browserName) {
        Assert.assertNotNull(app.playwright());
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        app.setPlaywright(playwright);
        if (isNull(app.browser()))
            app.newBrowser("chromium", new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        app.newContext(browserName);
        app.switchToContext(browserName);
        app.newPage("standard");
        app.switchToPage("standard");
    }

    @Given("^I start the browser named as (.*) of type (.*)$")
    public void startNamedBrowserInstance(String browserName, String browserType) {

        Assert.assertNotNull(app.playwright());
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        app.setPlaywright(playwright);
        if (isNull(app.browser()))
            app.newBrowser(browserType, new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        app.newContext(browserName);
        app.switchToContext(browserName);
        app.newPage("standard");
        app.switchToPage("standard");
    }

    @And("^navigate to home page$")
    public void navigateToHomePage() {
        app.page().navigate("http://www.cnn.com.br/");
    }

    @And("ˆswitch to the standard browser")
    public void switchToBrowser() {
        app.switchToContext("standard");
        app.switchToPage("stardard");
        app.page().navigate("http://theguardian.co.uk/");
    }
}

