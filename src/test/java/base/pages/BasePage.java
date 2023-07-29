package base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BasePage {

    protected Supplier<Page> page;
    protected Map<String, Supplier<Locator>> locatorMap = new HashMap<>();

    public BasePage(Supplier<Page> page) {
        this.page = page;
    }

    public Page page() {
        return this.page.get();
    }
}
