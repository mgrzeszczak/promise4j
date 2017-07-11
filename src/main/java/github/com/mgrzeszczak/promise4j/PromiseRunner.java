package github.com.mgrzeszczak.promise4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class PromiseRunner {

    private static ExecutorService executor;

    synchronized static <R, E> void fulfill(BasePromise<R, E> promise) {
        if (executor == null) {
            executor = Executors.newCachedThreadPool();
        }
        executor.execute(promise::fulfill);
    }

    static void shutdown() {
        executor.shutdown();
    }

    static void initialize(ExecutorService executorService) {
        executor = executorService;
    }

}
