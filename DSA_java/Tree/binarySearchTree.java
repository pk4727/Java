package Tree;

public class binarySearchTree {
    public binarySearchTree() {
    }

    public static class Node {
        protected final int value;
        protected Node left;
        protected Node right;
        protected int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    protected Node root;

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insertHelper(value, root);
    }

    protected Node insertHelper(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertHelper(value, node.left);
        }
        if (value > node.value) {
            node.right = insertHelper(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populateBST(int[] list) {
        for (Integer i : list) {
            insert(i);
        }
    }

    public void sortedPopulateBST(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        insert(list[mid]);
        sortedPopulateBST(list, start, mid);
        sortedPopulateBST(list, mid + 1, end);
    }

    public boolean balanced() {
        return balancedHelper(root);
    }

    private boolean balancedHelper(Node node) {
        if (node == null) {
            return true;
        }
        boolean left = balancedHelper(node.left);
        boolean right = balancedHelper(node.right);
        return Math.abs(height(node.left) - height(node.right)) <= 1 && left && right;
    }

    public void preOrder() { // N -> L -> R
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void inOrder() { // L -> N -> R
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.left);
        System.out.print(node.value + " ");
        inOrderHelper(node.right);
    }

    public void postOrder() { // L -> R -> N
        postOrderHelper(root);
    }

    private void postOrderHelper(Node node) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.print(node.value + " ");
    }

    public void display() {
        displayHelper(this.root, "Root Node: ");
    }

    private void displayHelper(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        displayHelper(node.left, "Left child of " + node.value + " : ");
        displayHelper(node.right, "Right child of " + node.value + " : ");
    }
}
