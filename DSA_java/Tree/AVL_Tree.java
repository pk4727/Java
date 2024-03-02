package Tree;

public class AVL_Tree { // range of height is -1 to +1
    // 1. Left ----> Left (right rotate P)
    // if this ====> P -----> LC / t1 ----> GLC / t2 ----> t3 / t4
    // then this ==> LC ----> GLC / P ----> (t3/t4) / (t2/t1)

    // 2. Left ----> Right (left rotate LC)
    // if this ====> P ----> LC / t1 -----> t2 / GLC ----> t3 / t4
    // then this ==> P ----> GLC / t1 ----> LC / t4 -----> t2 / t3
    // then apply case(1) Left ----> Left

    // 3. Right ----> Right (left rotate P)
    // if this ====> P -----> t1 / RC ----> t2 / GRC ----> t3 / t4
    // then this ==> RC ----> P / GRC ----> (t1/t2) / (t3/t4)

    // 4. Right ----> Left (right rotate RC)
    // if this ====> P ----> t1 / RC -----> GRC / t2 ----> t3 / t4
    // then this ==> P ----> t1 / GRC ----> t3 / RC -----> t4 / t2
    // then apply case(3) Right ----> Right

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) { // left case
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) { // right case
            if (height(node.right.left) - height(node.right.right) < 0) { //
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightRotate(node);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;
        p.left = c;
        c.right = t;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return p;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    public AVL_Tree() {
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
}