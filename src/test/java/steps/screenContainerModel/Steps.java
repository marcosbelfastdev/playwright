package steps.screenContainerModel;

import base.ScreenContainers;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import steps.screenContainerModel.base.StepsMultipleBrowsers;

import java.util.ArrayList;
import java.util.List;

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

    public Steps(ScreenContainers app) {
        super(app);
    }

    @Given("^I start the named browser (.*)")
    public void startNamedBrowser(String browserName) {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = app.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        app.registerApp(browserName, browser, context, page);
    }

    @Given("^I start a browser")
    public void startStandardBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        List<String> args = new ArrayList<>();
        args.add("--disable-web-security");
        args.add("--disable-features=IsolateOrigins,site-per-process");
        launchOptions.setArgs(args);
        launchOptions.setHeadless(false);
        Browser browser = app.playwright().chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        app.registerApp("default", browser, context, page);
    }

    @And("^alternate to browser (.*)")
    public void alternateToNamedBrowser(String browserName) {
        app.switchApp(browserName);
    }

    @And("^alternate to default browser")
    public void alternateToDefaultBrowser() {
        app.switchApp("default");
    }

    @And("navigate to (.*)$")
    public void navigateToUrl(String url) {
        page().navigate(url);
    }

}

