import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recursion {
    public static void main(String[] args) {
        System.out.println(dies_return("", 5, 6));
        dies_problem("", 5);
        System.out.println(mobile_pad_letterCombinations("23")); // leetcode_17
        
        System.out.println("===================");
        System.out.println(count_permutation("", "abc"));
        System.out.println(permutation2("", "abc"));
        permutation("", "abc");
        
        System.out.println("===================");
        int[] per = { 1, 2, 1 };
        System.out.println(remove_duplicate_from_subset_of_array(per));
        System.out.println(subset_of_array(per));
        Subset_of_string_ascii("", "abc");
        System.out.println(subset_of_String("", "abc"));
        subset_of_string("", "abc");
        System.out.println("---------------------");
        System.out.println(skip_notskip_string_from_string("this_shapp_apple_from_giridih","app", "apple"));
        System.out.println(skip_string_from_string("this_apple_from_giridih.","apple"));
        System.out.println(skip_char_from_string("baccadah", 'a'));
        skip_char_from_string("baccadah", "", 'a');
        
        System.out.println("===================");
        int[] arr = { 68, 64, 67, 6, 4, 644, 8, 64, 94, 84 };
        int[] arr2 = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println(rotated_binary_search(arr2, 2, 0, arr2.length - 1));
        System.out.println(search_all_target_in_arraylist(arr, 64, 0));
        ArrayList<Integer> ans1 = new ArrayList<Integer>();
        search_all_target_in_arraylist(arr, 64, 0, ans1); // or
        System.out.println(ans1);
        ArrayList<Integer> ans2 = search_all_target_in_arraylist(arr, 64, 0, new ArrayList<>()); // or
        System.out.println(ans2);
        System.out.println(search_all_target_in_arraylist(arr, 64, 0, new ArrayList<>()));
        System.out.println("---------------------");
        search_all_target_in_array(arr, 64, 0);
        System.out.println(list);
        System.out.println(search_target_in_array(arr, 8, 0));
        System.out.println(search_target_from_array_in_boolean(arr, 84, 0));
        System.out.println(check_sorted_array(arr, 0));
        
        System.out.println("===================");
        selection_sort(arr, arr.length, 0, 0);
        bubble_sort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
        System.out.println(binary_search(arr, 4, 0, arr.length - 1));
        
        System.out.println("===================");
        triangle(5, 0);
        System.out.println("\n\n");
        rev_triangle(5, 0);
        
        System.out.println("===================");
        System.out.println(subtractProductAndSum(4421)); // leetcode_1281
        System.out.println(countOperations(2, 3)); // leetcode_2169
        System.out.println(step_count(123)); // leetcode_1342
        
        System.out.println("===================");
        System.out.println(count_zeroes0(120400101));
        count_zeroes(10230402);
        System.out.println(count);
        System.out.println(palindrome(124321));
        sum = 0;
        reverse_number(12034);
        System.out.println(sum);
        System.out.println(reverse_number2(12034));
        reverse_number3(12034);
        System.out.println("\n---------------------");
        System.out.println(sum_of_digits(12345));
        System.out.println(sum(5));
        System.out.println(fact(5));
        
        System.out.println("===================");
        print_serial_number(5);
        System.out.println("----");
        print_reverse_serial_number(5);
        System.out.println("----");
        print_number_and_reverse(5);

        
        System.out.println("===================");
        print1(1);
        System.out.println("----");
        Print(1); // same to print(5)
    }

    static ArrayList<String> dies_return(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(dies_return(p + i, target - i, face));
        }
        return ans;
    }

    static void dies_problem(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dies_problem(p + i, target - i);
        }
    }

    static List<String> mobile_pad_letterCombinations(String digits) { // leetcode_17
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return (helper_for_mobile_pad_permutation("", digits));
    }

    static List<String> helper_for_mobile_pad_permutation(String p, String unp) {
        if (unp.isEmpty()) {
            List<String> pp = new ArrayList<>();
            pp.add(p);
            return pp;
        }
        int digit = unp.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        if (digit <= 6) // work for 2 to 6
        {
            for (int i = (digit - 1) * 3; i < digit * 3; i++) {
                char ch = (char) ('a' - 3 + i);
                ans.addAll(helper_for_mobile_pad_permutation(p + ch, unp.substring(1)));
            }
        }
        if (digit == 7) // work for 7
        {
            for (int i = (digit - 1) * 3; i < digit * 3 + 1; i++) {
                char ch = (char) ('a' - 3 + i);
                ans.addAll(helper_for_mobile_pad_permutation(p + ch, unp.substring(1)));
            }
        }
        if (digit == 8) // work for 8
        {
            for (int i = (digit - 1) * 3; i < digit * 3; i++) {
                char ch = (char) ('a' - 3 + i + 1);
                ans.addAll(helper_for_mobile_pad_permutation(p + ch, unp.substring(1)));
            }
        }
        if (digit == 9)// work for 9
        {
            for (int i = (digit - 1) * 3; i < digit * 3 + 1; i++) {
                char ch = (char) ('a' - 3 + i + 1);
                ans.addAll(helper_for_mobile_pad_permutation(p + ch, unp.substring(1)));
            }
        }
        return ans;
    }

    // ============================================================================

    static int count_permutation(String p, String unp) {
        if (unp.isEmpty()) {
            return 1;
        }
        char ch = unp.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + count_permutation(f + ch + s, unp.substring(1));
        }
        return count;
    }

    static ArrayList<String> permutation2(String p, String unp) {
        if (unp.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = unp.charAt(0);
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutation2(f + ch + s, unp.substring(1)));
        }
        return ans;
    }

    static void permutation(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());
            permutation(f + ch + s, unprocessed.substring(1));
        }
    }

    // ============================================================================

    static List<List<Integer>> remove_duplicate_from_subset_of_array(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> final_ans = new ArrayList<>();
        final_ans.add(new ArrayList<>());
        int previous_i = 0;
        for (int i : arr) {
            int sizeOfFinalArray = final_ans.size();
            int sizeOfPreviousFinalArray = sizeOfFinalArray / 2;
            if (i != previous_i) {
                for (int j = 0; j < sizeOfFinalArray; j++) {
                    List<Integer> current_list = new ArrayList<>(final_ans.get(j));
                    current_list.add(i);
                    // System.out.println(current_list);
                    final_ans.add(current_list);
                }
            } else {
                for (int j = sizeOfPreviousFinalArray; j < sizeOfFinalArray; j++) {
                    List<Integer> current_list = new ArrayList<>(final_ans.get(j));
                    current_list.add(i);
                    // System.out.println(current_list);
                    final_ans.add(current_list);
                }
            }
            previous_i = i;
        }
        return final_ans;
    }

    static List<List<Integer>> subset_of_array(int[] arr) {
        List<List<Integer>> final_ans = new ArrayList<>();
        final_ans.add(new ArrayList<>());
        for (int i : arr) {
            int size_of_final_list = final_ans.size();
            for (int j = 0; j < size_of_final_list; j++) {
                List<Integer> current_list = new ArrayList<>(final_ans.get(j));
                current_list.add(i);
                // System.out.println(current_list);
                final_ans.add(current_list);
            }
        }
        return final_ans;
    }

    static void Subset_of_string_ascii(String p, String unp) {
        if (unp.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = unp.charAt(0);
        Subset_of_string_ascii(p + ch, unp.substring(1));
        Subset_of_string_ascii(p, unp.substring(1));
        Subset_of_string_ascii(p + (ch + 0), unp.substring(1));
    }

    static ArrayList<String> subset_of_String(String p, String unp) {
        if (unp.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = unp.charAt(0);
        ArrayList<String> acc = subset_of_String(p + ch, unp.substring(1));
        ArrayList<String> reg = subset_of_String(p, unp.substring(1));
        acc.addAll(reg);
        // System.out.println(acc);
        return acc;
    }

    static void subset_of_string(String p, String unp) {
        if (unp.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = unp.charAt(0);
        subset_of_string(p + ch, unp.substring(1));
        subset_of_string(p, unp.substring(1));
    }

    // --------------------------------------------

    static String skip_notskip_string_from_string(String string, String skip, String notskip) {
        if (string.isEmpty()) {
            return "";
        }
        char ch = string.charAt(0);
        if (string.startsWith(skip) && !string.startsWith(notskip)) {
            return skip_notskip_string_from_string(string.substring(skip.length()), skip, notskip);
        } else {
            return ch + skip_notskip_string_from_string(string.substring(1), skip, notskip);
        }
    }

    static String skip_string_from_string(String string, String skip) {
        if (string.isEmpty()) {
            return "";
        }
        char ch = string.charAt(0);
        if (string.startsWith(skip)) {
            return skip_string_from_string(string.substring(skip.length()), skip);
        } else {
            return ch + skip_string_from_string(string.substring(1), skip);
        }
    }

    static String skip_char_from_string(String string, char skip) {
        if (string.isEmpty()) {
            return "";
        }
        char ch = string.charAt(0);
        if (ch == skip) {
            return skip_char_from_string(string.substring(1), skip);
        } else {
            return ch + skip_char_from_string(string.substring(1), skip);
        }
    }

    static void skip_char_from_string(String string, String ans, char skip) {
        if (string.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = string.charAt(0);
        if (ch == skip) {
            skip_char_from_string(string.substring(1), ans, skip);
        } else {
            skip_char_from_string(string.substring(1), ans + ch, skip);
        }
    }

    // ============================================================================

    static int rotated_binary_search(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) {
            if (target >= arr[s] && target <= arr[m]) {
                return rotated_binary_search(arr, target, s, m - 1);
            } else {
                return rotated_binary_search(arr, target, m + 1, e);
            }
        }
        if (target >= arr[m] && target <= arr[e]) {
            return rotated_binary_search(arr, target, m + 1, e);
        }
        return rotated_binary_search(arr, target, s, m - 1);
    }

    static ArrayList<Integer> search_all_target_in_arraylist(int[] arr, int target, int index) {
        ArrayList<Integer> List = new ArrayList<Integer>();
        if (index == arr.length) {
            return List;
        }
        if (arr[index] == target) {
            List.add(index);
        }
        ArrayList<Integer> ans = search_all_target_in_arraylist(arr, target, index + 1);
        List.addAll(ans);
        return List;
    }

    static ArrayList<Integer> search_all_target_in_arraylist(int[] arr, int target, int index,
            ArrayList<Integer> List) {
        if (index == arr.length) {
            return List;
        }
        if (arr[index] == target) {
            List.add(index);
        }
        return search_all_target_in_arraylist(arr, target, index + 1, List);
    }

    // ----------------------------------

    static ArrayList<Integer> list = new ArrayList<Integer>();

    static void search_all_target_in_array(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        search_all_target_in_array(arr, target, index + 1);
    }

    static int search_target_in_array(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return search_target_in_array(arr, target, index + 1);
    }

    static boolean search_target_from_array_in_boolean(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        // return arr[index]==target ||
        // search_target_from_array_in_boolean(arr,target,index+1);
        if (arr[index] == target) {
            return true;
        }
        return search_target_from_array_in_boolean(arr, target, index + 1);
    }

    static boolean check_sorted_array(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        // return arr[index]< arr[index+1] && check_sorted_array(arr,index+1); // or
        if (arr[index] < arr[index + 1]) {
            return check_sorted_array(arr, index + 1);
        }
        return false;
    }

    // ============================================================================

    static void selection_sort(int[] arr, int end, int start, int max) {
        if (end == 0) { // length of arr = 0 then
            return;
        }
        if (end > start) { // find max_element
            if (arr[start] > arr[max]) {
                selection_sort(arr, end, start + 1, start);
            } else {
                selection_sort(arr, end, start + 1, max);
            }
        } else { // swap number to last index
            int temp = arr[max];
            arr[max] = arr[end - 1];
            arr[end - 1] = temp;
            selection_sort(arr, end - 1, 0, 0);
        }
    }

    static void bubble_sort(int[] arr, int end, int start) {
        if (end == 0) { // if length of arr = 0 then
            return;
        }
        if (end > start) { // if length of arr > current index
            if (arr[start] > arr[start + 1]) { // check current and current next index value and swap
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            bubble_sort(arr, end, start + 1);
        } else {
            bubble_sort(arr, end - 1, 0);
        }
    }

    static int binary_search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return binary_search(arr, target, mid + 1, end);
        }
        return binary_search(arr, target, start, mid - 1);
    }

    // ============================================================================

    static void triangle(int row, int col) {
        if (row == 0) {
            return;
        }
        if (row > col) {
            triangle(row, col + 1);
            System.out.print("*");
        } else {
            triangle(row - 1, 0);
            System.out.println();
        }
    }

    static void rev_triangle(int row, int col) {
        if (row == 0) {
            return;
        }
        if (row > col) {
            System.out.print("*");
            rev_triangle(row, col + 1);
        } else {
            System.out.println();
            rev_triangle(row - 1, 0);
        }
    }

    // ============================================================================

    static int subtractProductAndSum(int n) {
        int s = sum_of_digits(n);
        int p = product_of_digits(n);
        return p - s;
    }

    static int countOperations(int num1, int num2) {
        return helpeer(num1, num2, 0);
    }

    private static int helpeer(int n1, int n2, int steps) {
        if (n1 == 0 | n2 == 0) {
            return steps;
        }
        if (n1 > n2) {
            return helpeer(n1 - n2, n2, steps + 1);
        }
        return helpeer(n1, n2 - n1, steps + 1);
    }

    static int step_count(int n) {
        return helperrr(n, 0);
    }

    private static int helperrr(int n, int steps) {
        if (n == 0) {
            return steps;
        }
        if (n % 2 == 0) {
            return helperrr(n / 2, steps + 1);
        }
        return helperrr(n - 1, steps + 1);
    }

    // ============================================================================

    static int count_zeroes0(int n) {
        return helperr(n, 0);
    }

    // special pattern, how to pass a value to above calls
    private static int helperr(int n, int c) {
        if (n == 0) {
            return c;
        }
        int rem = n % 10;
        if (rem == 0) {
            return helperr(n / 10, c + 1);
        }
        return helperr(n / 10, c);
    }

    static int count = 0;

    static void count_zeroes(int n) {
        if (n <= 0) {
            return;
        }
        if (n % 10 == 0) {
            count++;
        }
        count_zeroes(n / 10);
    }

    static int sum = 0;

    static boolean palindrome(int n) {
        reverse_number(n);
        return n == sum;
    }

    static void reverse_number(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverse_number(n / 10);
    }

    static int reverse_number2(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    static void reverse_number3(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 10);
        reverse_number3(n / 10);
    }

    // -----------------------------------

    static int sum_of_digits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sum_of_digits(n / 10);
    }

    static int product_of_digits(int n) {
        if (n == 0) {
            return 1;
        }
        return (n % 10) * product_of_digits(n / 10);
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // ============================================================================

    static void print_serial_number(int n) {
        if (n == 0) {
            return;
        }
        print_serial_number(n - 1);
        System.out.println(n);
    }

    static void print_reverse_serial_number(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print_reverse_serial_number(n - 1);
    }

    static void print_number_and_reverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        print_number_and_reverse(n - 1);
        System.out.println(n);
    }

    // ============================================================================

    static void print1(int n) {
        System.out.println(n); // first print 1 then
        print2(2); // call print2 function
    }

    static void print2(int n) {
        System.out.println(n);// second print 2 then
        print3(3);// call print3 function
    }

    static void print3(int n) {
        System.out.println(n);// third print 3 then
        print4(4);// call print4 function
    }

    static void print4(int n) {
        System.out.println(n);// fourth print 4 then
        print5(5);// call print5 function
    }

    static void print5(int n) {
        System.out.println(n);// fifth print return to ( print4 -> print3 -> print2 -> print1 -> print )
                              // function
    }

    // same as upper code
    static void Print(int n) {
        if (n == 5) {
            System.out.println(5); // print 5
            return; // end
        }
        System.out.println(n); // print 1 -> 2 -> 3 -> 4
        Print(n + 1); // Print(2) -> 2 -> Print(3) -> 3 -> Print(4) -> 4 -> Print(5)
    }
}