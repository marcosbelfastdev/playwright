package steps.screenContainerModel.base;

import base.pages.Pages;
import com.microsoft.playwright.*;

import java.lang.reflect.InvocationTargetException;

public class BaseWebSteps {

    private Playwright playwright;
    public Pages pages;
    public Page page;

    public BaseWebSteps(Pages pages) {
            this.pages = pages == null ? new Pages() : pages;
    }

    public Playwright playwright() {
        return playwright;
    }

    public void setPlaywright(Playwright playwright) {
        this.playwright = playwright;
    }

}

