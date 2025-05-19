public class SmallestMissingInteger {
    public static int findSmallestMissing(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 1, 3, 4};
        int[] arr3 = {0, 1, 2, 3, 4}; // All present, should return 5

        System.out.println(findSmallestMissing(arr1)); // Output: 0
        System.out.println(findSmallestMissing(arr2)); // Output: 2
        System.out.println(findSmallestMissing(arr3)); // Output: 5
    }
}
