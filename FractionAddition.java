public class FractionAddition {
    // Function to compute GCD (Greatest Common Divisor)
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to add two fractions and return [numerator, denominator]
    public static int[] addFractions(int n1, int d1, int n2, int d2) {
        int numerator = n1 * d2 + n2 * d1;
        int denominator = d1 * d2;
        int gcdVal = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcdVal;
        denominator /= gcdVal;
        return new int[]{numerator, denominator};
    }

    public static void main(String[] args) {
        int[] res1 = addFractions(1, 3, 3, 9);
        System.out.println("Result: " + res1[0] + "/" + res1[1]); // Output: 2/3

        int[] res2 = addFractions(1, 2, 3, 2);
        System.out.println("Result: " + res2[0] + "/" + res2[1]); // Output: 2/1
    }
}
