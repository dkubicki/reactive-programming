import io.vavr.Function2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FirstClassCitizenVariableIllustration {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------
        // This example illustrates how to create an inline lambda expression
        // and store it in a variable.  It can then be called directly from
        // the variable.
        // ---------------------------------------------------------------------
        BiFunction<String, String, String> concatFunction = (s, t) -> s + t;

        Function<String, Function<String, String>> concatFunction2 = (t) -> (s) -> t + s;

        System.out.println(concatFunction2.apply("Hello Hello ").apply("World"));

        System.out.println(concatFunction.apply("Hello ", "World 1"));

        Function2<String, String, String> concatFunction3 = (a, b) -> a + b;
        System.out.println(concatFunction3.curried().apply("Hello ").apply("World 2"));

        // ---------------------------------------------------------------------
        // This example illustrates how a static method that conforms to the
        // method signature of the BiFunction can be stored in a variable and
        // then invoked.
        // ---------------------------------------------------------------------
        concatFunction = FirstClassCitizenVariableIllustration::concatStrings;
        System.out.println(concatFunction.apply("Hello ", "World 3"));

        // ---------------------------------------------------------------------
        // This example illustrates how an instance method that conforms to the
        // method signature of the BiFunction can be stored in a variable and
        // then invoked.
        // ---------------------------------------------------------------------
        FirstClassCitizenVariableIllustration instance = new FirstClassCitizenVariableIllustration();
        concatFunction = instance::concatStrings2;
        System.out.println(concatFunction.apply("Hello ", "World 4"));
    }

    private static String concatStrings(String a, String b) {
        return a + b;
    }

    /* package */ String concatStrings2(String a, String b) {
        return a + b;
    }
}
