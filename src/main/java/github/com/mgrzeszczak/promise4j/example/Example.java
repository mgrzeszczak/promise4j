package github.com.mgrzeszczak.promise4j.example;

import github.com.mgrzeszczak.promise4j.Promise;

public class Example {

    public static void main(String[] args) {
        Promise.<String,Exception>me(c->{
            try {
                Thread.sleep(1000);
                c.resolve("great");
            } catch (InterruptedException e) {
                c.reject(e);
            }
        }).then(System.out::println)
        .err(System.out::println);
    }

}
