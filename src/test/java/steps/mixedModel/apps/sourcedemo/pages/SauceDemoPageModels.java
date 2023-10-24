package steps.mixedModel.apps.sourcedemo.pages;

import com.microsoft.playwright.Page;

import java.util.function.Supplier;

public class SauceDemoPageModels {

    private final Supplier<Page> supplierPage;

    public SauceDemoPageModels(Supplier<Page> pageSupplier) {
        this.supplierPage = pageSupplier;
        initModels();
    }

    private void initModels() {
        loginPage = new LoginPage(supplierPage);
    }

    public LoginPage loginPage;

    public void test() {

    }

}
