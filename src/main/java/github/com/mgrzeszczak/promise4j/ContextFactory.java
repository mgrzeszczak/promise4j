package github.com.mgrzeszczak.promise4j;

class ContextFactory {

    static <R,E> PromiseContext<R,E> getContext() {
        return new PromiseContext<>();
    }

}
