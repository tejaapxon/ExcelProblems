public class MinWordDistance {
    public static int minDistance(String str, String word1, String word2) {
        String[] words = str.split("\\s+");
        int minDist = Integer.MAX_VALUE;
        System.out.println("minDist = " + minDist);
        int lastPos1 = -1, lastPos2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastPos1 = i;
                if (lastPos2 != -1) {
                    minDist = Math.min(minDist, Math.abs(lastPos1 - lastPos2));
                }
            } else if (words[i].equals(word2)) {
                lastPos2 = i;
                if (lastPos1 != -1) {
                    minDist = Math.min(minDist, Math.abs(lastPos1 - lastPos2));
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    public static void main(String[] args) {
        String str = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";
        System.out.println(minDistance(str, word1, word2)); // Output: 2
    }
}
