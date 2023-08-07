package steps.screenContainerModel.apps.sourcedemo;

import com.microsoft.playwright.Page;
import pages.saucedemo.LoginPage;

import java.util.function.Supplier;

public class SourceDemoPageModels {

    private final Supplier<Page> supplierPage;

    public SourceDemoPageModels(Supplier<Page> supplierPage) {
        this.supplierPage = supplierPage;
        initModels();
    }

    private void initModels() {
        loginPage = new LoginPage(supplierPage);
    }

    public LoginPage loginPage;

}
