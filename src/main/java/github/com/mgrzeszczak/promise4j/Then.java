package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

public interface Then<T, E> {

    void then(Consumer<T> onSuccess);

    void then(Consumer<T> onSuccess, Consumer<E> onError);

}
