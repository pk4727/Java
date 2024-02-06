//package java.DSA_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class array {
    Scanner sc = new Scanner(System.in);

     public static void main(String[] args) // -------------------- leetcode
//     problem 1295 and 1672
    {
        int[] arr1 = { 555, 901, 482, 1771 };
        System.out.println(find_even_digits_Number(arr1));
        int[][] arr2 = { { 1, 2, 3 }, { 3, 2, 1 } };
        System.out.println(max_sum_of_numbers_of_array(arr2));

    }

    static int max_sum_of_numbers_of_array(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int salary = 0;
            for (int j = 0; j < arr[i].length; j++) {
                salary += arr[i][j];
            }
            if (salary > max) {
                max = salary;
            }
        }
        return max;
    }

    static int find_even_digits_Number(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String digits = Integer.toString(arr[i]);
            int len = digits.length();
            if (len % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // public static void main(String[] args) // -------------------------------
    // LinearSearch :-
    {
        int[] arr3 = { 3, 4, 6, 7, 9, 0, 6, 5 };
        System.out.println("Array = " + Arrays.toString(arr3));
        System.out.print("Enter number for search in array : ");
        LinearSearch(arr3, sc.nextInt()); // Linear search in array
    }

    static void LinearSearch(int[] arr, int number) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            int found = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == number) {
                    found++;
                    System.out.println("Number found at index : " + i);
                }
            }
            if (found == 0) {
                System.out.println("Number not found !");
            }
        }
    }

    // public static void main(String[] args) // -----------------------------
    // question solving :-

    {
        int[] arr4 = { 8, 4, 0, 9, 5, 7 };
        System.out.println("Original array : " + Arrays.toString(arr4));
        swap(arr4, 1, 5); // 1.swape two value of array
        System.out.println("Swapped array : " + Arrays.toString(arr4));
        max(arr4); // 2. Maximum of array
        max_in_given_value_range(arr4, 1, 5); // 3.Maximum of array between given value_range
        max_in_given_index_range(arr4, 0, 2); // 4.Maximum of array between given index_range
        reverse(arr4); // 5.reverse array
    }

    static void reverse(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
            System.out.println("Reversed array is : " + Arrays.toString(arr));
        }
    }

    static void max_in_given_index_range(int[] arr, int start, int end) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            int max = 0;
            for (int i = start; i < end; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println("Maximum of array between given index " + start + " and "
                    + end + " : " + max);
        }
    }

    static void max_in_given_value_range(int[] arr, int start, int end) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > start & arr[i] < end) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
            }
            if (max != 0 & max <= end) {
                System.out.println("Maximum of array between given value " + start + " and "
                        + end + " : " + max);
            } else {
                System.out.println("invilid range !");
            }
        }
    }

    static void max(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println("Maximum of array : " + max);
        }
    }

    static void swap(int[] arr, int index1, int index2) {
        if (arr.length == 0) {
            System.out.println("Array is empty !");
        } else {
            arr[index1] = arr[index1] + arr[index2];
            arr[index2] = arr[index1] - arr[index2];
            arr[index1] = arr[index1] - arr[index2];
        }
    }

    // public static void main(String[] args) // ---------------------- Array basic:-
    {
        // datatype[] variable_name = new datatype[size]; // for Singe-Dimension array
        int[] x = new int[5]; // or
        int[] x1 = { 1, 2, 3, 4, 5 }; // or
        int[] x2;
        x2 = new int[5]; // insertinon value in array
        x[1] = 10;
        x1[6] = 6; // give error because size is fix when initizeed to 5;
        x2[1] = 5;
        System.out.println(Arrays.toString(x)); // printing array
        for (int i = 0; i < x.length; i++) {
            System.out.println(i + " " + x[i]);
        }
        System.out.println(Arrays.toString(x1));
        System.out.println(Arrays.toString(x2));


        // datatype[][] variable_name = new datatype[size1][size2]; 
        // for multi-Dimension array (size1=(rows) is compulasory but size2=(column) is not compulsary )
        int[][] arr5 = new int[3][3];
        for (int i = 0; i < arr5.length; i++) // insertinon value in array
        {
            for (int j = 0; j < arr5[i].length; j++) {
                arr5[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < arr5.length; i++) // printing array
        {
            System.out.println(Arrays.toString(arr5[i]));
        } // or
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                System.out.print(arr5[i][j] + " ");
            }
            System.out.println();
        } // or
        for (int[] a : arr5) {
            System.out.println(Arrays.toString(a));
        }


        ArrayList<Integer> list1 = new ArrayList<>(10); // builtin class arraylist for Single-Dimension array
        for (int i = 20; i > 0; i--) // insertion value in arraylist
        {
            list1.add(i);
        }
        for (int i = 0; i < list1.size(); i++) // printing arraylist1
        {
            System.out.print(list1.get(i) + ", ");
        }
        System.out.println();
        list1.set(5, 50); // changing any index value
        list1.remove(18); // delete any index value
        System.out.println(list1);


        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(); // builtin class arraylist for multi-Dimension array
        System.out.print("input: ");
        for (int i = 0; i < 3; i++) // initilisation of nested list
        {
            list2.add(new ArrayList<>());
        }
        for (int i = 0; i < 3; i++) // insertion value in arraylist
        {
            for (int j = 0; j < 3; j++) {
                list2.get(i).add(sc.nextInt());
            }
        }
        System.out.println("output: ");
        for (int i = 0; i < list2.size(); i++) // printing arraylist
        {
            for (int j = 0; j < list2.get(i).size(); j++) {
                System.out.print(list2.get(i).get(j) + " ");
            }
            System.out.println();
        } // or
        System.out.println("output: " + list2);
    }
}