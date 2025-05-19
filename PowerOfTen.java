public class PowerOfTen {
    public static boolean isPowerOfTen(int n) {
        if (n <= 0) return false;
        while (n % 10 == 0) {
            n /= 10;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTen(1));      // true (10^0)
        System.out.println(isPowerOfTen(10));     // true (10^1)
        System.out.println(isPowerOfTen(100));    // true (10^2)
        System.out.println(isPowerOfTen(1000));   // true (10^3)
        System.out.println(isPowerOfTen(50));     // false
        System.out.println(isPowerOfTen(0));      // false
        System.out.println(isPowerOfTen(-10));    // false
    }
}
