import java.util.Arrays;
import java.util.HashMap;

public class sorting_algorithm {
    public static void main(String[] args) // main method for call all sorting algorithm
    {
        int[] arr1 = { 3, 5, 2, 1, 4 };
        int[] arr2 = { 833, 525, 699, 289, 716, 93, 256, 0, 491, 796, 862, 679, 77, 644, 365, 49, 902 };
        System.out.println("Original Array : -----------------------> " + Arrays.toString(arr1));
        System.out.println("Original Array : -----------------------> " + Arrays.toString(arr2));

        // for a continues range from 1 to N :-
        System.out.println("\nSorted Array (Cyclic_Sort) : -----------> " + Arrays.toString(Cyclic_sort(arr1)));

        // for all type of sorting problem :-
        System.out.println("\nSorted Array (Count_Sort_normal) : -----> " + Arrays.toString(Count_sort(arr1)));
        System.out.println("Sorted Array (Count_Sort_by_HashMap) : -> " + Arrays.toString(Count_sort_Hashmap(arr1)));
        System.out.println("Sorted Array (Bubble_Sort) : -----------> " + Arrays.toString(Bubble_sort(arr2)));
        System.out.println("Sorted Array (Insertion_Sort) : --------> " + Arrays.toString(Insertion_sort(arr2)));
        System.out.println("Sorted Array (Selection_Sort) : --------> " + Arrays.toString(Selection_sort(arr2)));
        System.out.println("Sorted Array (Radix_Sort)         : ----> " + Arrays.toString(Radix_sort(arr2)));

        // recursion is used in next all algorithm :-
        System.out.println("\nSorted Array (Merge_Sort) : ------------> " + Arrays.toString(Merge_sort(arr2)));
        System.out.println("Sorted Array (Merge_Sort_inplace) : ----> "
                + Arrays.toString(Merge_sort_inplace(arr2, 0, arr2.length)));
        System.out.println(
                "Sorted Array (Quick_Sort) : ------------> " + Arrays.toString(Quick_sort(arr2, 0, arr2.length - 1)));
    }

    // ------------------------------------------------------------------------------------------

    static int[] Cyclic_sort(int[] arr) // when range is " 1 to N " then use this sorting algorithm here all number is
                                        // given in range.
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

    public static int[] Count_sort(int[] arr) { // non comparison based algo (for smaller number)
        if (arr == null && arr.length <= 1) {
            return null;
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        int[] frequencyArray = new int[max + 1];
        for (int num : arr) {
            frequencyArray[num]++;
        }
        int index = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                while (frequencyArray[i] > 0) {
                    arr[index] = i;
                    index++;
                    frequencyArray[i]--;
                }
            }
        }
        return arr;
    }

    // --------------------------------------

    public static int[] Count_sort_Hashmap(int[] arr) { // non comparison based algo (for smaller number)
        if (arr == null && arr.length <= 1) {
            return null;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();
        for (int num : arr) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = frequencyCount.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[index] = i;
                index++;
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

    static void Swap(int[] arr, int firstindex, int secondindex) {
        int temp = arr[firstindex];
        arr[firstindex] = arr[secondindex];
        arr[secondindex] = temp;
    }

    // ------------------------------------------------------------------------------------------
    public static int[] Radix_sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exponent = 1; max / exponent > 0; exponent *= 10) {
            countSort(arr, exponent);
        }
        return arr;
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 0 to 9 10 value so size=10
        Arrays.fill(count, 0); // fill count arr to 0
        for (int i = 0; i < n; i++) { // gives the exp place value
            count[(arr[i] / exp) % 10]++; // (eg 471 ,exp = 10 then 471/10 = 47 and 47%10 = 7)
        }
        // System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1]; // for find index of coming original value
        }
        // System.out.println("Updated count array " + Arrays.toString(count));
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // System.out.println("Output array " + Arrays.toString(output));
        System.arraycopy(output, 0, arr, 0, n);
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