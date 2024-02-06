package linkedList_c;

import java.util.ArrayList;

public class circularLinkedList {
    private Node head;
    private Node tail;

    public circularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println("End");
    }

    public void insert(int value) {
        Node newnode = new Node(value);
        if (head == null) {
            head = newnode;
            tail = newnode;
            return;
        }
        tail.next = newnode;
        newnode.next = head;
        tail = newnode;
    }

    public void delete(int value) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        }
        if (currentNode.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node nextnode = currentNode.next;
            if (nextnode.value == value) {
                currentNode.next = nextnode.next;
                break;
            }
            currentNode = currentNode.next;
        } while (currentNode != head);
    }

    public boolean hasCycle(circularLinkedList list) { // solved by fast(2 step) and slow(1 step) pointer
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

    public int CycleElementCount(circularLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                int count = 1;
                Node temp = slow.next;
                while (temp != slow) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
        }
        return 0;
    }

    public int CycleStartAtNode(circularLinkedList list) {
        int length = CycleElementCount(list);
        if (length == 0) {
            return -1;
        }
        Node f = list.head;
        Node s = list.head;
        while (length > 0) {
            s = s.next;
            length--;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s.value;
    }

    public int CycleStartAtIndex(circularLinkedList list) {
        Node slow = list.head;
        Node fast = list.head;
        int index = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                Node temp = list.head;
                while (temp != slow) {
                    index++;
                    temp = temp.next;
                }
                return index;
            }
        }
        return 0;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public boolean isHappy(int num) {
        int fast = num;
        int slow = num;
        do {
            fast = findSquare(findSquare(num));
            slow = findSquare(num);
        } while (fast != slow);
        if (slow == 1 || fast == 1) {
            return true;
        }
        return false;
    }
}

class Mainn {
    public static void main(String[] args) {
        circularLinkedList cl = new circularLinkedList();
        int n = 10;
        System.out.println(cl.isHappy(n));
    }
}