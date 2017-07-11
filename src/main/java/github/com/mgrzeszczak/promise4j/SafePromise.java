package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

final class SafePromise<R> extends BasePromise<R, Exception> implements SafeThen<R>, Err<Exception> {

    private final SafeConsumer<SafeContext<R>> action;

    SafePromise(SafeConsumer<SafeContext<R>> action) {
        Conditions.checkArgument(action != null, "action cannot be null");
        this.action = action;
    }

    @Override
    public Err<Exception> then(Consumer<R> onSuccess) {
        setOnSuccess(onSuccess);
        return this;
    }

    @Override
    public void err(Consumer<Exception> onError) {
        setOnError(onError);
        PromiseRunner.fulfill(this);
    }

    @Override
    protected void apply(PromiseContext<R, Exception> context) {
        try {
            action.accept(context);
        } catch (Exception e) {
            context.reject(e);
        }
    }
}
