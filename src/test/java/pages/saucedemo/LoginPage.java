package pages.saucedemo;

import base.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;
import java.util.function.Supplier;

public class LoginPage extends BasePage {

    public LoginPage(Supplier<Page> page) {
        super(page);
        init();
    }

    public void init() {
        locatorMap = Map.of(
                "login", userNameTextbox,
                "password", passwordTextbox,
                "submit button", loginButton
        );
    }

    public void login(String user, String password) {
        get("login").fill(user);
        get("password").fill(password);
        get("submit button").click();
    }

    protected final Locator get(String name) {
        return locatorMap.get(name).get();
    }

    public final Supplier<Locator> userNameTextbox = () -> page().getByPlaceholder("Username");
    public final Supplier<Locator> passwordTextbox = () -> page().getByPlaceholder("Password");
    public final Supplier<Locator> loginButton = () -> page().locator("#login-button");
}
