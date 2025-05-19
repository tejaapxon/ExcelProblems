public class MaxPathSumMatrix {
    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        // Initialize the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int leftDiagonal = (j > 0) ? dp[i - 1][j - 1] : Integer.MIN_VALUE;
                int rightDiagonal = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MIN_VALUE;
                dp[i][j] = matrix[i][j] + Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row
        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            maxSum = Math.max(maxSum, dp[m - 1][j]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 10, 2, 0, 20, 4},
            {1, 0, 0, 30, 2, 5},
            {0, 10, 4, 0, 2, 0},
            {1, 0, 2, 20, 0, 4}
        };
        System.out.println(getMaxPathSum(matrix)); // Output: 74
    }
}
