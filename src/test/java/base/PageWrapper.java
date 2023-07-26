package base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class PageWrapper {
    BrowserContext context;
    Map<String, Page> pageMap = new HashMap<>();

    public PageWrapper(BrowserContext context) {
        this.context = context;
    }

    public void addPage(String name, Page page) {
        try {
            pageMap.put(name, page);
        } catch (Exception e) {
            fail("A page with this name already exists.");
        }
    }

    public Page newPage(String name) {
        Page page = null;
        try {
            page = context.newPage();
            pageMap.put(name, page);
        } catch (Exception e) {
            fail("A page with this name already exists.");
        }
        return page;
    }

   public Page page(String name) {
        try {
            return pageMap.get(name);
        } catch (Exception e) {
            fail("Page does not exist.");
        }
        return null;
   }

}
