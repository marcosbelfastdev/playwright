package base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BasePage {

    protected Page page;
    protected Map<String, Supplier<Locator>> locatorMap = new HashMap<>();

    public BasePage(Page page) {
        this.page = page;
    }
}
