import java.util.*;

public class WordsFromGivenWord {
    public static List<String> findWords(String[] dict, String input) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> inputFreq = new HashMap<>();
        for (char c : input.toCharArray()) {
            inputFreq.put(c, inputFreq.getOrDefault(c, 0) + 1);
        }

        for (String word : dict) {
            if (canForm(word, inputFreq)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean canForm(String word, Map<Character, Integer> inputFreq) {
        Map<Character, Integer> wordFreq = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
            if (inputFreq.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] dict1 = {"ab", "abcd", "bcdaf", "bcad", "acb", "acab"};
        String input1 = "abcd";
        System.out.println(findWords(dict1, input1)); // [abcd, bcad]

        String[] dict2 = {"ab", "abcd", "bcdaf", "bcad", "acaab", "acab"};
        String input2 = "caab";
        System.out.println(findWords(dict2, input2)); // [acab]
    }
}
