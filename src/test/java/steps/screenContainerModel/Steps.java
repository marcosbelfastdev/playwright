package steps.screenContainerModel;

import base.Applications;
import com.microsoft.playwright.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import steps.screenContainerModel.base.StepsMultipleBrowsers;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.Assert.fail;

/*
    Este modelo torna a evolução dos testes mais escalonável porque
    possibilita fácil agregação de novos browsers, contextos (apps),
    não limitando a automação a apenas um único browser.

    Esta classe de steps pode ser utilizada somente para lidar com a troca de contextos,
    inicialização de contextos etc., mas poderia ser utilizada somente com o parâmetro apps
    no construtor.
    As demais classes utilizariam apenas o objeto 'page'.
 */

public class Steps extends StepsMultipleBrowsers {

    public Steps(Applications apps) {
        super(apps);
    }

    @Given("^I start the named browser (.*)")
    public void startNamedBrowser(String browserName) {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = apps.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        apps.registerApp(browserName, browser, context, page);
    }

    @Given("^I start a browser")
    public void startStandardBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = apps.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        apps.registerApp("default", browser, context, page);
    }

    @Given("^I start browsers as below")
    public void startAnyBrowsersAndTypes(DataTable table) {
        Browser browser = null;
        BrowserContext context = null;
        Page page = null;

        for (int i = 0; i < table.height(); i++) {
            String browserName = table.cell(i, 0);
            String browserType = table.cell(i, 1);

            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            List<String> args = new ArrayList<>();
            args.add("--disable-web-security");
            args.add("--disable-features=IsolateOrigins,site-per-process");
            launchOptions.setArgs(args);
            launchOptions.setHeadless(false);

            /*
            controlar por dentro do objeto apps
            ter launchOptions dentro do apps?
             */

//            if (isNull(apps.getCurrentInstance()))
//                browser = apps.playwright().chromium().launch(launchOptions);
//            else
//                browser = apps.getCurrentInstance();
//            if (isNull(apps.browser())) {
//                assert browser != null;
//                context = browser.newContext();
//            } else
//                fail("Browser " + browserName + " had started before.");

//            apps.registerApp(browserName, browser, context, page);
        }
    }

    @And("^alternate to browser (.*)")
    public void alternateToNamedBrowser(String browserName) {
        apps.select(browserName);
    }

    @And("^alternate to default browser")
    public void alternateToDefaultBrowser() {
        apps.select("default");
    }

    @And("navigate to (.*)$")
    public void navigateToUrl(String url) {
        page().navigate(url);
    }

}

