public class LongestWordWithSubstring {
    public static int longestWordLengthWithSubstring(String[] dict, String toSearch) {
        int maxLength = 0;
        for (String word : dict) {
            if (word.contains(toSearch)) { // Use .toLowerCase() for case-insensitive
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String[] dict = {"CODGE", "ODG", "LODGES", "SODG", "dodge", "mODJ", "LODGESSSS"};
        String toSearch = "ODG";
        int result = longestWordLengthWithSubstring(dict, toSearch);
        System.out.println(result); // Output: 9
    }
}
