package web.base;

import web.base.pages.Pages;
import io.cucumber.core.backend.ObjectFactory;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class PicoContainerObjectFactory implements ObjectFactory {
    private final MutablePicoContainer container = new DefaultPicoContainer();

    @Override
    public void start() {
        // Initialize the PicoContainer and add any necessary dependencies
        // For example, you can add your step definition classes as components to the container.
        container.addComponent(Pages.class);
        //container.addComponent(SourceDemoPageModels.class);// Replace StepDefinitions with your actual step definitions class.
    }

    @Override
    public void stop() {
        // Perform any necessary cleanup after all scenarios are executed.
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        // Return true if the class is added to the container successfully; otherwise, return false.
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        // Return an instance of the requested class from the container.
        return container.getComponent(aClass);
    }
}
