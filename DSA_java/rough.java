import java.util.*;

class rough {// l 125
    public static void main(String[] args) throws Exception {
        // String beginWord = "hit", endWord = "cog";
        // String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" },
        // wordList2 = { "hot", "dot", "dog", "lot", "log" };
        // System.out.println(ladderLength2(beginWord, endWord,
        // Arrays.stream(wordList).toList()));
        int[] nums = {-4,-1,0,3,10,2};
        sortedSquares(new int[]{-7,-3,2,3,11});
        List<Integer> a = new ArrayList<>();
        a.add(8);
        a.remove(0);
        HashSet<Integer> h = new HashSet<>();
        h.add(8);
        for (int i:h) {
            System.out.println(i);

        }

    }
    public static void sortedSquares(int[] nums) throws Exception {
        PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
        for (int i: nums){
            ans.add(i*i);
        }
        int index = 0;
        while(ans.size()!=0){
            nums[index] = ans.remove();
            index++;
        }
        System.out.println(Arrays.toString(nums));
    }
    //
    // // https://leetcode.com/problems/word-ladder/description/
    // public static int ladderLength2(String beginWord, String endWord,
    // List<String> wordList) { // leetcode 127
    // Set<String> set = new HashSet<>(wordList);
    // set.remove(beginWord);
    // Queue<Map.Entry<String, Integer>> q = new LinkedList<>();
    // q.add(new AbstractMap.SimpleEntry<>(beginWord, 1));
    // while (!q.isEmpty()) {
    // Map.Entry<String, Integer> c = q.poll();
    // String word = c.getKey();
    // int step = c.getValue();
    // if (word.equals(endWord)) {
    // return step;
    // }
    // for (int i = 0; i < word.length(); i++) {
    // for (char ch = 'a'; ch <= 'z'; ch++) {
    // char[] oldwordArray = word.toCharArray();
    // oldwordArray[i] = ch;
    // String newWord = new String(oldwordArray);
    // if (set.contains(newWord)) {
    // set.remove(newWord); // Prevent revisiting
    // q.add(new AbstractMap.SimpleEntry<>(newWord, step + 1));
    // }
    // }
    // }
    // }
    // return 0;
    // }
    //
    // static class Pair {
    // // Pair class to store a word and its corresponding step count
    // String first;
    // int second;
    //
    // Pair(String first, int second) {
    // this.first = first;
    // this.second = second;
    // }
    // }
    //
    // public static int ladderLength(String beginWord, String endWord, List<String>
    // wordList) {
    // // Store words from wordList for efficient lookups and to avoid cycles
    // Set<String> set = new HashSet<>(wordList);
    // // Remove beginWord from the set to prevent unnecessary exploration
    // set.remove(beginWord);
    // // Queue for BFS traversal, storing pairs of (word, step count)
    // Queue<Pair> q = new LinkedList<>();
    // // Initialize BFS with beginWord and step count 1
    // q.add(new Pair(beginWord, 1));
    // while (!q.isEmpty()) {
    // // Dequeue the current word and its step count
    // String word = q.peek().first;
    // int step = q.peek().second;
    // q.remove();
    // // Check if we've reached the endWord
    // if (word.equals(endWord)) {
    // return step; // Found the shortest transformation sequence
    // }
    // // Generate possible transformations of the current word
    // for (int i = 0; i < word.length(); i++) {
    // for (char ch = 'a'; ch <= 'z'; ch++) {
    // // Create a new word by replacing the character at index i with ch
    // char[] oldwordArray = word.toCharArray();
    // oldwordArray[i] = ch;
    // String newWord = new String(oldwordArray);
    // // Check if the new word is in the set
    // if (set.contains(newWord)) {
    // // Add the new word to the queue with an incremented step count
    // set.remove(newWord); // Prevent revisiting
    // q.add(new Pair(newWord, step + 1));
    // }
    // }
    // }
    // }
    // return 0;
    // }
    //
    // https://leetcode.com/problems/group-anagrams/description/
    // class Solution { // l_49
    // public List<List<String>> groupAnagrams(String[] s) {
    // Map<String, List<String>> map = new HashMap<>();
    //
    // for (String word : s) {
    // char[] chars = word.toCharArray();
    // Arrays.sort(chars);
    // String sortedWord = new String(chars);
    //
    // if (!map.containsKey(sortedWord)) {
    // map.put(sortedWord, new ArrayList<>());
    // }
    //
    // map.get(sortedWord).add(word);
    // }
    //
    // return new ArrayList<>(map.values());
    // }
    // }
    //
    // https://leetcode.com/problems/furthest-building-you-can-reach/submissions/1177802381?envType=daily-question&envId=2024-02-17
    // public static int furthestBuilding(int[] heights, int bricks, int ladders) {
    // // l_1642
    // PriorityQueue<Integer> heap = new PriorityQueue<>();
    // for (int i = 0; i < heights.length - 1; i++) {
    // int diff = heights[i + 1] - heights[i];
    // if (diff > 0) {
    // heap.offer(diff);
    // if (heap.size() > ladders) {
    // bricks -= heap.poll();
    // }
    // if (bricks < 0) {
    // return i;
    // }
    // }
    // }
    // return heights.length - 1;
    // }
    //
    // https://leetcode.com/problems/meeting-rooms-iii/submissions/1178915292/
    // public int mostBooked(int n, int[][] meetings) { // l_2402
    // Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]); // sort rooms by start time
    // // key: int[end time, room number]
    // // sort by end time, if the same end time - sort by lowest room number
    // PriorityQueue<int[]> scheduler = new PriorityQueue<>((m1, m2) -> m1[0] ==
    // m2[0] ? m1[1] - m2[1] : m1[0] - m2[0]);
    // PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
    // for (int i = 0; i < n; i++) {
    // availableRooms.add(i); // add all rooms to availability
    // }
    // int[] roomUsageCount = new int[n];
    // for (int[] meeting : meetings) {
    // int currMeetingStartTime = meeting[0];
    // while (!scheduler.isEmpty() && currMeetingStartTime >= scheduler.peek()[0]) {
    // // empty past meetings
    // availableRooms.add(scheduler.remove()[1]); // add freed room to availability
    // }
    // int delay = 0;
    // if (availableRooms.size() == 0) { // all rooms are full
    // int[] endedMeeting = scheduler.remove();
    // delay = endedMeeting[0] - currMeetingStartTime; // add delay
    // availableRooms.add(endedMeeting[1]); // add free room back to availability
    // }
    // int currMeetingEndTime = meeting[1] + delay;
    // int availableRoom = availableRooms.remove(); // get lowest available room
    // scheduler.add(new int[] { currMeetingEndTime, availableRoom }); // add
    // current
    // meeting
    // roomUsageCount[availableRoom]++;
    // }
    // // find the most used room
    // int maxUsedRoom = 0;
    // int maxUsage = 0;
    // for (int i = 0; i < n; i++) {
    // if (roomUsageCount[i] > maxUsage) {
    // maxUsage = roomUsageCount[i];
    // maxUsedRoom = i;
    // }
    // }
    // return maxUsedRoom;
    // }
}