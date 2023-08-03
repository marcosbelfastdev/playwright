package steps.screenContainerModel.setup;

import base.Applications;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/*
    Este modelo torna a evolu��o dos testes mais escalon�vel porque
    possibilita f�cil agrega��o de novos browsers, contextos (apps),
    n�o limitando a automa��o a apenas um �nico browser.

    Esta classe de steps pode ser utilizada somente para lidar com a troca de contextos,
    inicializa��o de contextos etc., mas poderia ser utilizada somente com o par�metro apps
    no construtor.
    As demais classes utilizariam apenas o objeto 'page'.
 */

public class BaseWebSteps extends steps.screenContainerModel.base.BaseWebSteps {

    public BaseWebSteps(Applications apps) {
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
        apps.registerApp(browserName, page);
    }

    @Given("^I start a browser")
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
        Browser browser = apps.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        apps.registerApp("default", page);
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

    @And("pause {int} seconds for some quick inspection")
    public void pauseQuickInspection(Integer time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

