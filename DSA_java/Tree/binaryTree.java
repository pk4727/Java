package Tree;

import java.util.Scanner;

public class binaryTree {
    public binaryTree() {
    }

    public static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner sc) { // insert elements
        System.out.print("Enter root node : ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.print("Do yo want to enter in left of " + node.value + " : ");
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.print("Enter left value of " + node.value + " : ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }
        System.out.print("Do yo want to enter in right of " + node.value + " : ");
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.print("Enter right value of " + node.value + " : ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    public void display() {
        displayHelper(root, " ");
        System.out.println("--------------- OR ---------------");
        displayNice(root, 0);
    }

    private void displayHelper(Node node, String indention) {
        if (node == null) {
            return;
        }
        System.out.println(indention + node.value);
        displayHelper(node.left, indention + '\t');
        displayHelper(node.right, indention + '\t');
    }

    private void displayNice(Node node, int level) {
        if (node == null) {
            return;
        }
        displayNice(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|--->" + node.value);
        } else {
            System.out.println(node.value);
        }
        displayNice(node.left, level + 1);
    }
}
