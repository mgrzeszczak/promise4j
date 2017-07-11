package github.com.mgrzeszczak.promise4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class PromiseRunner {

    private final static ExecutorService executorService = Executors.newCachedThreadPool();

    synchronized static <R,E> void  fulfill(PromiseImpl<R,E> promise) {
        executorService.execute(promise::fulfill);
    }

}
