package linkedList_c;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
        public static void main(String[] args) {
                System.out.println("\n==================== singly Linked list started =======================");
                LinkedList<Integer> ol = new LinkedList<>(); // given class of Linked list is used from java.util
                linkedList_class list = new linkedList_class(); // custom singly Linked list
                linkedList_class list2 = new linkedList_class();
                ol.addFirst(1);
                ol.addFirst(2);
                ol.addFirst(3);
                ol.addFirst(4);
                ol.addFirst(5);
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.insertFirst(1);
                list.insertFirst(2);
                list.insertFirst(3);
                list.insertFirst(4);
                list.insertFirst(5);
                list.display();
                System.out.println("----------------");

                ol.addLast(6);
                ol.addLast(7);
                ol.addLast(8);
                ol.addLast(9);
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.insertLast(8);
                list.insertLast(9);
                list.insertLast(3);
                list.insertLast(5);
                list.insertLast(6);
                list.insertLast(7);
                list.insertLast(11);
                list.display();

                list2.insertLast(1);
                list2.insertLast(2);
                list2.insertLast(4);
                list2.insertLast(5);
                list2.insertLast(6);
                list2.insertLast(8);
                list2.insertLast(10);
                list2.display();
                ol.add(3, 10);
                ol.add(5, 11);
                ol.add(7, 12);
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.insertAt(3, 10);
                list.insertAt(5, 11);
                list.insertAt(7, 12);
                list.display();
                System.out.println("----------------");

                list.insertByRec(0, 22); // work as insert at first
                list.display();
                list.insertByRec(3, 21); // work as insert at index
                list.display();
                list.insertByRec(list.size(), 23); // work as insert at last
                list.display();
                System.out.println("----------------");

                System.out.println("size_o = " + ol.size());
                System.out.println("size = " + list.size());

                System.out.println("given index value is_o : " + ol.get(5));
                System.out.println("given index value is : " + list.get(5));

                System.out.println("value found at index : " + list.find(4));

                ol.removeFirst();
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.deleteFirst();
                list.display();
                System.out.println("----------------");

                ol.removeLast();
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.deleteLast();
                list.display();
                System.out.println("----------------");

                ol.remove(5);
                ol.forEach(Integer -> System.out.print(Integer + " -> "));
                System.out.println();
                list.deleteAt(5);
                list.display();

                System.out.println("\n==================== doubly Linked list started =======================");
                doublyLinkedList dl = new doublyLinkedList(); // custom doubly Linked list
                dl.insertFirst(1);
                dl.insertFirst(2);
                dl.insertFirst(3);
                dl.insertFirst(4);
                dl.insertFirst(5);
                dl.display();

                dl.insertLast(6);
                dl.insertLast(7);
                dl.insertLast(8);
                dl.insertLast(9);
                dl.display();

                dl.insertAfter(6, 10);
                dl.display();

                dl.deleteFirst();
                dl.display();
                dl.deleteLast();
                dl.display();

                System.out.println("\n==================== circular Linked list started =======================");
                circularLinkedList cl = new circularLinkedList(); // custom circular Linked list
                cl.insert(1);
                cl.insert(2);
                cl.insert(3);
                cl.insert(4);
                cl.insert(5);
                cl.display();
                cl.delete(3);
                cl.display();

                System.out.println("============================== question ==================================");
                list.removeDuplicate(); // leetcode 83

                linkedList_class l = list.merge(list, list2); // leetcode 21
                l.display();

                System.out.println("is cycle present_ll : " + list.hasCycle(list)); // leetcode 141
                System.out.println("is cycle present_cl : " + cl.hasCycle(cl));

                System.out.println("Length of cycle element : " + cl.CycleElementCount(cl));
                System.out.println("cycle start at Node(value) : " + cl.CycleStartAtNode(cl)); // leetcode 142
                System.out.println("cycle start at index : " + cl.CycleStartAtIndex(cl));

                System.out.println("is happy : " + cl.isHappy(3)); // leetcode 202

                System.out.println("middle of linked list(value) : " + list.middleNode(list)); // leetcode 876

                list.sortListBubble(); // leetcode 148
                list.display();

                linkedList_class ans = list.addTwoNumbers(list, list2); // leetcode 2
                ans.display();

                list.reverseList2(list).display(); // leetcode 206
                linkedList_class ll = list.reverseList1(list2);
                ll.display();

                list.reverseBetween(list, 2, 4).display(); // leetcode 92

                System.out.println(list.isPalindrome2(list2)); // leetcode 234

                list.reorderList(list); // leetcode 143

                list.reverseKGroup(list, 3).display(); // leetcode 25

                list.rotateRight(list, 2).display(); // leetcode 61

                list.reverseAlternateKGroup(list, 3).display(); // gfg question
        }
}