import java.util.List;

public class ScienceStudent extends Student {
    // Constants
    private static final double ATTENDANCE_WEIGHT = 0.1;
    private static final double PROJECT_WEIGHT = 0.3;
    private static final double MIDTERM_WEIGHT = 0.3;
    private static final double FINAL_EXAM_WEIGHT = 0.3;

    public ScienceStudent(String firstName, String lastName, List<Integer> grades) {
        super(firstName, lastName, "Science", grades);
    }

    @Override
    public double getAverage() {
        double attendance = grades.get(0) * ATTENDANCE_WEIGHT;
        double project = grades.get(1) * PROJECT_WEIGHT;
        double midterm = grades.get(2) * MIDTERM_WEIGHT;
        double finalExam = grades.get(3) * FINAL_EXAM_WEIGHT;
        return attendance + project + midterm + finalExam;
    }
}