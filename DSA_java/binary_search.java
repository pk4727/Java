import java.util.Arrays;
import java.util.Scanner;

public class binary_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ------------------------------------------------------for_single_dimension_array

        int[] arr3 = { 2, 4, 6, 9, 11, 12, 14, 16, 20, 22, 36, 48 };
        System.out.println("\nArray : " + Arrays.toString(arr3));
        System.out.print("Enter number for search in array : ");

        int ans4 = Binary_search(arr3, sc.nextInt());
        if (ans4 == -1) {
            System.out.println("Given number is not in array !");
        } else {
            System.out.println("Given number is found in index : " + ans4);
        }
        System.out.println("---------------");
        int[] arr4 = { 48, 41, 16, 13, 12, 10, 9, 8, 5, 4, 2, 1 };
        System.out.println("\nArray : " + Arrays.toString(arr4));
        System.out.print("Enter number for search in array : ");

        int ans5 = order_agnostic_Binary_search(arr4, sc.nextInt());
        if (ans5 == -1) {
            System.out.println("Given number is not in array !");
        } else {
            System.out.println("Given number is found in index : " + ans5);
        }

        // -----------------------------------------------------for_multidimensional_array

        int[][] arr1 = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 } };
        System.out.println("\nArray : " + Arrays.toString(arr1[0]));
        System.out.println("        " + Arrays.toString(arr1[1]));
        System.out.println("        " + Arrays.toString(arr1[2]));
        System.out.println("        " + Arrays.toString(arr1[3]));
        System.out.print("Enter number which is search in array : ");

        int[] ans1 = search_in2d(arr1, sc.nextInt());
        System.out.println("By binary_search_2D_1 : " + Arrays.toString(ans1));
        System.out.println("---------------");

        int[][] arr2 = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println("\nArray : " + Arrays.toString(arr2[0]));
        System.out.println("        " + Arrays.toString(arr2[1]));
        System.out.println("        " + Arrays.toString(arr2[2]));
        System.out.println("        " + Arrays.toString(arr2[3]));
        System.out.print("Enter number which is search in array : ");

        int[] ans2 = search_in2d_sortedl(arr2, sc.nextInt());
        System.out.println("By linear_search_2D_2 : " + Arrays.toString(ans2));
        System.out.println("---------------");

        System.out.print("Enter number which is search in array : ");
        int[] ans3 = search_2d(arr2, sc.nextInt());
        System.out.println("By binary_search_2D_3 : " + Arrays.toString(ans3));
        System.out.println("---------------");
        sc.close();
    }

    // ----------------------------------1D------------------------------------------

    static int Binary_search(int[] arr, int target) // for asecnding order sorted array
    {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + ((end - start) / 2));
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    // ------------------------------or-------------------------------------------------

    static int order_agnostic_Binary_search(int[] arr, int target) // for sorted array but order is not known
    {
        int start = 0;
        int end = arr.length - 1;
        boolean is_asc = arr[start] < arr[end]; // checking sorted order of array
        while (start <= end) {
            int mid = (start + ((end - start) / 2));
            if (target == arr[mid]) // for any sorted array
            {
                return mid;
            }
            if (is_asc) // for ascending sorted array
            {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = mid - 1;
                }
            } else // for descending sorted array
            {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    // ---------------------------------2D---------------------------------------------

    static int[] search_in2d(int[][] arr, int target) // here sorted in row and column wise
    {
        int row = 0;
        int column = arr.length - 1;
        while (row < arr.length && column >= 0) {
            // System.out.println(row + " " + column + " " + (arr[row][column]));
            if (arr[row][column] == target) {
                return new int[] { row, column };
            } else if (target < arr[row][column]) {
                column--;
            } else if (target > arr[row][column]) {
                row++;
            }
        }
        return new int[] { -1, -1 };
    }

    // --------------------------------------or------------------------------------------

    static int[] search_in2d_sortedl(int[][] arr, int target) // here sorted in this way that first_row_column then
                                                              // second_row_column .....
    {
        int column = 0; // start
        int row = arr.length - 1; // end
        while (column < arr.length && row >= 0) // by linear search
        {
            // System.out.println(row + " " + column + " " + (arr[row][column]));
            if (arr[row][column] == target) {
                return new int[] { row, column };
            } else if (target < arr[row][column]) {
                row--;
            } else if (target > arr[row][column]) {
                column++;
            }
        }
        return new int[] { -1, -1 };
    }

    // --------------------------------or------------------------------------------------

    static int[] search_2d(int[][] arr, int target) // here_sorted_in_this_way_that_first_row_column_then_second_row_column.....
    {
        int rows = arr.length;
        int cols = arr[0].length;
        if (cols == 0) {
            return new int[] { -1, -1 };
        }
        if (rows == 1) {
            return binary_search_2d(arr, 0, 0, (cols - 1), target);
        }

        int rs = 0;
        int re = rows - 1;
        int cmid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rs < (re - 1)) // while this is true it will have more than 2 rows
        {
            int mid = rs + ((re - rs) / 2);
            if (target == arr[mid][cmid]) {
                return new int[] { mid, cmid };
            }
            if (target > arr[mid][cmid]) {
                rs = mid;
            } else {
                re = mid;
            }
        }

        if (target == arr[rs][cmid]) // check whether the target is in the col of 2 rows
        {
            return new int[] { rs, cmid };
        }
        if (target == arr[rs + 1][cmid]) {
            return new int[] { rs + 1, cmid };
        }
        if (target <= arr[rs][cmid - 1]) // search in 1st half
        {
            return binary_search_2d(arr, rs, 0, cmid - 1, target);
        }
        if (target >= arr[rs][cmid + 1] && target <= arr[rs][cols - 1]) // search in 2nd half
        {
            return binary_search_2d(arr, rs, cmid + 1, cols - 1, target);
        }
        if (target <= arr[rs + 1][cmid - 1]) // search in 3rd half
        {
            return binary_search_2d(arr, rs + 1, 0, cmid - 1, target);
        } else // search in 4rd half
        {
            return binary_search_2d(arr, rs + 1, cmid + 1, cols - 1, target);
        }
    }

    static int[] binary_search_2d(int[][] arr, int row, int cs, int ce, int target) // search_in_the_row_provided_between_the_cols_provided
    {
        while (cs <= ce) // by binary search
        {
            int mid = cs + ((ce - cs) / 2);
            if (target == arr[row][mid]) {
                return new int[] { row, mid };
            }
            if (target > arr[row][mid]) {
                cs = mid + 1;
            } else if (target < arr[row][mid]) {
                ce = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}

class question {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 15;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    static int ceiling(int[] arr, int target) // return the index of smallest no >= target
    {
        if (target > arr[arr.length - 1]) // but what if the target is greater than the greatest number in the array
        {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; // might be possible that (start + end) exceeds
            // the range of int in java
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else // ans found
            {
                return mid;
            }
        }
        return start;
    }

    static int floor(int[] arr, int target) // return the index: greatest number <= target
    {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; // might be possible that (start + end) exceeds
            // the range of int in java
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else // ans found
            {
                return mid;
            }
        }
        return end;
    }
}