package github.com.mgrzeszczak.promise4j;

public interface SafeContext<T> {

    void resolve(T result);

}
