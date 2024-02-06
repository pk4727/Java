import java.util.Arrays;
import java.util.Scanner;

public class linear_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 3, 4, 6, 7, 9, 0, 6, 5 };
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.print("Enter number for search in array : ");
        LinearSearch(arr, sc.nextInt()); // Linear search in array
        sc.close();
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
}