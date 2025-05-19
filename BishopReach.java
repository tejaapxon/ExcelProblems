public class BishopReach {
    public static String bishopMove(int bx, int by, int tx, int ty) {
        // Check if both positions are on the same color
        if ((bx + by) % 2 != (tx + ty) % 2) {
            return "NO";
        }
        // Same position
        if (bx == tx && by == ty) {
            return "YES\n0";
        }
        // Same diagonal
        if (Math.abs(bx - tx) == Math.abs(by - ty)) {
            return "YES\n1";
        }
        // Reachable in two moves
        return "YES\n2";
    }

    public static void main(String[] args) {
        // Example 1: Bishop at (1, 1), target at (3, 3)
        System.out.println(bishopMove(1, 1, 3, 3)); // YES 1

        // Example 2: Bishop at (1, 1), target at (4, 2)
        System.out.println(bishopMove(1, 1, 4, 2)); // NO

        // Example 3: Bishop at (1, 1), target at (5, 3)
        System.out.println(bishopMove(1, 1, 5, 3)); // YES 2
    }
}
