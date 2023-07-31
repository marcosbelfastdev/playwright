package pages.saucedemo;

import base.pages.BasePage;
import base.pages.Element;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;
import java.util.function.Supplier;

import static java.util.Objects.isNull;

public class LoginPage extends BasePage {

    public LoginPage(Supplier<Page> page) {
        super(page);
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

    public Supplier<Locator> userNameTextbox = () -> page().getByPlaceholder("Username");
    public Supplier<Locator> passwordTextbox = () -> page().getByPlaceholder("Password");
    public Supplier<Locator> loginButton = () -> page().locator("#login-button");

    public LoginPage login(String user, String password) {
        get("login").fill(user);
        get("password").fill(password);
        get("login button").click();
        return this;
    }

}
