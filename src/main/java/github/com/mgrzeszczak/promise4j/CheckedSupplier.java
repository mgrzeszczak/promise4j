package github.com.mgrzeszczak.promise4j;

@FunctionalInterface
public interface CheckedSupplier<R> {

    R get() throws Throwable;

}
