package github.com.mgrzeszczak.promise4j;

public interface Context<R, E> extends CheckedContext<R> {

    void reject(E error);

}
