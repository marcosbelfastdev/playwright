package web.base.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.*;

public class Pages {

    private final Playwright playwright;
    private Map<String, Page> pages = new HashMap<>();
    private String alias;

    public Pages() {
        playwright = Playwright.create();
    }

    public void setPage(String alias, Page page) {
        this.alias = alias;
        pages.put(alias, page);
    }

    public Page get(String alias) {
        return pages.get(alias);
    }

    public List<Page> getAllPages() {
        Set<Page> pageList = new HashSet<>();
        pageList.addAll(pages.values());
        return pageList.stream().toList();
    }

    public Playwright playwright() {
        return playwright;
    }

    public Browser getCurrentInstance() {
        return pages.get(alias).context().browser();
    }

    public Set<Browser> getAllInstances() {
        Set<Browser> instances = new HashSet<>();
        for (Page page : pages.values()) {
            Browser browser = page.context().browser();
            instances.add(browser);
        }
        return instances;
    }

}
