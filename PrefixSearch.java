import java.util.ArrayList;
import java.util.List;

public class PrefixSearch {
    public static List<String> wordsWithPrefix(String[] arr, String prefix) {
        List<String> result = new ArrayList<>();
        for (String word : arr) {
            if (word.startsWith(prefix)) { // Checks if word starts with the prefix
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "applet", "bread", "aper"};
        String prefix = "app";
        List<String> matches = wordsWithPrefix(arr, prefix);
        System.out.println(matches); // Output: [apple, applet]
    }
}
