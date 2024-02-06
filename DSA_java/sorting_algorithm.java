import java.util.Arrays;

public class sorting_algorithm {
    public static void main(String[] args) // main method for call all sorting algorithm
    {
        // for a continues range from 1 to N :-
        int[] arr1 = { 3, 5, 2, 1, 4 };
        System.out.println("Sorted Array (Cyclic_Sort)        : " + Arrays.toString(Cyclic_sort(arr1)));
        // for all type of sorting problem :-
        int[] arr = { 833, 525, 699, 289, 716, 93, 256, 0, 491, 796, 862, 679, 77, 644, 365, 49, 902 };
        System.out.println("Original Array : " + Arrays.toString(arr) + "\n");
        System.out.println("Sorted Array (Bubble_Sort)        : " + Arrays.toString(Bubble_sort(arr)));
        System.out.println("Sorted Array (Insertion_Sort)     : " + Arrays.toString(Insertion_sort(arr)));
        System.out.println("Sorted Array (Selection_Sort)     : " + Arrays.toString(Selection_sort(arr)));
        // recursion is used in next all algorithm :-
        System.out.println("Sorted Array (Merge_Sort)         : " + Arrays.toString(Merge_sort(arr)));
        System.out.println("Sorted Array (Merge_Sort_inplace) : " + Arrays.toString(Merge_sort_inplace(arr, 0, arr.length)));
        System.out.println("Sorted Array (Quick_Sort)         : " + Arrays.toString(Quick_sort(arr, 0, arr.length - 1)));
    }

    // ------------------------------------------------------------------------------------------
    
    static int[] Cyclic_sort(int[] arr) // when range is " 1 to N " then use this sorting algorithm here all number is given in range.
    {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                Swap(arr, i, correct);
            } else {
                i++;
            }
        }
        return arr;
    }

    // ------------------------------------------------------------------------------------------

    static int[] Bubble_sort(int[] arr) {
        for (int i = 0; i < (arr.length); i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] >= arr[j]) {
                    Swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    // ------------------------------------------------------------------------------------------

    static int[] Insertion_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    Swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    // ------------------------------------------------------------------------------------------

    static int[] Selection_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lastindex = arr.length - i - 1;
            int maxindex = 0;
            for (int j = 0; j <= lastindex; j++) {
                if (arr[j] > arr[maxindex]) {
                    maxindex = j;
                }
            }
            Swap(arr, lastindex, maxindex);
        }
        return arr;
    }

    // --------------------------------------

    static void Swap(int[] arr, int firstindex, int secondindex) {
        int temp = arr[firstindex];
        arr[firstindex] = arr[secondindex];
        arr[secondindex] = temp;
    }

    // ------------------------------------------------------------------------------------------

    static int[] Merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left_arr = Merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right_arr = Merge_sort(Arrays.copyOfRange(arr, mid, arr.length));
        return Merge(left_arr, right_arr);
    }

    // ---------------------------------------

    private static int[] Merge(int[] first, int[] second) {
        int[] new_arr = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                new_arr[k] = first[i];
                i++;
            } else {
                new_arr[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < first.length) {
            new_arr[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            new_arr[k] = second[j];
            j++;
            k++;
        }
        return new_arr;
    }

    // ------------------------------------------------------------------------------------------

    static int[] Merge_sort_inplace(int[] arr, int start, int end) {
        if ((end - start) == 1) {
            return arr;
        }
        int mid = (start + end) / 2;
        Merge_sort_inplace(arr, start, mid);
        Merge_sort_inplace(arr, mid, end);
        Merge_inplace(arr, start, mid, end);
        return arr;
    }

    // ---------------------------------------

    private static void Merge_inplace(int[] arr, int start, int mid, int end) {
        int[] new_arr = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                new_arr[k] = arr[i];
                i++;
            } else {
                new_arr[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < mid) {
            new_arr[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            new_arr[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < new_arr.length; l++) {
            arr[start + l] = new_arr[l];
        }
    }

    // -----------------------------------------------------------------------------------

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