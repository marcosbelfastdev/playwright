package com.github.marcosbelfastdev;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class PageController {


    private Map<String, Page> pageMap = new HashMap<>();
    private Page page;

    public void addPage(String name, Page page) {
        pageMap.put(name, page);
        if (isNull(this.page))
            this.page = page;
    }

    public void newPage(String name, BrowserContext context) {
        Page page = context.newPage();
        pageMap.put(name, page);
        if (isNull(this.page))
            this.page = page;
    }

    public void switchTo(String name) {
        this.page = pageMap.get(name);
    }

    public Page page() {
        return this.page;
    }

}
