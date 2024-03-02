import java.util.Arrays;

public class SQRT_decomposition {
    // [1,3,5,2,7,6,3,1,4,8] ------------------------------> n = 10 --> √n = 3 so,
    // divide the array into blocks of size √n = root(n) --> [ 1,3,5 | 2,7,6 | 3,1,4 | 8,0,0 ]
    // compute answer for every blocks --------------------> sum = [9, 15, 8, 8]
    // combined the block which have question range left to right --> if range = 3,8 = 15+8 ,or 2,5 = 5+15

    private int sqrt(int[] arr) { // sqrt of array length
        return (int) Math.sqrt(arr.length);
    }

    public int[] createBlockArray(int[] arr) { // divide array into blocks
        int root = sqrt(arr);
        int[] blocks = new int[root + 1]; // chunk or size+1 root is created with value 0
        int block_index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i % root == 0) { // index%root = 0 then change block to next
                block_index++;
            }
            blocks[block_index] += arr[i]; // add in current block
        }
        return blocks;
    }

    public int sum(int[] arr, int start, int end) { // sum process from array and blocks array
        int root = sqrt(arr);
        int[] blocks = createBlockArray(arr);

        int sum = 0;
        while (start % root != 0 && start < end && start != 0) { // left part of chunk
            sum += arr[start];
            start++;
        }
        while (start + root <= end) { // for middle part of chunk (whole chunk)
            sum += blocks[start / root];
            start += root;
        }
        while (start <= end) { // for right part of chunk
            sum += arr[start];
            start++;
        }
        return sum;
    }

    public void updateArray(int[] arr, int[] blocks, int index, int value) { // for update any index in array
        int root = sqrt(arr);
        int blockIndex = index % root;
        blocks[blockIndex] += (value - arr[index]); // add (current and previous value difference) to block array index
        arr[index] = value; // change value of given array index
    }

    public static void main(String[] args) { // main method
        SQRT_decomposition s = new SQRT_decomposition();
        int[] arr = { 1, 3, 5, 2, 7, 6, 3, 1, 4, 8 };

        System.out.println(s.sum(arr, 2, 7)); // sum in index range

        int[] blocks = s.createBlockArray(arr); // show/create blocks array
        System.out.println(Arrays.toString(blocks));

        s.updateArray(arr, blocks, 4, 2); // update index of array
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(blocks));
    }
}
