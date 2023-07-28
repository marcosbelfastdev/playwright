package runners;

import base.function.FunctionClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class TestFunction {

    @Test
    public void test() {

        FunctionClass fObject = new FunctionClass();

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        helperMethod(fObject.datetime);

    }

    public void helperMethod(Supplier<String> supplier) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(supplier.get());
    }
}
