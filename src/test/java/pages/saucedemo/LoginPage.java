package pages.saucedemo;

import base.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
        init();
    }

    public void init() {
        locatorMap = Map.of(
                "login", userNameTextbox,
                "password", passwordTextbox
        );
    }

    public final Locator locator(String name) {
        return locatorMap.get(name).get();
    }

    public final Supplier<Locator> userNameTextbox = () -> this.page.getByPlaceholder("Username");


    public final Supplier<Locator> passwordTextbox = () -> this.page.getByRole(
            AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password")
    );


}
