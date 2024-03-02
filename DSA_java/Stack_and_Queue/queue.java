package Stack_and_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;

    public queue() {
        this(DEFAULT_SIZE);
    }

    public queue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length; // ptr is at last index
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        data[end] = item;
        end++;
        return true;
    }

    public int delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty queue !!");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty queue !!");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}

class default_queue {
    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.peek());
        System.out.println(q.remove());

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(2);
        dq.add(3);
        dq.add(4);
        dq.add(1);
        System.out.println(dq.peek());
        System.out.println(dq.remove());
    }
}
