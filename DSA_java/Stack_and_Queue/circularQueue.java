package Stack_and_Queue;

public class circularQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    protected int size = 0;

    public circularQueue() {
        this(DEFAULT_SIZE);
    }

    public circularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length; // ptr is at last index
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
            insert(item);
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty queue !!");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty queue !!");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
        }
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");
    }
}
