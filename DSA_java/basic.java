import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class basic {
    public static void Sort(String[] arr) { // not completed
        Arrays.sort(arr, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));
    }

    public static void main(String[] args) {
        // question4 (empId,age,gender,salary)
        // 1.sort a/q to age 2.count no of male and female 3.avgSalary a/c to gender

        // question3
        // int[] list = {11,18,20,24,85,66,13};
        // System.out.println(startWith1(list));

        // // question2
        // String[] arr = { "3", "30", "34", "9", "5" };
        // basic.Sort(arr);
        // System.out.println(largestValueFromList(arr, 0, ""));

        // question1
        // Integer n1=100;
        // Integer n2=100;
        // Integer n3=500;
        // Integer n4=500;
        // System.out.println(n1==n2); // true
        // System.out.println(n3==n4); // false
        // System.out.println(n1.equals(n2)); //true.
        // System.out.println(n3.equals(n4)); //true

        // // questions(ninja)
        // Scanner sc = new Scanner(System.in);
        // checkCharAa01('a');
        // switchDemo(2,new double[]{2,3});
        // sumEvenOdd(123546);
        // fibonacci(6);
        // sumOfAllDivisors(10, 0);
        // palindrome(123421);
        // calcGCD(18, 9); // not done
        // armstrong(1634);
        // isPrime(5);
        // printNos(5);
        // reverseArray(6,new int[]{5,8,9,3,4,1});
        // isPalindrome("12321");
        // generateFibonacciNumbers(5); // doubt
        // maximumOddBinaryNumber("1010");
        // System.out.println(reverseBits(12));
        // countFrequency(8,new int[]{11,4, 8, 9, 19, 5, 7, 7 });
        // getFrequencies(new int[] { 11, 13, 3, 14, 17, 3, 7, 9, 1, 11, 9, 15, 5, 2, 2,
        // 3 });
        maxFrequency(new int[] { 1, 2, 4 }, 5);
        // maxFrequency(new int[]{1,4,8,13}, 5);
        // maxFrequency(new int[]{3,9,6}, 2);
    }

    public static void maxFrequency(int[] nums, int k) {

    }

    public static void getFrequencies(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int newFreq = map.getOrDefault(i, 0) + 1;
            map.put(i, newFreq);
        }
        int[] ans = new int[2];
        int gf = 0, gv = 0;
        int sf = Integer.MAX_VALUE, sv = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            int fre = map.get(i);
            if (fre > gf || (fre == gf && i < gv)) {
                gf = fre;
                gv = i;
            }
            if (fre < sf || (fre == sf && i < sv)) {
                sf = fre;
                sv = i;
            }
        }
        ans[0] = gv;
        ans[1] = sv;
        System.out.println(Arrays.toString(ans));
    }

    public static void countFrequency(int countTill, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int[] ans = new int[countTill];
        for (int i = 1; i <= countTill; i++) {
            ans[i - 1] = map.getOrDefault(i, 0);
        }
        System.out.println(Arrays.toString(ans));
    }

    public static long reverseBits(long n) {
        StringBuilder bin = new StringBuilder();
        while (n > 0) {
            bin.append(n % 2);
            n = n / 2;
        }
        while (bin.length() < 32) {
            bin = new StringBuilder(bin + "0");
        }
        System.out.println(bin + " " + bin.length());
        long dec = 0;
        for (int i = 0; i < bin.length(); i++) {
            dec = (long) (dec + Math.pow(2, bin.length() - 1 - i));
        }
        return dec;
    }

    public static void maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }
        if (count1 == 0) {
            System.out.println(" ");
            return;
        }
        sb.append("1".repeat(Math.max(0, count1 - 1)));
        sb.append("0".repeat(Math.max(0, s.length() - count1)));
        sb.append(1);
        System.out.println(sb);
    }

    public static void generateFibonacciNumbers(int n) { // doubt
        int[] arr = new int[n];
        arr[0] = 0;
        if (n == 1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[1] = 1;
        System.out.println(Arrays.toString(printFibonacci(n, arr, 2)));
    }

    private static int[] printFibonacci(int n, int[] arr, int i) {
        if (i >= n) {
            return arr;
        }
        arr[i] = arr[i - 1] + arr[i - 2];
        return printFibonacci(n, arr, i + 1);
    }

    public static void isPalindrome(String str) {
        boolean ans = true;
        System.out.println(isPalindrome(0, str, str.length() - 1, ans));
    }

    private static boolean isPalindrome(int start, String str, int end, boolean ans) {
        if (start >= end) {
            return ans;
        }
        if (str.charAt(start) != str.charAt(end)) {
            ans = false;
        }
        return isPalindrome(start + 1, str, end - 1, ans);
    }

    public static void reverseArray(int length, int[] nums) {
        System.out.println(Arrays.toString(reverseArray(length - 1, nums, 0)));
    }

    private static int[] reverseArray(int n, int[] nums, int m) {
        if (m >= n) {
            return nums;
        }
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
        return reverseArray(n - 1, nums, m + 1);
    }

    public static void printNos(int x) {
        System.out.println(Arrays.toString(printNos(x, new int[x])));
    }

    private static int[] printNos(int x, int[] ans) {
        if (x == 0) {
            return ans;
        }
        ans[x - 1] = x;
        return printNos(x - 1, ans);
    }

    public static void isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        System.out.print(prime);
    }

    public static void armstrong(int n) {
        String s = String.valueOf(n);
        int power = s.length();
        int temp = n;
        int sum = 0;
        while (n > 0) {
            sum += (int) Math.pow(n % 10, power);
            n = n / 10;
        }
        System.out.println(sum == temp);
    }

    public static void calcGCD(int n, int m) { // not done
        int gcd = 0;
        if (m % n == 0) {
            System.out.println(n);
            return;
        }
        if (n % m == 0) {
            System.out.println(m);
            return;
        }
        if (n <= m) {
            for (int i = n / 2; i > 0; i--) {
                if (n % i == 0 && m % i == 0 && gcd < i) {
                    gcd = i;
                }
            }
        } else {
            for (int i = m / 2; i > 0; i--) {
                if (n % i == 0 && m % i == 0 && gcd < i) {
                    gcd = i;
                }
            }
        }
        System.out.println(gcd);
    }

    public static void palindrome(int n) {
        int temp = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        System.out.println(rev == temp);
    }

    public static void sumOfAllDivisors(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum += n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        sumOfAllDivisors(n - 1, sum);
    }

    public static void fibonacci(int n) {
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            int first = 0;
            int second = 1;
            int nth = 1;
            for (int i = 2; i <= n; i++) {
                nth = first + second;
                first = second;
                second = nth;
            }
            System.out.println(nth);
        }
    }

    public static void sumEvenOdd(int n) {
        int even = 0;
        int odd = 0;
        while (n > 10) {
            int rem = n % 10;
            if (n % 2 == 0) {
                even += rem;
            } else {
                odd += rem;
            }
            n = n / 10;
        }
        int rem = n % 10;
        if (n % 2 == 0) {
            even += rem;
        } else {
            odd += rem;
        }
        System.out.println(even + " " + odd);
    }

    public static void switchDemo(int ch, double[] rlb) {
        switch (ch) {
            case 1:
                System.out.println(Math.PI * rlb[0] * rlb[0]);
                break;
            case 2:
                System.out.println(rlb[0] * rlb[1]);
                break;
        }
    }

    public static void checkCharAa01(int ch) {
        if (ch >= 97 && ch <= 122) {
            System.out.println(0);
        } else if (ch >= 65 && ch <= 90) {
            System.out.println(1);
        } else {
            System.out.println(ch);
        }
    }

    static ArrayList<Integer> startWith1(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : arr) {
            String element = String.valueOf(i); // convert int -> String
            if (element.charAt(0) == '1') {
                ans.add(i);
            }
        }
        return ans;
    }

    public static String largestValueFromList(String[] arr, int index, String ans) {
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
}

