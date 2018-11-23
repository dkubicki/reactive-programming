package creation;

import io.reactivex.Observable;
import utils.DataGenerator;

public class SimpleCreationExamples {

    public static void main(String[] args) {
        Observable<Integer> observable = null;

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from a single value");
        System.out.println("---------------------------------------------");
        observable = Observable.just(42);
        observable.subscribe(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from an Iterable");
        System.out.println("---------------------------------------------");
        observable = Observable.fromIterable(DataGenerator.generateFibonacciList());
        observable.subscribe(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from an Array");
        System.out.println("---------------------------------------------");
        observable = Observable.fromArray(DataGenerator.generateFibonacciArray());
        observable.subscribe(System.out::println);

        System.exit(0);
    }
}
