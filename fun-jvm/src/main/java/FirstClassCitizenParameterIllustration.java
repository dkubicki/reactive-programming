import java.util.function.Function;

public class FirstClassCitizenParameterIllustration {

    public static void main(String[] args) {

        // The concatAndTransform call illustrates how fuctions can be passed
        // as a parameter.  Functions (lambdas) can be passed directly or...
        System.out.println(concatAndTransform("Hello ", "World", String::toUpperCase));

        // ...from a variable.
        Function<String, String> transformToLower = String::toLowerCase;
        System.out.println(concatAndTransform("Hello ", "World", transformToLower));

    }

    private static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {

        if (stringTransform != null) {
            a = stringTransform.apply(a);
            b = stringTransform.apply(b);
        }

        return a + b;
    }
}
