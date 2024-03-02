package Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Segment Tree ===========");
        int[] arr = { 3, 4, 9, 7, 6 };
        segmentTree st = new segmentTree(arr);
        System.out.println("Sum : " + st.query(1, 3));
        st.update(3, 12);
        st.display();

        System.out.println("========== AVL Tree (self balanced) ===========");
        AVL_Tree avl = new AVL_Tree();
        int[] list = new int[10];
        for (int i = 1; i < 10; i++) {
            list[i] = i;
        }
        avl.populate(list);
        System.out.println("is tree balanced : " + avl.balanced());
        System.out.println("Height of tree : " + avl.height());
        avl.display();

        System.out.println("========== BST (sorted) ===========");
        binarySearchTree bstS = new binarySearchTree();
        int[] sList = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        bstS.sortedPopulateBST(sList, 0, sList.length);
        bstS.display();
        System.out.println("is balanced : " + bstS.balanced());
        System.out.print("\n preorder traversal : ");
        bstS.preOrder();
        System.out.print("\n inorder traversal : ");
        bstS.inOrder();
        System.out.print("\n postorder traversal : ");
        bstS.postOrder();

        System.out.println("========== Binary Search Tree ===========");
        binarySearchTree bst = new binarySearchTree();
        int[] list2 = { 15, 9, 16, 10, 2, 8, 17, 5, 12, 25 };
        bst.populateBST(list2);
        bst.display();
        System.out.println("Height of tree : " + bst.height());
        System.out.println("is balanced : " + bst.balanced() + "\n");

        System.out.println("\n\n========== Binary Tree ===========");
        Scanner sc = new Scanner(System.in);
        binaryTree bt = new binaryTree();
        bt.populate(sc);
        bt.display();
    }
}
