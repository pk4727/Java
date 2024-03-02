import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class halfManCoding {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private halfManCoding(String feeder) throws Exception {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char ch = feeder.charAt(i);
            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
                // int originalValue = frequencyMap.get(ch);
                // originalValue++;
                // frequencyMap.put(ch,originalValue);
            } else {
                frequencyMap.put(ch, 1);
            }
        }
        Heap<Node> minHip = new Heap<>();
        Set<Map.Entry<Character, Integer>> entryset = frequencyMap.entrySet(); // gives all set of frequency map
        for (Map.Entry<Character, Integer> entry : entryset) {
            Node node = new Node(entry.getKey(), entry.getValue()); // create node from frequency map key value pair
            minHip.insert(node);
        }
        while (minHip.size() != 1) {
            Node first = minHip.remove(); // remove first smallest node
            Node second = minHip.remove(); // remove second smallest node
            Node newNode = new Node('\0', first.cost + second.cost); // create new node with cost sum
            newNode.left = first; // set left is first node
            newNode.right = second; // set right is second node
            minHip.insert(newNode); // insert new node in minHip
        }
        Node fullTree = minHip.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        this.createEncoderDecoder(fullTree, "");
    }

    private void createEncoderDecoder(Node node, String s) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, s);
            this.decoder.put(s, node.data);
        }
        createEncoderDecoder(node.left, s + "0");
        createEncoderDecoder(node.right, s + "1");
    }

    public String encoder(String source) {
//        String ans = "";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
//            ans = ans + encoder.get(source.charAt(i));
            ans.append(encoder.get(source.charAt(i))); // search value in encoder table for every char and add it
        }
        return ans.toString();
    }

    public String decoder(String codedString) {
        StringBuilder ansCode = new StringBuilder();
        String key = "";
        for (int i = 0; i < codedString.length(); i++) {
            key = key + codedString.charAt(i);
            if (decoder.containsKey(key)) {
                ansCode.append(decoder.get(key));
                key = "";
            }
        }
        return ansCode.toString();
    }

    private static class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        String s = "abbccda";
        halfManCoding hfc = new halfManCoding(s);
        String encoded = hfc.encoder(s);
        System.out.println("Encoded string : " + encoded);
        String decoded = hfc.decoder(encoded);
        System.out.println("Decoded string : " + decoded);
    }
}
