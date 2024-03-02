package Stack_and_Queue;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class QuestionStack_Queue {
    public class MyQueue { // l_232
        private Stack<Integer> first;
        private Stack<Integer> second;

        public MyQueue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        // insertEfficient for push(), pop(), peek()
        public void push(int x) {
            first.push(x);
        }

        public int pop() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int removed = second.pop();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return removed;
        }

        public int peek() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            int peek = second.peek();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return peek;
        }

        public boolean empty() {
            return first.isEmpty();
        }

        // removeEfficient for push(), pop(), peek()
        public void pushRemoveEfficient(int x) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            first.push(x);
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
        }

        public int popRemoveEfficient() {
            return first.pop();
        }

        public int peekRemoveEfficient() {
            return first.peek();
        }
    }

    public class twoStack {
        public int twoStacks(int[] first, int[] second, int max) { // hackerrank question
            int ans = helperTwoStacks(max, first, second, 0, 0);
            return ans - 1;
        }

        public int helperTwoStacks(int max, int[] first, int[] second, int sum, int count) {
            if (max < sum) {
                return count;
            }
            if (first.length == 0 || second.length == 0) {
                return count;
            }
            int ans1 = helperTwoStacks(max, Arrays.copyOfRange(first, 1, first.length), second, sum + first[0],
                    count + 1);
            int ans2 = helperTwoStacks(max, first, Arrays.copyOfRange(second, 1, second.length), sum + second[0],
                    count + 1);
            return Math.max(ans1, ans2);
        }
    }

    public boolean isValid(String s) { // l_20
        Stack<String> st = new Stack<>();
        if (s.isEmpty()) {
            return false;
        }
        st.push("x");
        st.push(s.substring(0, 1));
        s = s.substring(1);
        while (!s.isEmpty()) {
            String temp = s.substring(0, 1);
            if (temp.equals(")") && Objects.equals(st.peek(), "(") && !Objects.equals(st.peek(), "x")) {
                st.pop();
                s = s.substring(1);
            } else if (temp.equals("}") && Objects.equals(st.peek(), "{") && !Objects.equals(st.peek(), "x")) {
                st.pop();
                s = s.substring(1);
            } else if (temp.equals("]") && Objects.equals(st.peek(), "[") && !Objects.equals(st.peek(), "x")) {
                st.pop();
                s = s.substring(1);
            } else {
                st.push(temp);
                s = s.substring(1);
            }
        }
        return Objects.equals(st.peek(), "x");
    }

    public class LargestRectangleArea {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            stack.push(0);
            for (int i = 1; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    max = getMax(heights, stack, max, i);
                }
                stack.push(i);
            }
            int i = heights.length;
            while (!stack.isEmpty()) {
                max = getMax(heights, stack, max, i);
            }
            return max;
        }

        private int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
            int area;
            int popped = stack.pop();
            if (stack.isEmpty()) {
                area = arr[popped] * i;
            } else {
                area = arr[popped] * (i - 1 - stack.peek());
            }
            return Math.max(max, area);
        }

        public int largestRectangleArea1(int[] heights) { // l_84
            if (heights.length == 1) {
                return heights[0];
            }
            int[] prevMin = prevMinIndex(heights);
            int[] nextMin = nextMinIndex(heights);
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                int currentArea = ((nextMin[i] - prevMin[i]) - 1) * heights[i];
                if (area < currentArea) {
                    area = currentArea;
                }
            }
            return area;
        }

        private int[] prevMinIndex(int[] heights) {
            int[] prevMin = new int[heights.length];
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    prevMin[i] = -1;
                } else {
                    prevMin[i] = s.peek();
                }
                s.push(i);
            }
            return prevMin;
        }

        private int[] nextMinIndex(int[] heights) {
            int[] prevMin = new int[heights.length];
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!s.isEmpty() && heights[s.peek()] <= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    prevMin[i] = heights.length;
                } else {
                    prevMin[i] = s.peek();
                }
                s.push(i);
            }
            return prevMin;
        }

        public int largestRectangleArea2(int[] heights) { // time excced
            if (heights.length == 1) {
                return heights[0];
            }
            int[] prevMin = new int[heights.length];
            int[] nextMin = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                prevMin[i] = prevMinIndex(heights, i);
                nextMin[i] = nextMinIndex(heights, i);
            }
            int area = 0;
            for (int i = 0; i < heights.length; i++) {
                int currentArea = ((nextMin[i] - prevMin[i]) - 1) * heights[i];
                if (area < currentArea) {
                    area = currentArea;
                }
            }
            return area;
        }

        private int prevMinIndex(int[] list, int index) {
            int minindex = index;
            for (int i = index; i >= 0; i--) {
                if (list[i] < list[index] && list[i] < list[minindex]) {
                    return i;
                }
            }
            if (list[minindex] == list[index]) {
                minindex = -1;
            }
            return minindex;
        }

        private int nextMinIndex(int[] list, int index) {
            int minindex = index;
            for (int i = index; i < list.length; i++) {
                if (list[i] < list[index] && list[i] < list[minindex]) {
                    return i;
                }
            }
            if (list[minindex] == list[index]) {
                minindex = list.length;
            }
            return minindex;
        }
    }
}

class run {
    public static void main(String[] args) {
        QuestionStack_Queue q = new QuestionStack_Queue();
        QuestionStack_Queue.MyQueue obj = q.new MyQueue(); // leetcode 232
        obj.push(5);
        obj.push(6);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());

        QuestionStack_Queue.twoStack ts = q.new twoStack(); // hackerrank question
        int[] a = { 4, 2, 4, 6, 1 };
        int[] b = { 2, 1, 8, 5 };
        System.out.println("Max element peeked up count : " + ts.twoStacks(a, b, 10));

        System.out.println(q.isValid("()")); // leetcode 20
        System.out.println(q.isValid("()[]{}"));
        System.out.println(q.isValid("(]"));

        QuestionStack_Queue.LargestRectangleArea lr = q.new LargestRectangleArea(); // leetcode 84
        int[] rec = { 2, 1, 5, 6, 2, 3 };
        System.out.println(lr.largestRectangleArea(rec));
        System.out.println(lr.largestRectangleArea1(rec));
        System.out.println(lr.largestRectangleArea2(rec));
    }
}
