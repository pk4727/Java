import java.util.ArrayList;
//A heap is a useful data structure when it is necessary to repeatedly
// remove the object with the highest (or lowest) priority, or
// when insertions need to be interspersed with removals of the root node.
// A common implementation of a heap is the binary heap, in which the tree is a complete binary tree

class Heap<T extends Comparable<T>> {

  private final ArrayList<T> list;

  public int size() {
    return list.size();
  }

  public Heap() {
    list = new ArrayList<>();
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private int leftChild(int index) {
    return index * 2 + 1;
  }

  private int rightChild(int index) {
    return index * 2 + 2;
  }


  public void insert(T value) {
    list.add(value);
    upHeap(list.size() - 1);
  }

  private void upHeap(int index) {
    if (index == 0) {
      return;
    }
    int p = parent(index);
    if (list.get(index).compareTo(list.get(p)) < 0) {
      swap(index, p);
      upHeap(p);
    }
  }

  private void swap(int first, int second) {
    T temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
  }

  public T remove() throws Exception {
    if (list.isEmpty()) {
      throw new Exception("Removing from an empty heap!");
    }
    T temp = list.get(0);
    T last = list.remove(list.size() - 1);
    if (!list.isEmpty()) {
      list.set(0, last);
      downHeapMin(0);
    }
    return temp;
  }

  private void downHeapMin(int index) {
    int min = index;
    int left = leftChild(index);
    int right = rightChild(index);
    if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
      min = left;
    }
    if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
      min = right;
    }
    if (min != index) {
      swap(min, index);
      downHeapMin(min);
    }
  }

  private void downHeapMax(int index) { // heapify algorithm
    int max = index;
    int left = leftChild(index);
    int right = rightChild(index);
    if (left < list.size() && list.get(max).compareTo(list.get(left)) < 0) {
      max = left;
    }
    if (right < list.size() && list.get(max).compareTo(list.get(right)) < 0) {
      max = right;
    }
    if (max != index) {
      swap(max, index);
      downHeapMax(max); // This recursive call should only be made once after the comparisons
    }
  }

  public ArrayList<T> heapSort() throws Exception { // Min to Max Heap
    ArrayList<T> data = new ArrayList<>();
    while (!list.isEmpty()) {
      data.add(this.remove());
    }
    return data;
  }

  public ArrayList<T> maxHeap() throws Exception { // Max to Min Heap
    ArrayList<T> data = new ArrayList<>();
    while (!list.isEmpty()) {
      data.add(0, this.remove());
    }
    return data;
  }

  public ArrayList<T> maxHeap2() { // heapify algo for Max to Min
    for (int i = (list.size() / 2) - 1; i >= 0; i--) {
      downHeapMax(i);
    }
    return list;
  }

  public static void main(String[] args) throws Exception {
    Heap<Integer> heap = new Heap<>();
    Heap<Integer> heap2 = new Heap<>();
    Heap<Integer> heap3 = new Heap<>();
    int[] list = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
    for (int i : list) {
      heap.insert(i);
      heap2.insert(i);
      heap3.insert(i);
    }
    System.out.println("removed ele : " + heap.remove());

    ArrayList<Integer> arr1 = heap.heapSort(); // Min to Max Heap
    System.out.println(arr1);

    ArrayList<Integer> arr2 = heap2.maxHeap(); // Max to Min Heap
    System.out.println(arr2);

    ArrayList<Integer> arr3 = heap3.maxHeap2(); // heapify algo for Max to Min
    System.out.println(arr3);
  }
}
