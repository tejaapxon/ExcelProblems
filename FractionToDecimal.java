import java.util.*;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "NaN";
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        
        // Use long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        sb.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return sb.toString();
        
        sb.append(".");
        // Map to store previously seen remainders and their position in result
        Map<Long, Integer> map = new HashMap<>();
        
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // Insert '(' at the index where this remainder was first seen
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));    // Output: 0.5
        System.out.println(fractionToDecimal(1, -2));   // Output: -0.5
        System.out.println(fractionToDecimal(50, 22));  // Output: 2.(27)
        System.out.println(fractionToDecimal(4, 333));  // Output: 0.(012)
        System.out.println(fractionToDecimal(1, 6));    // Output: 0.1(6)
    }
}
