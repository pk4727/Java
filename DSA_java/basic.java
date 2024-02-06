import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        // question4 (empid,age,gender,salary)
        // 1.sort a/q to age 2.count no of male and female 3.avgsalary a/c to gender

       // question3
       int[] list = {11,18,20,24,85,66,13};
       System.out.println(startWith1(list));

//        // question2
//        String[] arr = { "3", "30", "34", "9", "5" };
//        basic.Sort(arr);
//        System.out.println(largestValueFromList(arr, 0, ""));

        // question1
        // Integer n1=100;
        // Integer n2=100;
        // Integer n3=500;
        // Integer n4=500;
        // System.out.println(n1==n2); // true
        // System.out.println(n3==n4); // false
        // System.out.println(n1.equals(n2)); //true.
        // System.out.println(n3.equals(n4)); //true
    }
    static ArrayList<Integer> startWith1(int[] arr){
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int i: arr){
            String element = String.valueOf(i); // convert int -> String
            if(element.charAt(0)=='1'){
                ans.add(i);
            }
        }
        return ans;
    }

    private static String largestValueFromList(String[] arr, int index, String ans) {
        if (index >= arr.length) {
            return ans;
        }

        int n1 = Integer.parseInt(arr[index] + ans); // convert String -> int
        int n2 = Integer.parseInt(ans + arr[index]);

        if (n1 >= n2) {
            return largestValueFromList(arr, index + 1, arr[index] + ans);
        } else {
            return largestValueFromList(arr, index + 1, ans + arr[index]);
        }
    }

    private static void Sort(String[] arr) {
        Arrays.sort(arr, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));
    }
}

// class a1 {
// public void sum(int n1, int n2) {
// System.out.println("sum: " + (n1 + n2));
// }
// public void sub(int n1, int n2) {
// System.out.println("sub: " + (n1 - n2));
// }
// static void variable_argument(int... n) {
// System.out.println("multiple value taken as input by one variable ...n is : "
// + Arrays.toString(n));
// }
// static void mult(int n1, int n2) {
// System.out.println("mul:" + (n1 * n2));
// }
// public static void main(String[] args) {
// a1 s = new a1();
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter 1st number: ");
// int n1 = sc.nextInt();
// System.out.println("Enter 2nd number: ");
// int n2 = sc.nextInt();
// s.sum(n1, n2);
// s.sub(n1, n2);
// variable_argument(1, 3, 5, 7, 9, 2, 3, 4, 10);
// mult(n1, n2);
// sc.close();
// }
// }

// class a2 {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter 1st number: ");
// int n1 = sc.nextInt();
// System.out.println("Enter 2nd number: ");
// int n2 = sc.nextInt();
// System.out.println("Choose any one and Enter it:\n sum\n sub\n mul\n div\n
// mod.");
// String input = sc.next();
// switch (input) {
// case "sum":
// System.out.println("sum=" + (n1 + n2));
// break;
// case "sub":
// System.out.println("sub=" + (n1 - n2));
// break;
// case "mul":
// System.out.println("mul=" + (n1 * n2));
// break;
// case "div":
// System.out.println("div=" + (n1 / n2));
// break;
// case "mod":
// System.out.println("mod=" + (n1 % n2));
// break;
// }
// sc.close();
// }
// }