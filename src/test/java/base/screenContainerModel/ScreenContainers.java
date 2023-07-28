package base.screenContainerModel;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.fail;

public class ScreenContainers {

    private List<Browser> instances;
    private Map<String, ScreenContainer> appMap = new HashMap<>();
    private ScreenContainer currentApp = new ScreenContainer();

    public ScreenContainers() {

    }

    public void registerApp(String name, Browser instance, BrowserContext browser, Page page) {
        ScreenContainer app = new ScreenContainer();
        app.set(name, browser, page);
        try {
            appMap.put(name, app);
            this.currentApp = app;
            try {
                instances.add(browser.browser());
            } catch (Exception ignore) {

            }
        } catch (Exception e) {
            fail("App registered already.");
        }
    }

    public void switchApp(String name) {
        try {
            currentApp = appMap.get(name);
        } catch (Exception e) {
            fail("App has not been registered yet.");
        }
    }

    public Browser getCurrentInstance() {
        return currentApp.page().context().browser();
    }

    public Browser getInstanceByBrowser(String browserType) {
        Browser instance = null;
        for (Browser browser : instances) {
            if (browser.browserType().name().equalsIgnoreCase(browserType))
                instance = browser;
        }
        return instance;
    }

    public List<Browser> getAllInstances() {
        return instances;
    }

    public Supplier<BrowserContext> browser = this::browser;
    public Supplier<Page> page = this::page;

    public BrowserContext browser() {
        return currentApp.browser();
    }

    public Page page() {
        return currentApp.page();
    }

}
