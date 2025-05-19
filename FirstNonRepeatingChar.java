import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static Character firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Count occurrences of each character
        //loop through each character in the given String str
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            System.out.println(charCountMap);
        }
        //System.out.println(charCountMap);

        // Find the first character with count 1
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println("entry is = " + entry);
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If no non-repeating character found
        return null;
    }

    public static void main(String[] args) {
        String str1 = "112223334445";
        System.out.println("First non-repeating character in '" + str1 + "' is: " + firstNonRepeatingChar(str1));

        String str2 = "abbacd";
        System.out.println("First non-repeating character in '" + str2 + "' is: " + firstNonRepeatingChar(str2));
    }
}
