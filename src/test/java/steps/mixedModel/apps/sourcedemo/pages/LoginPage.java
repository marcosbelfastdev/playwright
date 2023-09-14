package steps.mixedModel.apps.sourcedemo.pages;

import web.base.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;
import java.util.function.Supplier;

public class LoginPage extends BasePage {

    public LoginPage(Supplier<Page> pageSupplier) {
        super(pageSupplier);
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

    public Supplier<Locator> userNameTextbox = () -> pageSupplier.get().getByPlaceholder("Username");
    public Supplier<Locator> passwordTextbox = () -> pageSupplier.get().getByPlaceholder("Password");
    public Supplier<Locator> loginButton = () -> pageSupplier.get().locator("#login-button");

    public LoginPage login(String user, String password) {
        get("login").fill(user);
        get("password").fill(password);
        //get("login button").click();
        return this;
    }

}
