import java.io.Serializable;

// Serializable allows us to save the object state to a file
public class Course implements Serializable {
    private String courseName;
    private int credits;
    private String grade;

    public Course(String courseName, int credits, String grade) {
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade.toUpperCase();
    }

    // Getters and Setters
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("%-20s | Credits: %d | Grade: %s", courseName, credits, grade);
    }
}