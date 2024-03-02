import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class string {
    public static void main(String[] args) {

       Comparisons();
       string_formatting();
       string_concatenate();
       performance_of_StringBuffer_Over_String();
       string_methods();
       System.out.println(isPalindrome("aba"));
       stringBuffer_class();
       random_string_generation();
    }

    static void Comparisons() {
        String a = "pk";
        String b = "pk";
        String c = new String("pk");
        String d = new String("pk");

        System.out.println("\na : " + a + ", b : " + b + ", c : " + c + ", d : " +
                d);
        System.out.print("\nvariable to variable ( a == b ) --> ");
        System.out.println(a == b); // True
        System.out.print("variable to variable ( a.equals(b) ) --> ");
        System.out.println(a.equals(b)); // True
        System.out.print("\nobject to object ( c == d ) --> ");
        System.out.println(c == d); // False
        System.out.print("object to object ( c.equals(d) ) --> ");
        System.out.println(c.equals(d)); // True

        a = "dk";
        System.out.println("\na : " + a + ", b : " + b);
        System.out.print("a == b --> ");
        System.out.println(a == b); // False
        System.out.print("a[1] == b[1] --> ");
        System.out.println(a.charAt(1) == b.charAt(1)); // True
    }

    static void string_formatting() // https://stackabuse.com/how-to-format-a-string-in-java-with-examples/
     {
     float a = 123.4567f;
     System.out.println("\n=> string formatting by using %.nf (n=int value) and use printf for print");
     System.out.printf("Formatted floating_no is : %.2f", a);
     System.out.printf("\nValue of Pie : %.3f", Math.PI);

     // %c - Character
     // %d - Decimal number (base 10)
     // %e - Exponential floating-point number
     // %f - Floating-point number
     // %i - Integer (base 10)
     // %o - Octal number (base 8)
     // %s - String
     // %u - Unsigned decimal (integer) number
     // %x - Hexadecimal number (base 16)
     // %t - Date/time
     // %n - Newline
     System.out.printf("\nMy name is %s and i am from %s.", "Pradhuman Kumar", "Giridih");

     System.out.println("\n\n=> decimal formatting by java.text.DecimalFormat class");
     DecimalFormat df = new DecimalFormat("00.0000");
     System.out.println(df.format(7.25));
     }

    static void string_concatenate() {
     System.out.println('a' + 'b'); // 195
     System.out.println("a" + "b"); // ab
     System.out.println('a' + "b"); // ab
     System.out.println('a' + 3); // 100
     System.out.println("a" + 3); // a3
     System.out.println((char) ('a' + 3)); // d -> char value of 97 + 3.
     System.out.println("pradhuman" + new ArrayList<>()); // pradhuman[]

//     // Warning/error, because Integer wrapper class is removed in latest version
//     System.out.println(new Integer(56) + " " + new ArrayList<>()); // 56 []
//     System.out.println("pradhuman" + new Integer(56)); // pradhuman56 and
//
//     System.out.println(new Integer(56) + new ArrayList<>(null)); // error, because
//     // at least one string is required for concatenate
     }

    static void performance_of_StringBuffer_Over_String() {
        // having O(N^2) complexity because string is immutable and hence all time a
        // new object(a,ab,abc, .....) is created with old object and old object is
        // pointless.
        String s = "";
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            s = s + c + " ";
        }
        System.out.println("String : " + s);

        // having O(N) complexity because string is immutable but StringBuilder is
        // mutable and hence char is added in old object.
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            sb.append(c);
            sb.append(" ");
        }
        System.out.println("StringBuffer : " + sb);
    }

    static void string_methods() {
        String s = "Pradhuman Kumar Verma";
        System.out.println("original (object not changed) : " + s);
        System.out.println("Length : " + s.length());
        System.out.println(Arrays.toString(s.toCharArray()));
        System.out.println("lowerCaseForm (new object created) : " +
                s.toLowerCase());
        System.out.println("index of V is : " + s.indexOf("V"));
        System.out.println(Arrays.toString(s.split(" ")));
        String[] ss = s.split(" ");
        System.out.println(Arrays.toString(ss));
        System.out.println("Space replaced : " + s.replaceAll("\\s", ""));
        System.out.println(" multiSpace Is Removed By Using Strip Function".strip());

        String sss = " multiSpace Is Removed By Using strip ->regular expression term \\s ";
        System.out.println(Arrays.toString((sss.strip()).split("\\s+")));
    }

    static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static void stringBuffer_class() {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("Deepak kumar");
        StringBuffer sb3 = new StringBuffer(30);

        System.out.println(sb1.capacity());
        sb1.append("Pradhuman");
        sb1.append(" Kumar");
        sb1.insert(0, "mr. ");
        sb1.replace(13, 19, " pk");
        sb1.delete(0, 4);
        sb1.reverse();
        System.out.println(sb1);

        System.out.println(sb2);
        System.out.println(sb3);
    }

    static void random_string_generation() {
        int size = 20;
        String gen1 = RandomStringGenerator(size);
        String gen2 = RandomStringGenerator(size);
        System.out.printf("Random String of length %d generated : '%s' and '%s'", size, gen1, gen2);
    }

    static String RandomStringGenerator(int size) {
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int rChar = 97 + (int) (r.nextFloat() * 26);
            sb.append((char) rChar);
        }
        return sb.toString();
    }
}