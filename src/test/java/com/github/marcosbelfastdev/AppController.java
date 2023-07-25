package com.github.marcosbelfastdev;

import com.microsoft.playwright.*;

import java.util.*;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

public class AppController {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    private Map<String, Browser> browserMap = new HashMap<>();
    private Map<String, BrowserContext> contextMap = new HashMap<>();
    private Map<BrowserContext, PageWrapper> pageWrapperMap = new HashMap<>();


    public Playwright playwright() {
        return playwright;
    }

    public void setPlaywright(Playwright playwright) {
        if (isNull(this.playwright))
            this.playwright = playwright;
    }

    public Browser browser() {
        return browser;
    }

    public BrowserContext context() {
        return context();
    }

    public Browser browser(String browserType) {
        Browser browser = null;
        try {
            browser = browserMap.get(browserType);
        } catch (Exception e) {
            fail("No " + browserType + " browser has been instantiated yet.");
        }
        return browser;
    }

    public Browser newBrowser(String browserType, BrowserType.LaunchOptions launchOptions) {
        Browser browser = null;
        switch (browserType) {
            case "chromium":
                if (!isBrowserInstanceStarted(browserType))
                    browser = playwright().chromium().launch(launchOptions);
                else {
                    this.browser = browser(browserType);
                }
                break;
            case "firefox"  :
                if (!isBrowserInstanceStarted(browserType))
                    browser = playwright().firefox().launch(launchOptions);
                else {
                    this.browser = browser(browserType);
                }
                break;
        }
        browserMap.putIfAbsent(browserType, browser);
        if (isNull(this.browser))
            this.browser = browser;
        return this.browser;
    }

    public boolean isBrowserInstanceStarted(String browserType) {
        Browser browser = null;
        try {
            browser = browserMap.get(browserType);
        } catch (Exception e) {

        }
        if (isNull(browser))
            return false;
        return true;
    }

    public void addContext(String name, BrowserContext context) {
        try {
            contextMap.put(name, context);
        } catch (Exception e) {
            fail("Context exists already.");
        }
    }

    public void newContext(String name, Browser browser) {
        try {
            BrowserContext context = browser.newContext();
            contextMap.put(name, context);
            this.context = context;
        } catch (Exception e) {
            fail("Context exists already.");
        }
    }

    public void switchToContext(String name) {
        try {
            this.context = contextMap.get(name);
        } catch (Exception e) {
            fail("Unknown context.");
        }
    }

    public Page page() {
        return this.page;
    }

    public void newPage(String name) {
        Page page = null;
        try {
            page = pageWrapperMap.get(context).page(name);
        } catch (Exception e) {

        }

        if (isNull(page)) {
            try {
                PageWrapper pageWrapper = new PageWrapper(context);
                this.page = pageWrapper.newPage(name);
                pageWrapperMap.put(context, pageWrapper);
                //pageWrapperMap.get(context).newPage(name);
                return;
            } catch (Exception e) {
                fail("Error trying to add a new page");
            }
        }

        fail("A page with this name already exists.");
    }

    public void addPage(String name, Page page) {
        pageWrapperMap.get(context).addPage(name, page);
    }

    public void switchToPage(String name) {
        this.page = pageWrapperMap.get(context).page(name);
    }

}
