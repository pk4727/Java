package Tree;

import java.util.*;

public class treeQuestion {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private Node Nroot;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (node.val > value) {
            node.left = insert(node.left, value);
        }
        if (node.val < value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void displayNestedList(List<List<Integer>> nestedlist) {
        for (List<Integer> list : nestedlist) {
            System.out.println(list);
        }
    }
    // ================================= BFS ======================================
    // ================================= BFS ======================================
    // ================================= BFS ======================================
    // ================================= BFS ======================================
    // ================================= BFS ======================================
    // ================================= BFS ======================================

    public List<List<Integer>> levelOrder() {
        return levelOrder(root);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNode = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevelNode.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(currentLevelNode);
        }
        return ans;
    }

    public List<Double> averageOfLevels() {
        return averageOfLevels(root);
    }

    private List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(sum / levelSize);
        }
        return ans;
    }

    public int findSuccessor(int value) {
        return findSuccessor(root, value);
    }

    private int findSuccessor(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
            if (current.val == value) {
                break;
            }
        }
        assert queue.peek() != null;// optional
        return queue.peek().val;
    }

    public List<List<Integer>> zigzagLevelOrder() {
        return zigzagLevelOrder(root);
    }

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNode = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                if (!rev) {
                    TreeNode current = queue.pollFirst();
                    currentLevelNode.add(current.val);
                    if (current.left != null) {
                        queue.addLast(current.left);
                    }
                    if (current.right != null) {
                        queue.addLast(current.right);
                    }
                } else {
                    TreeNode current = queue.pollLast();
                    currentLevelNode.add(current.val);
                    if (current.right != null) {
                        queue.addFirst(current.right);
                    }
                    if (current.left != null) {
                        queue.addFirst(current.left);
                    }
                }
            }
            rev = !rev;
            ans.add(currentLevelNode);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderBottom() {
        return levelOrderBottom(root);
    }

    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNode = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevelNode.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // ans.addFirst(currentLevelNode); // this
            ans.add(0, currentLevelNode); // or this
        }
        return ans;
    }

    public Node connect() {
        return connect(Nroot);
    }

    private Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public List<Integer> rightSideView() {
        return rightSideView(root);
    }

    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (i == levelSize - 1) {
                    ans.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        return ans;
    }

    public boolean isCousins(int x, int y) {
        return isCousins(root, x, y);
    }

    private boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        // recursion
        TreeNode n = findNode(node.left, x); // left
        if (n != null) {
            return n;
        }
        return findNode(node.right, x); // right
    }

    private int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) {
            return 0;
        }
        if (node == x) {
            return lev;
        }
        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y)
                || isSibling(node.right, x, y));
    }

    public boolean isSymmetric() {
        return isSymmetric(root);
    }

    private boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSameTree() {
        return isSameTree(root, root);
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return (isSameTree(node1.right, node2.right) && isSameTree(node1.left, node2.left));
    }

    public boolean findTarget(int k) {
        HashSet<Integer> h = new HashSet<>();
        return findTarget(root, k, h);
    }

    public boolean findTarget(TreeNode root, int k, HashSet<Integer> h) {
        if (root == null) {
            return false;
        }
        if (h.contains(k - root.val)) {
            return true;
        }
        h.add(root.val);
        return findTarget(root.left, k, h) || findTarget(root.right, k, h);
    }

    public boolean isEvenOddTree() {
        return isEvenOddTree(root);
    }

    public boolean isEvenOddTree(TreeNode root) {
        boolean ans = true;
        boolean odd = true;
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelNode = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevelNode.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            for (int i = 0; i < currentLevelNode.size(); i++) {
                if (odd) {
                    if (currentLevelNode.get(i) % 2 == 0
                            || (i > 0 && currentLevelNode.get(i) <= currentLevelNode.get(i - 1))) {
                        return false;
                    }
                } else {
                    if (currentLevelNode.get(i) % 2 != 0
                            || (i > 0 && currentLevelNode.get(i) >= currentLevelNode.get(i - 1))) {
                        return false;
                    }
                }
            }
            odd = !odd;
        }
        return ans;
    }
    // ================================= DFS ======================================
    // ================================= DFS ======================================
    // ================================= DFS ======================================
    // ================================= DFS ======================================
    // ================================= DFS ======================================
    // ================================= DFS ======================================

    public int diameterOfBinaryTree() {
        height(root); // this set max dia
        return max_dia;
    }

    int max_dia;

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        int dia = left + right; // dia = sum of both side height
        max_dia = Math.max(max_dia, dia);
        return Math.max(left, right) + 1;
    }

    public void invertTree() {
        invertTree(root);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right; // swapping node from right to left
        root.right = temp; // swapping node from left to right
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    public int maxDepth() {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int ans) {
        if (node == null) {
            return ans;
        }
        return Math.max(maxDepth(node.left, ans + 1), maxDepth(node.right, ans + 1));
    }

    public TreeNode CreateBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBST(nums, start, mid - 1);
        root.right = CreateBST(nums, mid + 1, end);
        return root;
    }

    public void flatten2() {
        display(createLinkedList(root));
    }

    public void display(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " -> ");
        display(node.left);
        display(node.right);
    }

    Deque<TreeNode> preorderQ = new LinkedList<>();

    private TreeNode createLinkedList(TreeNode node) {
        preorder(node);
        if (!preorderQ.isEmpty()) {
            TreeNode root = preorderQ.pollFirst();
            TreeNode temp = root;
            while (!preorderQ.isEmpty()) {
                temp.right = preorderQ.pollFirst();
                temp.left = null;
                temp = temp.right;
            }
        }
        return root;
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }
        preorderQ.add(node);
        preorder(node.left);
        preorder(node.right);
    }

    public void flatten() {
        display(flatten(root));
    }

    private TreeNode flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) { // check for all right node till null
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) { // go to rightmost of temp node
                    temp = temp.right;
                }
                temp.right = current.right; // rightmost.right = current node.right
                current.right = current.left; // current node.right = current node.left;
                current.left = null; // current node.left = null
            }
            current = current.right;
        }
        return root;
    }

    public boolean isValidBST() {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        } // set min and max value range for that node
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public int lowestCommonAncestor() { // leetcode 236
        return lowestCommonAncestor(root, root.left.left, root.left.right).val;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public int kthSmallest(int k) {
        System.out.println(kthSmallest2(k)); // less efficient
        return kthSmallest(root, k).val; // efficient
    }

    private int kthSmallest2(int k) {
        Deque<Integer> ele = new ArrayDeque<>();
        elements(root, ele);
        int ans = 0;
        while (k > 0) {
            ans = ele.pollFirst();
            k--;
        }
        return ans;
    }

    private void elements(TreeNode node, Deque<Integer> ele) {
        if (node == null) {
            return;
        }
        elements(node.left, ele);
        ele.add(node.val);
        elements(node.right, ele);
    }

    int count = 0;

    private TreeNode kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = kthSmallest(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return kthSmallest(root.right, k);
    }

    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) { // search in inorder for left/right of val
            if (inorder[i] == root) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(root); // root then next left and right
        node.left = buildTreePreIn(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTreePreIn(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    public TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        if (postorder.length == 0) {
            return null;
        }
        int root = postorder[postorder.length - 1];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) { // search in inorder for left/right of root
            if (inorder[i] == root) {
                index = i;
            }
        }
        TreeNode node = new TreeNode(root); // left/right then next root
        int[] arr = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int s = postorder.length - (arr.length + 1);
        node.left = buildTreePostIn(Arrays.copyOfRange(postorder, 0, s), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTreePostIn(Arrays.copyOfRange(postorder, s, postorder.length - 1), arr);
        return node;
    }

    public String serialize() {
        serialize(root);
        return serialize;
    }

    String serialize = "";

    private void serialize(TreeNode root) {
        boolean left = true;
        if (root == null) {
            left = false;
            serialize += "null ";
            return;
        }
        serialize += root.val + " ";
        serialize(root.left);
        serialize(root.right);
    }

    public TreeNode deserialize() {
        serialize(root);
        String[] sa = serialize.split("\\s");
        return deserialize(sa);
    }

    private TreeNode deserialize(String[] s) {
        if (s.length == 0) {
            return null;
        }
        String val = s[0];
        boolean left = true;
        if (val.equals("null")) {
            left = !left;
            return deserialize(Arrays.copyOfRange(s, 1, s.length));
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        if (left) {
            node.left = deserialize(Arrays.copyOfRange(s, 1, s.length));
        } else {
            node.right = deserialize(Arrays.copyOfRange(s, 1, s.length));
        }
        return node;
    }

    public boolean hasPathSum(int targetSum) {
        return hasPathSum(root, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public int sumNumbers() {
        sumNumbers(root, "");
        System.out.println(total);
        return sumNumbers(root, 0);
    }

    int total = 0;

    private void sumNumbers(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null) {
            total += Integer.valueOf(s);
        }
        sumNumbers(root.left, s);
        sumNumbers(root.right, s);
    }

    private int sumNumbers(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        s = s * 10 + root.val;
        if (root.left == null && root.right == null) {
            return s;
        }
        return sumNumbers(root.left, s) + sumNumbers(root.right, s);
    }

    public int maxPathSum() { // doubt
        return maxPathSum(root);
    }

    int ans = 0;

    private int maxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSum(node.left);
        int right = maxPathSum(node.right);
        left = Math.max(0, left); // if negative then skip
        right = Math.max(0, right); // if negative then skip
        int pathSum = left + right + node.val; // path from left to right node
        ans = Math.max(ans, pathSum);
        return Math.max(left, right) + node.val;
    }

    public int findBottomLeftValue() {
        la = root.val;
        if (root.left == null) {
            if (root.right != null) {
                findBottomLeftValue(root, 0);
                return la;
            }
            return la;
        }
        findBottomLeftValue(root, 0);
        return la;
    }

    int la;
    int ph = 0;

    private void findBottomLeftValue(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (ph < height) {
                la = root.val;
                ph = height;
            }
        }
        findBottomLeftValue(root.left, height + 1);
        findBottomLeftValue(root.right, height + 1);
    }

    // ------------------------------------------------------------
    public void DisplayDFSbyStack() {
        DisplayDFSbyStack(root);
    }

    private void DisplayDFSbyStack(TreeNode node) {
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        if (root == null) {
            return;
        }
        while (!s.isEmpty()) {
            TreeNode top = s.pop();
            System.out.print(top.val + " -> ");
            if (top.right != null) {
                s.push(top.right);
            }
            if (top.left != null) {
                s.push(top.left);
            }
        }
    }

    // -----------------Tree to Doubly linked list---------------------
    listNode head;
    listNode tail;

    static class listNode {
        int value;
        listNode next;
        listNode prev;

        public listNode(int value) {
            this.value = value;
        }
    }

    public void BSTtoDLL() { // main function
        displayDDL(BSTtoDLL(root));
    }

    private listNode BSTtoDLL(TreeNode node) {
        if (node == null) {
            return head;
        }
        BSTtoDLL(node.left); // left recursion
        listNode newNode = new listNode(node.val); // node for current node of tree
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        BSTtoDLL(node.right); // right recursion
        return head;
    }

    private void displayDDL(listNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.value + " <---> ");
            head = head.next;
        }
    }

    public void twoNodeSwapped() {
        twoNodeSwapped(root);
        int temp = s.val;
        s.val = f.val;
        f.val = temp;
    }

    TreeNode f = new TreeNode();
    TreeNode s = new TreeNode();
    TreeNode prev = new TreeNode();

    private void twoNodeSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        twoNodeSwapped(root.left);
        if (prev != null && prev.val > root.val) {
            if (f == null) {
                f = prev;
            }
            s = root;
        }
        prev = root;
        twoNodeSwapped(root.right);
    }
    // ==================================== Hash map used =====================

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for (int index = 0; index < inOrder.length; index++) {
            inOrderIndex.put(inOrder[index], index);
        }
        int[] index = { 0 };
        return buildTree(preOrder, inOrder, 0, preOrder.length - 1, inOrderIndex, index);
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder, int left, int right,
            HashMap<Integer, Integer> inOrderIndex, int[] index) {
        if (left > right) { // array is empty
            return null;
        }
        int current = preOrder[index[0]]; // root node
        index[0]++;
        TreeNode node = new TreeNode(current);
        if (left == right) { // at leaf node
            return node;
        }
        int inIndex = inOrderIndex.get(current); // in inorder root node at index this
        node.left = buildTree(preOrder, inOrder, left, inIndex - 1, inOrderIndex, index);
        node.right = buildTree(preOrder, inOrder, inIndex + 1, right, inOrderIndex, index);
        return node;
    }

    public List<List<Integer>> verticalTraversal() {
        return verticalTraversal(root);
    }

    private List<List<Integer>> verticalTraversal(TreeNode node) { // return column wise node
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); // nested list for ans
        if (node == null) { // if empty return [[]]
            return ans;
        }
        Deque<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>(); // for storing entry of (node,col) queue
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); // for storing (col, list(node at that column) heap
        int col = 0; // at root
        queue.offer(new AbstractMap.SimpleEntry<>(node, col)); // add root node in queue
        int min = 0; // min column value
        int max = 0; // max column value
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = queue.poll(); // remove entry from queue
            node = current.getKey(); // node value
            col = current.getValue(); // column value
            if (node != null) {
                if (!map.containsKey(col)) { // column not in heap
                    map.put(col, new ArrayList<>()); // create column
                }
                map.get(col).add(node.val); // first find col in heap then add value in corresponding list
                min = Math.min(min, col); // min of current and previous column
                max = Math.max(max, col); // max of current and previous column
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col - 1)); // left recursion
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col + 1)); // right recursion
            }
        }
        for (int i = min; i < max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    public void printTree() {
        printTree(root);
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }

}

