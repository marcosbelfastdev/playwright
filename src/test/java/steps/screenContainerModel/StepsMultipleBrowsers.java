package steps.screenContainerModel;

import base.screenContainerModel.ScreenContainers;
import com.microsoft.playwright.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/*
    Este modelo torna a evolu��o dos testes mais escalon�vel porque
    possibilita f�cil agrega��o de novos browsers, contextos (apps),
    n�o limitando a automa��o a apenas um �nico browser.

    Esta classe de steps pode ser utilizada somente para lidar com a troca de contextos,
    inicializa��o de contextos etc., mas poderia ser utilizada somente com o par�metro apps
    no construtor.
    As demais classes utilizariam apenas o objeto 'page'.
 */

public class StepsMultipleBrowsers {

    protected ScreenContainers app;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;
    protected Playwright playwright = Playwright.create();


    public StepsMultipleBrowsers(ScreenContainers app) {
        this.app = app == null ? new ScreenContainers() : app;
        browser = app.browser;
        page = app.page;
    }

    public Page page() {
        return page.get();
    }

    public BrowserContext browser() {
        return browser.get();
    }

}

