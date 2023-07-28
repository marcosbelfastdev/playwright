package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.fail;

public class Applications {

    private final Playwright playwright;
    private List<Browser> instances;
    private Map<String, Application> appMap = new HashMap<>();
    private Application currentApp = new Application();

    public Applications() {
        playwright = Playwright.create();
    }

    public Supplier<Browser> instance = () -> currentApp.page().context().browser();
    public Supplier<BrowserContext> browser = () -> currentApp.browser();
    public Supplier<Page> page = () -> currentApp.page();

    public void registerApp(String name, Browser instance, BrowserContext browser, Page page) {
        Application app = new Application();
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

    public void select(String name) {
        try {
            currentApp = appMap.get(name);
        } catch (Exception e) {
            fail("App has not been registered yet.");
        }
    }

    public Playwright playwright() {
        return playwright;
    }

    public Browser getCurrentInstance() {
        return currentApp.page().context().browser();
    }

    public BrowserContext browser() {
        return browser.get();
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

}
