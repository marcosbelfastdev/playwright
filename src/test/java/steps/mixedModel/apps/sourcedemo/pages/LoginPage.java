package steps.mixedModel.apps.sourcedemo.pages;

import base.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;
import java.util.function.Supplier;

public class LoginPage extends BasePage {

    public LoginPage(Supplier<Page> supplierPage) {
        super(supplierPage);
        init();
    }

    protected void init() {
        register(Map.of(
                "login", userNameTextbox,
                "password", passwordTextbox,
                "login button", loginButton
                )
        );
    }

    public Supplier<Locator> userNameTextbox = () -> supplierPage.get().getByPlaceholder("Username");
    public Supplier<Locator> passwordTextbox = () -> supplierPage.get().getByPlaceholder("Password");
    public Supplier<Locator> loginButton = () -> supplierPage.get().locator("#login-button");

    public LoginPage login(String user, String password) {
        get("login").fill(user);
        get("password").fill(password);
        //get("login button").click();
        return this;
    }

}
