# promise4j
Simple java promise mechanism implementation.

# How to use

### Checked promise (allows throwing Throwables)

```
Promise.me(()->longRunningOperationThrowingThrowable())
                .then(r -> handleResult(r), t -> handleThrowable(t));
```
Handling throwable is optional.
```
Promise.me(()->longRunningOperationThrowingThrowable())
                .then(r -> handleResult(r));
```

### Unchecked promise (generic reject type)

```
Promise.<ResultType, ErrorType>me(c -> {
            IntermediateResult intermediateResult = longRunningOperation();
            if (intermediateResult.getStatus()) {
                c.resolve(ResultType.of(intermediateResult));
            } else {
                c.reject(ErrorType.of(intermediateResult));
            }
        }).then(r -> handleResult(r), e -> handleError(e));
```
Again, handling error is optional.
```
Promise.<ResultType, ErrorType>me(c -> {
            IntermediateResult intermediateResult = longRunningOperation();
            if (intermediateResult.getStatus()) {
                c.resolve(ResultType.of(intermediateResult));
            } else {
                c.reject(ErrorType.of(intermediateResult));
            }
        }).then(r -> handleResult(r));
```

# Configuration

Promise4j uses ExecutorService to run promises asynchronously. You can pass in your own ExecutorService to be used when handling promises:
```
Promise.initialize(executorService);
```
By default, `Executors.newCachedThreadPool()` is used.

In order to close application using Promise4j gracefully, you can use `Promise.shutdown()` to shutdown its ExecutorService.

# License
```
Copyright (c) 2017 Maciej Grzeszczak

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
