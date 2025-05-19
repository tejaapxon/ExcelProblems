public class LongestSameCharSubstring {
    public static void main(String[] args) {
        String str = "aabbbbCCddd";
        int maxLen = 0, maxStart = 0;
        int currLen = 1, currStart = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currLen++;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxStart = currStart;
                }
                currLen = 1;
                currStart = i;
            }
        }
        // Check last run
        if (currLen > maxLen) {
            maxLen = currLen;
            maxStart = currStart;
        }

        System.out.println("Starting index: " + maxStart);
        System.out.println("Length: " + maxLen);
        System.out.println("Substring: " + str.substring(maxStart, maxStart + maxLen));
    }
}
