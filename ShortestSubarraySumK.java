import java.util.HashMap;

public class ShortestSubarraySumK {
    public static int shortestSubarray(int[] arr, int K) {
        // Map from prefix sum to its earliest index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // For subarrays starting at index 0
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if there is a prefix sum that would make the subarray sum to K
            if (map.containsKey(sum - K)) {
                minLen = Math.min(minLen, i - map.get(sum - K));
            }

            // Only store the first occurrence to ensure shortest length
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 10, 2, 1};
        int K1 = 12;
        System.out.println(shortestSubarray(arr1, K1)); // Output: 2 ([6,6] or [10,2])

        int[] arr2 = {5, 8, 50, 4};
        int K2 = 50;
        System.out.println(shortestSubarray(arr2, K2)); // Output: 1 ([50])
    }
}
