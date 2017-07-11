package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

public interface Then<T, E> {

    Err<E> then(Consumer<T> onSuccess);

    void thenDo(Consumer<T> onSuccess);

}
