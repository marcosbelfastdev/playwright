package steps.screenContainerModel.base;

import base.ScreenContainers;
import com.microsoft.playwright.*;

import java.util.function.Supplier;

/*
    Este modelo torna a evolução dos testes mais escalonável porque
    possibilita fácil agregação de novos browsers, contextos (apps),
    não limitando a automação a apenas um único browser.

    Esta classe de steps pode ser utilizada somente para lidar com a troca de contextos,
    inicialização de contextos etc., mas poderia ser utilizada somente com o parâmetro apps
    no construtor.
    As demais classes utilizariam apenas o objeto 'page'.
 */

public class StepsMultipleBrowsers {

    protected ScreenContainers app;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;

    public StepsMultipleBrowsers(ScreenContainers app) {
        this.app = app == null ? new ScreenContainers() : app;
        browser = app.browser;
        page = app.page;
    }

    public Playwright playwright() {
        return app.playwright();
    }

    public BrowserContext browser() {
        return browser.get();
    }

    public Page page() {
        return page.get();
    }

}

