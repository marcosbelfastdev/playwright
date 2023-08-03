package base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class Application {

    private BrowserContext browser;
    private Page page;
    public String alias;

    public void set(String name, Page page) {
        this.alias = name;
        this.browser = page.context();
        this.page = page;
    }

    public BrowserContext browser() {
        return browser();
    }

    public Page page() {
        return this.page;
    }

    public String alias() {
        return this.alias;
    }

}
