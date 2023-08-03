package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.fail;

public class Applications {

    private final Playwright playwright;
    private Map<String, Application> appMap = new HashMap<>();
    private Application currentApp = new Application();

    public Applications() {
        playwright = Playwright.create();
    }

    public Supplier<Browser> instance = () -> currentApp.page().context().browser();
    public Supplier<BrowserContext> browser = () -> currentApp.browser();
    public Supplier<Page> page = () -> currentApp.page();

    public void registerApp(String alias, Page page) {
        Application app = new Application();
        app.set(alias, page);
        try {
            appMap.put(alias, app);
            this.currentApp = app;
        } catch (Exception e) {
            fail("App registered already.");
        }
    }

    public void select(String alias) {
        try {
            currentApp = appMap.get(alias);
        } catch (Exception e) {
            fail("App has not been registered yet.");
        }
    }

    public Playwright playwright() {
        return playwright;
    }

    public Browser getCurrentInstance() {
        return page.get().context().browser();
    }

    public BrowserContext browser() {
        return browser.get();
    }

    public Browser getInstanceByBrowser(String browserType) {
        Browser instance = null;
        for (Application app : appMap.values()) {
            instance = app.browser().browser();
            if (instance.browserType().toString().equalsIgnoreCase(browserType))
                return instance;
        }
        return instance;
    }

    public List<Browser> getAllInstances() {
        List<Browser> instances = new ArrayList<>();
        for (Application app : appMap.values()) {
            instances.add(app.browser().browser());
        }
        return  instances;
    }

    public String alias() {
        return currentApp.alias();
    }

}
