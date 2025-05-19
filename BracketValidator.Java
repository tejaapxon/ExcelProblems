public class BracketValidator {

    public static boolean isValid(String s) {
        int counter = 0;  // Single counter to track the balance of brackets

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));  // Convert char to String
            
            // If it's an opening bracket, increment the counter
            if (currentChar.equals("(") || currentChar.equals("{") || currentChar.equals("[")) {
                counter++;
            }
            // If it's a closing bracket, decrement the counter
            else if (currentChar.equals(")") || currentChar.equals("}") || currentChar.equals("]")) {
                counter--;
                // If counter goes negative, it means there are more closing brackets than opening ones
                if (counter < 0) return false;
            }
        }

        // If the counter is zero, all brackets are matched correctly
        return counter == 0;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}}{}{{"));  // false (invalid)
    }
}
