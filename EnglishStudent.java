import java.util.List;

public class EnglishStudent extends Student {
    // Constants
    private static final double TERM_PAPER_WEIGHT = 0.3;
    private static final double MIDTERM_WEIGHT = 0.3;
    private static final double FINAL_EXAM_WEIGHT = 0.4;

    public EnglishStudent(String firstName, String lastName, List<Integer> grades) {
        super(firstName, lastName, "English", grades);
    }

    @Override
    public double getAverage() {
        double termPaper = grades.get(0) * TERM_PAPER_WEIGHT;
        double midterm = grades.get(1) * MIDTERM_WEIGHT;
        double finalExam = grades.get(2) * FINAL_EXAM_WEIGHT;
        return termPaper + midterm + finalExam;
    }
}