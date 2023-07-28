package steps.screenContainerModel.base;

import base.Applications;
import com.microsoft.playwright.*;

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

