import java.util.ArrayList;

public class lambda_fun {
    public static void main(String[] args) throws customException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.forEach((i) -> System.out.println(i)); // this or
        list.forEach(System.out::println); // this ( lambda function )

        operation sum = (a, b) -> a + b; // lambda fun creation
        operation mul = (a, b) -> a - b;
        operation sub = (a, b) -> a * b;
        operation div = (a, b) -> a / b;
        operation mod = (a, b) -> a % b;

        lambda_fun calculator = new lambda_fun();
        System.out.println(calculator.operate(4, 5, sum));
        System.out.println(calculator.operate(4, 5, mul));
        System.out.println(calculator.operate(4, 5, sub));
        System.out.println(calculator.operate(4, 5, mod));

        // exception handling
        try { // try block of exception handling is run when exception not occur
            System.out.println(div(3, 0));
        } catch (customException e) { // catch block when exception occur
            System.out.println(e);
        } finally { // always run
            System.out.println("exception handeled");
        }
    }

    private static int div(int a, int b) throws customException { // exception handling by throws keyword of
                                                                  // customTypeException
        if (b == 0) {
            throw new customException("dont divide by zero.");
        } else {
            return a / b;
        }
    }

    private int operate(int a, int b, operation O) {
        return O.sum(a, b);
    }
}

interface operation {
    int sum(int a, int b);
}

class customException extends Exception {
    public customException(String message) {
        super(message);
    }
}