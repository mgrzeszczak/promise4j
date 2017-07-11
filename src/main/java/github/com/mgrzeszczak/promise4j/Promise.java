package github.com.mgrzeszczak.promise4j;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public interface Promise {

    static <X, Y> Then<X, Y> me(Consumer<Context<X, Y>> action) {
        return new BasicPromise<>(action);
    }

    static <X> SafeThen<X> me(SafeConsumer<SafeContext<X>> action) {
        return new SafePromise<>(action);
    }

    static void shutdown() {
        PromiseRunner.shutdown();
    }

    static void initialize(ExecutorService executorService) {
        PromiseRunner.initialize(executorService);
    }

}
