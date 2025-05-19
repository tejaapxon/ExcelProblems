public class StaircaseWays {
    public static int countWays(int n) {
        if (n == 0 || n == 1) return 1;
        int prev2 = 1, prev1 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(countWays(2)); // Output: 2 (1+1, 2)
        System.out.println(countWays(3)); // Output: 3 (1+1+1, 1+2, 2+1)
        System.out.println(countWays(5)); // Output: 8
    }
}
