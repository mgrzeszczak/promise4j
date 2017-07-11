package github.com.mgrzeszczak.promise4j;

public interface Context<R, E> {

    void resolve(R result);

    void reject(E error);

}
