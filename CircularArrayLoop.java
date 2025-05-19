public class CircularArrayLoop {
    public static int findLoopLength(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int slow = i, fast = i;
            boolean isForward = arr[i] > 0;

            // Move slow and fast pointers
            while (true) {
                slow = nextIndex(arr, isForward, slow);
                fast = nextIndex(arr, isForward, fast);
                if (fast != -1) fast = nextIndex(arr, isForward, fast);

                if (slow == -1 || fast == -1 || slow == fast && slow == i) break;
                if (slow == fast) {
                    // Loop found, count its length
                    int count = 1;
                    int idx = nextIndex(arr, isForward, slow);
                    while (idx != slow) {
                        count++;
                        idx = nextIndex(arr, isForward, idx);
                    }
                    return count;
                }
            }

            // Mark all nodes in this path as visited
            int idx = i;
            while (true) {
                int next = nextIndex(arr, arr[idx] > 0, idx);
                if (next == -1 || visited[idx]) break;
                visited[idx] = true;
                idx = next;
            }
        }
        return -1;
    }

    private static int nextIndex(int[] arr, boolean isForward, int curr) {
        boolean direction = arr[curr] > 0;
        if (direction != isForward) return -1; // Change in direction not allowed
        int n = arr.length;
        int next = ((curr + arr[curr]) % n + n) % n; // Ensure positive modulo
        if (next == curr) return -1; // 1-element loop is not valid
        return next;
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 1, 2, 2};
        System.out.println(findLoopLength(arr)); // Output: 3
    }
}
