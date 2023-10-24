package steps.mixedModel.setup;

import web.base.pages.Pages;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class BaseBrowserWebSteps extends steps.mixedModel.base.BaseWebSteps {

    public BaseBrowserWebSteps(Pages pages) {
        super(pages);
    }

    @Given("^I start the project named (.*)")
    public void startProject(String project) {

    }

    @Given("^I start the named browser page (.*)")
    public void startNamedBrowser(String alias) {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = pages.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        page = context.newPage();
        pages.setPage(alias, page);
    }

    @Given("^I start a browser page")
    /*
    A highly customisable browser factory can be created:
    - choose browser by input parameter
    - choose browser by config file with list of browsers
    - choose browser by specifying in gherkin (maybe not so good)
     */
    public void startStandardBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = pages.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        page = context.newPage();
        pages.setPage("default", page);
    }

    @And("^alternate to browser page (.*)")
    public void alternateToNamedBrowser(String alias) {
        page = pages.get(alias);
    }

    @And("^alternate to a page with title matching regex (.*)")
    public void alternateToPageMatchingRegex(String regex) {
        for (Page page : pages.getAllPages()) {
            if (page.title().matches(regex)) {
                // ok, supposing only one page will ever match a regex
                // needs changed
                this.page = page;
                break;
            }
        }
    }

    @And("^alternate to default browser page")
    public void alternateToDefaultBrowser() {
        page = pages.get("default");
    }

    @And("navigate to (.*)$")
    public void navigateToUrl(String url) {
        page.navigate(url);
    }

    @And("pause {int} seconds for some quick inspection")
    public void pauseQuickInspection(Integer time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

