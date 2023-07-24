package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

public class AppController {

    private Playwright playwright;
    private Map<BrowserType, Browser> browserMap;
    private ContextController contextController = new ContextController();
    private PageController pageController = new PageController();

    private Browser browser;

    public Playwright playwright() {
        return playwright;
    }

    public void setPlaywright(Playwright playwright) {
        if (isNull(this.playwright))
            this.playwright = playwright;
        else
            fail("The playwright object had been set before.");
    }

    public Browser browser() {
        return browser;
    }

    public Browser getBrowser(BrowserType browserType) {
        return browserMap.get(browserType);
    }

    public void addBrowser(Browser browser) {
        browserMap.putIfAbsent(browser.browserType(), browser);
        if (isNull(this.browser))
            this.browser = browser;
        else
            fail("The browser was set already.");
    }

    public BrowserContext context() {
        return contextController.context();
    }

    public void addContext(String name, BrowserContext context) {
        contextController.addContext(name, context);
    }

    public void newContext(String name, Browser browser) {
        contextController.newContext(name, browser);
    }

    public void switchToContext(String name) {
        contextController.switchTo(name);
    }

    public Page page() {
        return pageController.page();
    }

    public void addPage(String name, Page page) {
       pageController.addPage(name, page);
    }

    public void newPage(String name, BrowserContext context) {
        pageController.newPage(name, context);
    }

    public void switchToPage(String name) {
        pageController.switchTo(name);
    }

}
