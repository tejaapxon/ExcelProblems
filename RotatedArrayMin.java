public class RotatedArrayMin {
    public static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        // If array is not rotated
        if (arr[left] <= arr[right]) return arr[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
           // System.out.println("mid value is" + mid);
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {6,7,8,4,5};
        System.out.println(findMin(arr1)); // Output: 1
        System.out.println(findMin(arr2)); // Output: 1
        System.out.println(findMin(arr3));
    }
}
