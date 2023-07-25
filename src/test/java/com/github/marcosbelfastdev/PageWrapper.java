package com.github.marcosbelfastdev;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class PageWrapper {
    BrowserContext context;
    Map<String, Page> pageMap = new HashMap<>();

    public PageWrapper(BrowserContext context) {
        this.context = context;
    }

    public void addPage(String name, Page page) {
        try {
            pageMap.put(name, page);
        } catch (Exception e) {
            fail("A page with this name already exists.");
        }
    }

    public void newPage(String name) {
        try {
            pageMap.put(name, context.newPage());
        } catch (Exception e) {
            fail("A page with this name already exists.");
        }
    }

   public Page page(String name) {
        try {
            return pageMap.get(name);
        } catch (Exception e) {
            fail("Page does not exist.");
        }
        return null;
   }

}
