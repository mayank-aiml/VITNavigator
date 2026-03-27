import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPACalculator {
    private static final Map<String, Integer> gradePoints = new HashMap<>();

    static {
        gradePoints.put("S", 10);
        gradePoints.put("A", 9);
        gradePoints.put("B", 8);
        gradePoints.put("C", 7);
        gradePoints.put("D", 6);
        gradePoints.put("E", 5);
        gradePoints.put("F", 0);
    }

    public static double calculateGPA(List<Course> courses) {
        if (courses.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;

        for (Course c : courses) {
            Integer points = gradePoints.get(c.getGrade());
            if (points != null) {
                totalPoints += (points * c.getCredits());
                totalCredits += c.getCredits();
            }
        }

        return (totalCredits == 0) ? 0.0 : totalPoints / totalCredits;
    }
}