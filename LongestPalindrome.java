public class LongestPalindrome {
    public static String[] longestPalindrome(String s) {
        if (s == null || s.length() < 1) return new String[]{"", "0"};
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd length
            int len2 = expandAroundCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        String palindrome = s.substring(start, end + 1);
        return new String[]{palindrome, String.valueOf(palindrome.length())};
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        String[] res = longestPalindrome(str);
        System.out.println("Longest palindrome: " + res[0]);
        System.out.println("Length: " + res[1]);
    }
}
