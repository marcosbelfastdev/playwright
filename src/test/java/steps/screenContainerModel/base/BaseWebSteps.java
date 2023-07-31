package steps.screenContainerModel.base;

import base.Applications;
import com.microsoft.playwright.*;
import io.cucumber.java.bs.A;
import pages.saucedemo.LoginPage;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Objects.isNull;

public class BaseWebSteps {

    protected Applications apps;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;
    protected Map<String, Object> pageObjectsMap;

    public BaseWebSteps(Applications apps) {
        this.apps = isNull(apps) ? new Applications() : apps;
        browser = apps.browser;
        page = apps.page;
    }

    public Playwright playwright() {
        return apps.playwright();
    }

    public BrowserContext browser() {
        return browser.get();
    }

    public Page page() {
        return page.get();
    }

}

