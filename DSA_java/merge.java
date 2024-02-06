import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr = { 8, 3, 4, 12, 5, 6 };
        System.out.println(Arrays.toString(Merge_sort(arr)));
        System.out.println(Arrays.toString(Merge_sort_inplace(arr, 0, arr.length)));
    }

    static int[] Merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left_arr = Merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right_arr = Merge_sort(Arrays.copyOfRange(arr, mid, arr.length));
        return Merge(left_arr, right_arr);
    }

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
}
