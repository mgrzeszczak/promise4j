package github.com.mgrzeszczak.promise4j;

final class Conditions {

    static void checkArgument(boolean value, String message) {
        if (!value) {
            throw new IllegalArgumentException(message);
        }
    }

}
