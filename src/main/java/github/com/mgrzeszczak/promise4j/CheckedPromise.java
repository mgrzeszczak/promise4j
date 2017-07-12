package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

final class CheckedPromise<R> extends BasePromise<R, Throwable> implements CheckedThen<R> {

    private final CheckedSupplier<R> action;

    CheckedPromise(CheckedSupplier<R> action) {
        Conditions.checkArgument(action != null, "action cannot be null");
        this.action = action;
    }

    @Override
    public void then(Consumer<R> onSuccess) {
        setOnSuccess(onSuccess);
        PromiseRunner.fulfill(this);
    }

    @Override
    public void then(Consumer<R> onSuccess, Consumer<Throwable> onError) {
        setOnError(onError);
        setOnSuccess(onSuccess);
        PromiseRunner.fulfill(this);
    }

    @Override
    protected void apply(PromiseContext<R, Throwable> context) {
        try {
            context.resolve(action.get());
        } catch (Throwable t) {
            context.reject(t);
        }
    }
}
