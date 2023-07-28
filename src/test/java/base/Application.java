package base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class Application {

    private BrowserContext browser;
    private Page page;
    public String name;

    public void set(String name, BrowserContext browser, Page page) {
        this.name = name;
        this.browser = browser;
        this.page = page;
    }

    public BrowserContext browser() {
        return browser();
    }

    public Page page() {
        return this.page;
    }

}
