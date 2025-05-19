public class FinalCoordinates {
    public static int[] getFinalCoordinates(String moves) {
        int x = 0, y = 0;
        String[] tokens = moves.split("\\s+");
        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            int count = 1;
            String direction = token;

            // Handle patterns like "2xRIGHT"
            if (token.matches("\\d+x[A-Z]+")) {
                String[] parts = token.split("x");
                count = Integer.parseInt(parts[0]);
                direction = parts[1];
            }

            for (int i = 0; i < count; i++) {
                switch (direction.toUpperCase()) {
                    case "U":
                    case "UP":
                        y += 1;
                        break;
                    case "D":
                    case "DOWN":
                        y -= 1;
                        break;
                    case "R":
                    case "RIGHT":
                        x += 1;
                        break;
                    case "L":
                    case "LEFT":
                        x -= 1;
                        break;
                }
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        // Test cases
        int[] result1 = getFinalCoordinates("UUU");
        System.out.println("(" + result1[0] + "," + result1[1] + ")"); // (0,3)

        int[] result2 = getFinalCoordinates("URRDDL");
        System.out.println("(" + result2[0] + "," + result2[1] + ")"); // (1,-1)

        int[] result3 = getFinalCoordinates("DOWN UP 2xRIGHT DOWN 3xLEFT");
        System.out.println("(" + result3[0] + "," + result3[1] + ")"); // (-1,-1)
    }
}
