package base.function;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class FunctionClass {
    public Supplier<String> datetime = () -> LocalDateTime.now().toString();
}
