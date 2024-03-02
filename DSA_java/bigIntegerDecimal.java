import java.math.BigInteger;
import java.math.BigDecimal;

public class bigIntegerDecimal { // java.lang.Object -> java.lang.Number -> java.math.BigDecimal / java.math.BigInteger
    public static void subDouble(Double d1, Double d2) {
        System.out.println("Subtraction of Double value '" + d1 + "' and '" + d2 + "' is : " + (d1 - d2));
    }

    public static void subBigDecimal(BigDecimal d1, BigDecimal d2) {
        System.out.println("Subtraction of Double value '" + d1 + "' and '" + d2 + "' is : " + (d1.subtract(d2)));
    }

    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
        System.out.println("\n========== BigDecimal =========");
        BigDecimal d1 = BigDecimal.valueOf(0.04);
        BigDecimal d2 = BigDecimal.valueOf(0.03);

        subDouble(0.03, 0.04); // wrong value come 0.010000000000000002
        subBigDecimal(d1, d2); // correct ans 0.01

        BigDecimal d3 = new BigDecimal("456576345675.4546376");
        BigDecimal d4 = new BigDecimal("547634565352.986785764");
        System.out.println(d3.add(d4));
        System.out.println(d3.subtract(d4));
        System.out.println(d3.multiply(d4));
        System.out.println(d3.pow(2));
        System.out.println(d3.negate());

        // https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html
        // range = -2^Integer.MAX_VALUE (exclusive) to +2^Integer.MAX_VALUE (exclusive). and Integer.MAX_VALUE = 2^31 – 1 = 2,147,483,647
        // System.out.println("\n========== BigInteger =========");
        BigInteger a = BigInteger.valueOf(485555485); // method
        BigInteger b = new BigInteger("1163469487465341634234"); // constructor
        // BigInteger b1 = new BigInteger("163446163764361346343");
        // BigInteger b2 = BigInteger.TEN; // constant
        // System.out.println("constant " + b2);
        //
        // int c = a.intValue(); // converted to integer
        // BigInteger sum = b.add(b1); // addition
        // BigInteger sub = b.subtract(b1); // subtraction
        // BigInteger mul = b.multiply(b1); // multiplication
        // BigInteger div = b.divide(b1); // division
        // BigInteger rem = b.remainder(b1); // remainder
        //
        // System.out.println("sum : " + sum);
        // System.out.println("sub : " + sub);
        // System.out.println("mul : " + mul);
        // System.out.println("div : " + div);
        // System.out.println("rem : " + rem);
        //
        // compare(b, b1); // comparing two BigInteger
        // System.out.println("factorial : " + fact(90));
    }

    static void compare(BigInteger b1, BigInteger b2) {
        if (b1.compareTo(b2) == 0) {
            System.out.println("compared : " + b1 + " is equal to " + b2);
        } else if (b1.compareTo(b2) > 0) {
            System.out.println("compared : " + b1 + " is greater then " + b2);
        } else {
            System.out.println("compared : " + b1 + " is less than " + b2);
        }
    }

    static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
}
