package github.com.mgrzeszczak.promise4j;

@FunctionalInterface
public interface SafeConsumer<T> {

    void accept(T t) throws Throwable;

}
