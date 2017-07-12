package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

abstract class BasePromise<R, E> {

    private Consumer<R> onSuccess;
    private Consumer<E> onError;

    void fulfill() {
        PromiseContext<R, E> context = ContextFactory.getContext();
        apply(context);
        if (context.result != null) {
            onSuccess.accept(context.result);
        } else if (onError != null) {
            onError.accept(context.error);
        }
    }

    protected abstract void apply(PromiseContext<R, E> context);

    void setOnSuccess(Consumer<R> onSuccess) {
        Conditions.checkArgument(onSuccess != null, "onSuccess cannot be null");
        this.onSuccess = onSuccess;
    }

    void setOnError(Consumer<E> onError) {
        Conditions.checkArgument(onError != null, "onError cannot be null");
        this.onError = onError;
    }
}
