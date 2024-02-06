import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
        int[] arr = { 8, 2, 3, 9, 4, 6, 5 };
        System.out.println(Arrays.toString(Quick_sort(arr, 0, arr.length - 1)));
    }

    static int[] Quick_sort(int[] nums, int low, int high) {
        if (low >= high) {
            return nums;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start <= end) {
            // also a reason why if its already sorted it will not swap
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        // now my pivot is at correct index, please sort two halves now
        Quick_sort(nums, low, end);
        Quick_sort(nums, start, high);
        return nums;
    }
}
