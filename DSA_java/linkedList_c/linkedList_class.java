package linkedList_c;

public class linkedList_class {
    private Node head;
    private Node tail;
    private int size;

    public linkedList_class() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node getReferanceOfNode(int index) {
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public int get(int index) {
        if (index >= size) {
            System.out.println("index is greater than size of linked list.");
            return -1;
        }
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public int find(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.value == value) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("value not found in linked list.");
        return -1;
    }

    public int size() {
        return size;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    public void insertByRec(int index, int value) {
        head = insertRec(index, value, head);
    }

    private Node insertRec(int index, int value, Node cnode) {
        if (index == 0) {
            Node n = new Node(value, cnode);
            size++;
            return n;
        }
        cnode.next = insertRec(index - 1, value, cnode.next);
        return cnode;
    }

    public int deleteFirst() {
        int element = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return element;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = getReferanceOfNode(size - 1);
        int element = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return element;
    }

    public int deleteAt(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node previousnode = getReferanceOfNode(index);
        int element = previousnode.next.value;
        previousnode.next = previousnode.next.next; // next set to [ index-1 -> index+1 ]
        size--;
        return element;
    }

    public void removeDuplicate() { // leetcode_83
        deleteDuplicates(head);
        display();
    }

    private Node deleteDuplicates(Node head) {
        if (head == null) {
            return head;
        }
        Node ans = head;
        while (head.next != null) {
            if (head.value == head.next.value) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    public linkedList_class merge(linkedList_class list1, linkedList_class list2) { // l_21
        Node h1 = list1.head;
        Node h2 = list2.head;
        linkedList_class ans = new linkedList_class();
        while (h1 != null && h2 != null) {
            if (h1.value <= h2.value) {
                ans.insertLast(h1.value);
                h1 = h1.next;
            } else {
                ans.insertLast(h2.value);
                h2 = h2.next;
            }
        }
        while (h1 != null) {
            ans.insertLast(h1.value);
            h1 = h1.next;
        }
        while (h2 != null) {
            ans.insertLast(h2.value);
            h2 = h2.next;
        }
        return ans;
    }

    public boolean hasCycle(linkedList_class list) { // l_141
        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int middleNode2(linkedList_class list) { // l_876
        Node slow = list.head;
        Node temp = list.head;
        int length = 1;
        while (slow.next != null) {
            length += 1;
            slow = slow.next;
        }
        int middle = (length / 2);
        while (middle != 0) {
            temp = temp.next;
            middle--;
        }
        return temp.value;
    }

    public int middleNode(linkedList_class list) {
        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    Node getMid(Node head) {
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public void sortListBubble() {
        sortList(size - 1, 0);
    }

    private void sortList(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            Node first = getReferanceOfNode(col);
            Node second = getReferanceOfNode(col + 1);
            if (first.value > second.value) {
                if (first == head) { // col in start
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) { // col in end
                    Node prev = getReferanceOfNode(col - 1);
                    prev.next = second;
                    tail = first;
                    second.next = tail;
                    first.next = null;
                } else { // col not in start and end
                    Node prev = getReferanceOfNode(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            } else {
                sortList(row, col + 1);
            }
            sortList(row - 1, 0);
        }
    }

    public linkedList_class reverseList2(linkedList_class list) { // l_206
        Node temp = list.head;
        linkedList_class ans = new linkedList_class();
        while (temp != null) {
            ans.insertFirst(temp.value);
            temp = temp.next;
        }
        return ans;
    }

    public linkedList_class reverseList1(linkedList_class list) {
        if (list.head == null || list.head.next == null) {
            return list;
        }
        Node prev = null;
        Node present = list.head;
        Node next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        list.head = prev;
        return list;
    }

    public linkedList_class reverseBetween(linkedList_class list,int start,int end){
        
        return null;
    }
}
