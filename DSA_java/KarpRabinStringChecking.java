public class KarpRabinStringChecking {
    public static void main(String[] args) {
        KarpRabinStringChecking k = new KarpRabinStringChecking();
        k.stringMatching("pradhuman kumar", "man"); // O(mn)
        k.StringMatching1("pradhuman kumar", "man"); // O(n)
        k.StringMatching2("pradhuman kumar", "man"); // O(n)
    }

    private final int prime = 101;

    public void stringMatching(String text, String pattern) { // time complexity is O(mn) and comparisons is O(n+m)
        int patternLength = pattern.length();
        double patternHashValue = calculateHashValue(pattern); // pattern hash value
        double textHashValue = calculateHashValue(text.substring(0, patternLength)); // current text hash value
        for (int i = 0; i < text.length() - patternLength; i++) { // changing prevChar and nextChar and checking
            if (textHashValue == patternHashValue) { // if found then
                System.out.println("Pattern found at index : " + i);
            }
            if (i < text.length() - patternLength) { // if not found then check nextChar is in text or not if yes then
                textHashValue = updateHashValue(text.charAt(i), text.charAt(i + patternLength), textHashValue,
                        patternLength);
            }
        }
    }

    public double calculateHashValue(String s) {
        double hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += (s.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    public double updateHashValue(char prevChar, char nextChar, double oldHashValue, int patternLength) {
        double newHashValue = (oldHashValue - prevChar) / prime;
        newHashValue = newHashValue + (nextChar * Math.pow(prime, patternLength - 1));
        return newHashValue;
    }

    public void StringMatching1(String text, String pattern) { // O(n)
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            String currentMatchingText = text.substring(i, i + pattern.length());
            if (currentMatchingText.equals(pattern)) {
                System.out.println("Pattern found at index : " + i);
            }
        }
    }

    public void StringMatching2(String text, String pattern) { // O(n)
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                String currentMatchingText = text.substring(i, i + pattern.length());
                if (currentMatchingText.equals(pattern)) {
                    System.out.println("Pattern found at index : " + i);
                }
            }
        }
    }
}