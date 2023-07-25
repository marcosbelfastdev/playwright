package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;
import io.cucumber.datatable.DataTable;
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

    @Given("^I start the default browser")
    public void startStandardBrowser() {

        Assert.assertNull(app.playwright());

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        Playwright playwright = Playwright.create();
        app.setPlaywright(playwright);
        app.newContext("default",
                app.newBrowser("chromium", new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)
                )
        );
        //app.switchToContext("default");
        app.newPage("default");
        //app.switchToPage("default");
    }

    @Given("^I start the browser named as (.*)$")
    public void startNamedBrowser(String browserName) {
        Assert.assertNotNull(app.playwright());
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        //app.setPlaywright(playwright);
        app.newContext(browserName,
                app.newBrowser("chromium", new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)
                )
        );
        //app.switchToContext(browserName);
        app.newPage("default");
        //app.switchToPage("default");
    }

    @Given("^I start a named browser of type")
    public void startNamedBrowserInstance(DataTable table) {

        String browserName;
        String browserType;
        if (table == null) {
            browserName = "default";
            browserType = "chromium";
        } else {
            try {
                browserType = table.cell(0, 1);
            } catch (Exception e) {
                browserType = "chromium";
            }
            browserName = table.cell(0,0);
        }

        Assert.assertNotNull(app.playwright());
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        app.setPlaywright(playwright);
        app.newContext(browserName,
                app.newBrowser(
                        browserType,
                        new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50)
                )
        );
        app.switchToContext(browserName);
        app.newPage("standard");
        app.switchToPage("standard");
    }

//    @And("^navigate to home page$")
//    public void navigateToHomePage() {
//        app.page().navigate("http://www.cnn.com.br/");
//    }

    @And("navigate to (.*)$")
    public void navigateToUrl(String url) {
        app.page().navigate(url);
    }

    @And("ˆswitch to the standard browser")
    public void switchToBrowser() {
        app.switchToContext("standard");
        app.switchToPage("standard");
        app.page().navigate("http://theguardian.co.uk/");
    }

//    @And("Switch to browser named as (.*)$")
//    public void switchToNamedBrowser(String browserName) {
//        app.switchToContext(browserName);
//        app.switchToPage("standard");
//        app.page().navigate("http://theguardian.co.uk/");
//    }

    @And("switch to browser named as (.*)$")
    public void switchToBrowserNamedAs(String browserName) {
        app.switchToContext(browserName);
        app.switchToPage("standard");
        //app.page().navigate("http://theguardian.co.uk/");
    }

    @And("wait {int}")
    public void wait(int arg0) {
        try {
            Thread.sleep(arg0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

