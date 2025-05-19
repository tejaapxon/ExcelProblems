public class StringCompressor {
    public static String compress(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        // Append the last character and its count
        result.append(s.charAt(s.length() - 1)).append(count);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabbb")); // Output: a2b3
        System.out.println(compress("aaaa"));  // Output: a4
        System.out.println(compress("a"));     // Output: a1
    }
}
