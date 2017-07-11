package github.com.mgrzeszczak.promise4j;

import java.util.function.Consumer;

/*
var promise = new Promise(function(resolve, reject) {

      // do a thing, possibly async, then…
      if (fine) {
            resolve("Stuff worked!");
      }
      else {
            reject(Error("It broke"));
      }
  });

promise.then(function(result) {
  console.log(result); // "Stuff worked!"
}, function(err) {
  console.log(err); // Error: "It broke"
});

*/
public interface Promise {

    static <X, Y> Then<X, Y> me(Consumer<Context<X, Y>> action) {
        return new PromiseImpl<>(action);
    }

}
