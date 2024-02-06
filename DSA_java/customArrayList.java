//package java.DSA_java;

import java.util.Arrays;
public class customArrayList<T> { // Generic<T> is used here
// public class customArrayList<T extends Number> { // gerneric with some restriction in type called wiledcard
    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public customArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public T remove() {
        T item = (T) (data[--size]);
        return item;
    }

    public T get(int index) {
        return (T) (data[index]);
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "customArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] newArray = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) { // copy element from old array to new arr
            newArray[i] = data[i];
        }
        data = newArray;
    }
}

class check_customArray {
    public static void main(String[] args) {
        customArrayList<Integer> list3 = new customArrayList<>();
        for (int i = 0; i < 14; i++) {
            list3.add(2 * i);
        }
        System.out.println(list3);

    }
}

// public class customArrayList{
class cA {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    // public customArrayList(){
    public cA() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    public int remove() {
        int item = data[--size];
        return item;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int number) {
        data[index] = number;
    }

    @Override
    public String toString() {
        return "customArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        int[] newArray = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) { // copy element from old array to new
            newArray[i] = data[i];
        }
        data = newArray;
    }
}