class run {
    public static void main(String[] args) {
        treeQuestion tq = new treeQuestion();
        // - - - - - - - - 8
        // - - - 4 - - - - -- - - - 12
        // - 2 - -- - 6 - -- - 10 - -- - 14
        // 1 - 3 -- 5 - 7 -- 9 - 11 -- 13 - 15
        int[] arr = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };
        for (int i : arr) {
            tq.insert(i);
        }

        // tq.DisplayDFSbyStack();
        // tq.BSTtoDLL();
        // tq.twoNodeSwapped(); // not run here
        // tq.display(tq.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15,
        // 20, 7 })); // l 105
        // tq.displayNestedList(tq.verticalTraversal()); // l 987
        // tq.printTree(); // inorder

        // System.out.println("\n=========== BFS ============");
        // tq.displayNestedList(tq.levelOrder()); // leetcode 102
        // System.out.println(tq.averageOfLevels()); // leetcode 637
        // System.out.println(tq.findSuccessor(5)); // optional
        // tq.displayNestedList(tq.zigzagLevelOrder()); // leetcode 103
        // tq.displayNestedList(tq.levelOrderBottom()); // leetcode 107
        // tq.connect(); // leetcode 116
        // System.out.println(tq.rightSideView()); // leetcode 199
        // System.out.println(tq.isCousins(7, 9)); // leetcode 993
        // System.out.println(tq.isSymmetric());// leetcode 101
        // System.out.println(tq.isSameTree()); // leetcode 100
        // System.out.println(tq.findTarget(23)); // leetcode 653
//        System.out.println(tq.isEvenOddTree()); // leetcode 1609
        //
        // System.out.println("\n=========== DFS ============");
        // System.out.println(tq.diameterOfBinaryTree()); // leetcode 543
        // tq.invertTree(); // leetcode 226
        // System.out.println(tq.maxDepth()); // leetcode 104
        // tq.CreateBST(new int[] { -10, -3, 0, 5, 9 }); // leetcode 108
        // tq.flatten2(); // leetcode 114 ( run individually )
        // tq.flatten(); // ( run individually )
        // System.out.println(tq.isValidBST()); // leetcode 98
        // System.out.println(tq.lowestCommonAncestor()); // leetcode 236
        // System.out.println(tq.kthSmallest(5)); // leetcode 230
        // tq.display(tq.buildTreePreIn(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3,
        // 15, 20, 7 })); // leetcode 105
        // tq.display(tq.buildTreePostIn(new int[] { 9, 15, 7, 20, 3 }, new int[] { 9,
        // 3, 15, 20, 7 }));
        // tq.display(tq.deserialize()); // leetcode 297
        // System.out.println(tq.hasPathSum(48)); // leetcode 112
        // System.out.println(tq.sumNumbers()); // leetcode 129
        // System.out.println(tq.maxPathSum()); // leetcode 124
        // System.out.println(tq.findBottomLeftValue()); leetcode 513
    }
}