import java.util.Arrays;

public class WaveFormSort {
    public static void waveSort(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array
        for (int i = 0; i < arr.length - 1; i += 2) {
            // Step 2: Swap adjacent elements
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 6, 3, 2, 20, 100, 80};
        waveSort(arr);
        System.out.println(Arrays.toString(arr));
        // Output: [5, 2, 6, 3, 20, 10, 100, 80] or any valid wave form
    }
}
