package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

public interface SafeThen<T> {

    Err<Exception> then(Consumer<T> onSuccess);

}
