package steps.screenContainerModel.base;

import base.Applications;
import com.microsoft.playwright.*;

import java.util.function.Supplier;

public class BaseWebSteps {

    protected Applications apps;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;

    public BaseWebSteps(Applications apps) {
        this.apps = apps == null ? new Applications() : apps;
        assert apps != null;
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

