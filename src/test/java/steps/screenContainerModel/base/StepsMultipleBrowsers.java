package steps.screenContainerModel.base;

import base.Applications;
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

    protected Applications apps;
    protected Supplier<BrowserContext> browser;
    protected Supplier<Page> page;

    public StepsMultipleBrowsers(Applications apps) {
        this.apps = apps == null ? new Applications() : apps;
        assert apps != null;
        browser = apps.browser;
        page = apps.page;
    }

    public Playwright playwright() {
        return apps.playwright();
    }

    public BrowserContext browser() {
        return browser.get();
    }

    public Page page() {
        return page.get();
    }

}

