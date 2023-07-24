package com.github.marcosbelfastdev;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

public class AppContext {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

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

    public void setBrowser(Browser browser) {
        if (isNull(this.browser))
            this.browser = browser;
        else
            fail("The browser was set already.");
    }


    public Page page() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public BrowserContext context() {
        return context;
    }

    public void setContext(BrowserContext context) {
        this.context = context;
    }

}
