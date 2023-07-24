package com.github.marcosbelfastdev;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

public class ContextController {

    private Map<String, BrowserContext> contextMap = new HashMap<>();
    private BrowserContext context;

    public void addContext(String name, BrowserContext context) {
        contextMap.put(name, context);
        if (isNull(this.context))
            this.context = context;
    }

    public void newContext(String name, Browser browser) {
        BrowserContext context = browser.newContext();
        contextMap.putIfAbsent(name, context);
        if (isNull(this.context))
            this.context = context;
    }

    public void switchTo(String name) {
        this.context = contextMap.get(name);
    }

    public BrowserContext context() {
        return this.context;
    }


}
