package base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.Assert.fail;

public class BasePage {

    protected Supplier<Page> page;
    protected Map<String, Supplier<Locator>> locatorMap = new HashMap<>();

    public BasePage(Supplier<Page> page) {
        this.page = page;
    }

    protected void register(String alias, Supplier<Locator> supplier) {
        locatorMap.putIfAbsent(alias, supplier);
    }

    protected void register(Map<String, Supplier<Locator>> map) {
        locatorMap.putAll(map);
    }

    public Page page() {
        return this.page.get();
    }

    public final Locator get(String alias) {
        Locator locator = null;
        try {
            locator = locatorMap.get(alias).get();
        } catch (Exception e) {
            fail("Locator is not registered in this page object.");
        }
        return locator;
    }
}
