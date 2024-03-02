package Stack_and_Queue;

import java.util.Stack;

public class stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int ptr = -1;

    public stack() {
        this(DEFAULT_SIZE);
    }

    public stack(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == data.length - 1; // ptr is at last index
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean push(int item) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            // for (int i = 0; i < data.length; i++) { temp[i] = data[i]; } // or
            System.arraycopy(data, 0, temp, 0, data.length); // (originalArray , originalStartIndex, temporaryArray,
                                                             // tempStartIndex, lengthTillCopy)
            data = temp;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty stack !!");
        }
        // int removed = data[ptr]; // this or
        // ptr--;
        // return removed;
        return data[ptr--]; // this
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty stack !!");
        }
        return data[ptr];
    }

    public void display() throws Exception {
        for (int i = 0; i < ptr; i++) {
            System.out.print(data[i] + " -> ");
        }
        System.out.println("END");
    }
}

class default_stack {
    public static void main(String[] args) {
        Stack<Integer> ds = new Stack<>();
        ds.push(15);
        ds.push(25);
        ds.push(15);
        ds.push(25);
        ds.push(15);
        ds.push(25);
        System.out.println(ds.peek());
        System.out.println(ds.pop());
    }
}