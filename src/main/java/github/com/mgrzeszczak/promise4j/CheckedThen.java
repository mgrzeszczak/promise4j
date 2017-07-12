package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

public interface CheckedThen<T> {

    void then(Consumer<T> onSuccess);

    void then(Consumer<T> onSuccess, Consumer<Throwable> onError);

}
