package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

public interface Err<E> {

    void err(Consumer<E> e);

}
