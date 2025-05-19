import java.util.HashMap;
import java.util.Map;

public class HighestAverageMarks {
    public static double highestAverage(String[][] records) {
        // Map: student name -> [total marks, count]
        HashMap<String, int[]> map = new HashMap<>();

        for (String[] entry : records) {
            String name = entry[0];
            int marks = Integer.parseInt(entry[1]);
            map.putIfAbsent(name, new int[2]);
            map.get(name)[0] += marks; // total marks
            map.get(name)[1] += 1;     // count
        }

        double maxAvg = 0;
        String topStudent = "";

        for (Map.Entry<String, int[]> e : map.entrySet()) {
            double avg = (double) e.getValue()[0] / e.getValue()[1];
            if (avg > maxAvg) {
                maxAvg = avg;
                topStudent = e.getKey();
            }
        }

        // Optional: print the student with highest average
        System.out.println("Top student: " + topStudent + " with average: " + maxAvg);

        return maxAvg;
    }

    public static void main(String[] args) {
        String[][] records = {
            {"Charles", "84"},
            {"John", "100"},
            {"Andy", "37"},
            {"John", "23"},
            {"Charles", "20"}
        };
        System.out.println("Highest average: " + highestAverage(records)); // Output: 61.5
    }
}
