package creation;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import utils.DataGenerator;

import java.util.List;
import java.util.concurrent.FutureTask;


public class FutureCreationExample {

    public static void main(String[] args) {

        Observable<List<Integer>> observableFutureList;

        // Create a FutureTask that returns a List<Integer>
        FutureTask<List<Integer>> future = new FutureTask<>(DataGenerator::generateFibonacciList);
        
        // Construct an observable...note that this only creates the
        // observable wrapper around the future.  The future still needs 
        // to be executed using it's "run" method, or by scheduling it to 
        // execute.
        observableFutureList = Observable.fromFuture(future);

        Schedulers.computation().scheduleDirect(future);

        // Subscribe to the list...when the list is ready through the 
        // future, iterate and print each element.
        observableFutureList.subscribe((list) -> {
            list.forEach(System.out::println);
        });

        System.exit(0);
    }
}
