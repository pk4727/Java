package linkedList_c;

public class doublyLinkedList {
    private Node head;

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void display() {
        System.out.print("Start -> ");
        Node lastnode = null;
        Node temp = head;
        while (temp != null) {
            lastnode = temp;
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End -> ");
        while (lastnode != null) {
            System.out.print(lastnode.value + " -> ");
            lastnode = lastnode.prev;
        }
        System.out.println("Start");
    }

    public void insertFirst(int value) {
        Node newnode = new Node(value);
        newnode.next = head;
        newnode.prev = null;
        if (head != null) {
            head.prev = newnode;
        }
        head = newnode;
    }

    public void insertLast(int value) {
        Node newnode = new Node(value);
        newnode.next = null;
        Node lastnode = head;
        if (head == null) {
            newnode.prev = null;
            head = newnode;
            return;
        }
        while (lastnode.next != null) {
            lastnode = lastnode.next;
        }
        newnode.prev = lastnode;
        lastnode.next = newnode;
    }

    public int deleteFirst() {
        int element = head.value;
        head = head.next;
        if (head == null) {
            head.next = null;
        }
        head.prev = null;
        return element;
    }

    public int deleteLast() {
        if (head.next == null) {
            return deleteFirst();
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node secondlastnode = temp.prev;
        int element = secondlastnode.value;
        secondlastnode.next = null;
        return element;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void insertAfter(int after, int value) {
        Node beforenode = find(after);
        Node afternode = beforenode.next;
        if (beforenode == null) {
            System.out.println("value not found in linked list.");
        }
        Node newnode = new Node(value);
        newnode.prev = beforenode;
        beforenode.next = newnode;
        newnode.next = afternode;
        if (newnode.next != null) {
            afternode.prev = newnode;
        }
    }
}
