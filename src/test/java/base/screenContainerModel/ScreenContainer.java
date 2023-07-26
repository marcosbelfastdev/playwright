package base.screenContainerModel;

import base.appControllerModel.PageWrapper;
import com.microsoft.playwright.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

public class ScreenContainer {

    private Browser instance;
    private BrowserContext browser;
    private Page page;
    public String name;

    public void set(Browser instance, BrowserContext browser, Page page) {
        this.instance = instance;
        this.browser = browser;
        this.page = page;
    }

    public Browser instance() {
        return instance;
    }

    public BrowserContext browser() {
        return browser();
    }

    public Page page() {
        return this.page;
    }

}
