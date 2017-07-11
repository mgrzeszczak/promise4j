package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

final class PromiseImpl<R,E> implements Then<R,E>, Err<E> {

    private final Consumer<Context<R,E>> action;
    private Consumer<R> onSuccess;
    private Consumer<E> onError;

    PromiseImpl(Consumer<Context<R, E>> action) {
        Conditions.checkArgument(action != null, "action cannot be null");
        this.action = action;
    }

    @Override
    public Err<E> then(Consumer<R> onSuccess) {
        Conditions.checkArgument(onSuccess != null, "onSuccess cannot be null");
        this.onSuccess = onSuccess;
        return this;
    }

    @Override
    public void thenDo(Consumer<R> onSuccess) {
        Conditions.checkArgument(onSuccess != null, "onSuccess cannot be null");
        PromiseRunner.fulfill(this);
    }

    @Override
    public void err(Consumer<E> onError) {
        Conditions.checkArgument(onSuccess != null, "onError cannot be null");
        this.onError = onError;
        PromiseRunner.fulfill(this);
    }

    void fulfill() {
        PromiseContext<R, E> context = ContextFactory.getContext();
        action.accept(context);
        if (context.result != null) {
            onSuccess.accept(context.result);
        } else {
            onError.accept(context.error);
        }
    }

}
