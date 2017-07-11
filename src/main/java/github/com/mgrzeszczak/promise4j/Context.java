package github.com.mgrzeszczak.promise4j;

public interface Context<R, E> extends SafeContext<R> {

    void reject(E error);

}
