package Tree;

public class segmentTree {
    public static class Node {
        int data;
        int startIndex;
        int endIndex;
        Node left;
        protected Node right;

        public Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    Node root;

    public segmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) { // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end); // internal node
        int mid = (end + start) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(int sIndex, int eIndex) { // query between index
        return query(root, sIndex, eIndex);
    }

    private int query(Node node, int sIndex, int eIndex) {
        if (node.startIndex >= sIndex && node.endIndex <= eIndex) { // full inside
            return node.data;
        } else if (node.startIndex > eIndex || node.endIndex < sIndex) { // full outside
            return 0;
        } else {
            return query(node.left, sIndex, eIndex) + query(node.right, sIndex, eIndex); // partial inside and outside
        }
    }

    public void update(int index, int value) { // update index
        root.data = update(root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (node.startIndex <= index && node.endIndex >= index) { // in range
            if (node.startIndex == index && index == node.endIndex) { // at index
                node.data = value;
                return node.data;
            } else { // go to left and right
                node.data = update(node.left, index, value) + update(node.right, index, value);
                return node.data;
            }
        }
        return node.data;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) { // for left node
            str = str + "( Interval=[" + node.left.startIndex + "-" + node.left.endIndex + "] & data: " + node.left.data
                    + " )   <-- ";
        } else {
            str = str + "No left child   <-- ";
        }
        // for current node
        str = str + "( Interval=[" + node.startIndex + "-" + node.endIndex + "] & data: " + node.data + " ) -->   ";
        if (node.right != null) { // for right node
            str = str + "( Interval=[" + node.right.startIndex + "-" + node.right.endIndex + "] & data: "
                    + node.right.data + " )";
        } else {
            str = str + "No right child ";
        }
        System.out.println(str + '\n');
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }
}
