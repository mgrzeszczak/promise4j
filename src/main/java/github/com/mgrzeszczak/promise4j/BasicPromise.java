package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

final class BasicPromise<R, E> extends BasePromise<R, E> implements Then<R, E>, Err<E> {

    private final Consumer<Context<R,E>> action;

    BasicPromise(Consumer<Context<R, E>> action) {
        Conditions.checkArgument(action != null, "action cannot be null");
        this.action = action;
    }

    @Override
    public Err<E> then(Consumer<R> onSuccess) {
        setOnSuccess(onSuccess);
        return this;
    }

    @Override
    public void thenDo(Consumer<R> onSuccess) {
        setOnSuccess(onSuccess);
        PromiseRunner.fulfill(this);
    }

    @Override
    public void err(Consumer<E> onError) {
        setOnError(onError);
        PromiseRunner.fulfill(this);
    }

    @Override
    protected void apply(PromiseContext<R, E> context) {
        action.accept(context);
    }
}
