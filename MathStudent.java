import java.util.List;

public class MathStudent extends Student {
    // Constants
    private static final double QUIZ_AVERAGE_WEIGHT = 0.15;
    private static final double TEST_1_WEIGHT = 0.3;
    private static final double TEST_2_WEIGHT = 0.2;
    private static final double FINAL_EXAM_WEIGHT = 0.35;

    public MathStudent(String firstName, String lastName, List<Integer> grades) {
        super(firstName, lastName, "Math", grades);
    }

    @Override
    public double getAverage() {
        double quizAverage = 0;
        for (int i = 0; i < 5; i++) {
            quizAverage += grades.get(i);
        }
        quizAverage /= 5;
        quizAverage *= QUIZ_AVERAGE_WEIGHT;
        double test1 = grades.get(5) * TEST_1_WEIGHT;
        double test2 = grades.get(6) * TEST_2_WEIGHT;
        double finalExam = grades.get(7) * FINAL_EXAM_WEIGHT;
        return quizAverage + test1 + test2 + finalExam;
    }
}