package github.com.mgrzeszczak.promise4j;

final class PromiseContext<R, E> implements Context<R, E> {

    R result;
    E error;

    @Override
    public void resolve(R result) {
        checkState();
        this.result = result;
    }

    @Override
    public void reject(E error) {
        checkState();
        this.error = error;
    }

    private void checkState() {
        if (this.result != null) {
            throw new IllegalStateException("already resolved");
        }
        if (this.error != null) {
            throw new IllegalStateException("already rejected");
        }
    }
}
