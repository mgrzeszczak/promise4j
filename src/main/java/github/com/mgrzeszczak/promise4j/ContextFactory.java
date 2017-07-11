package github.com.mgrzeszczak.promise4j;

final class ContextFactory {

    static <R,E> PromiseContext<R,E> getContext() {
        return new PromiseContext<>();
    }

}