class a1 {
    public void sum(int n1, int n2) {
        System.out.println("sum: " + (n1 + n2));
    }

    public void sub(int n1, int n2) {
        System.out.println("sub: " + (n1 - n2));
    }

    static void variable_argument(int... n) {
        System.out.println("multiple value taken as input by one variable ...n is : "
                + Arrays.toString(n));
    }

    static void mul(int n1, int n2) {
        System.out.println("mul:" + (n1 * n2));
    }

    public static void main(String[] args) {
        a1 s = new a1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int n2 = sc.nextInt();
        s.sum(n1, n2);
        s.sub(n1, n2);
        variable_argument(1, 3, 5, 7, 9, 2, 3, 4, 10);
        mul(n1, n2);
        sc.close();
    }
}

class a2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int n2 = sc.nextInt();
        System.out.println("Choose any one and Enter it:\n sum\n sub\n mul\n div\n mod.");
        String input = sc.next();
        switch (input) {
            case "sum":
                System.out.println("sum=" + (n1 + n2));
                break;
            case "sub":
                System.out.println("sub=" + (n1 - n2));
                break;
            case "mul":
                System.out.println("mul=" + (n1 * n2));
                break;
            case "div":
                System.out.println("div=" + (n1 / n2));
                break;
            case "mod":
                System.out.println("mod=" + (n1 % n2));
                break;
        }
        sc.close();
    }
}