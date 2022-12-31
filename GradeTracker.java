import java.util.List;

public class GradeTracker {
    private int[] counts;

    public GradeTracker() {
        counts = new int[11];
    }

    public void countGrades(List<Student> students) {
        for (Student student : students) {
            char grade = student.getLetterGrade();
            if (grade == 'A') {
                counts[0]++;
            } else if (grade == 'B') {
                counts[1]++;
            } else if (grade == 'C') {
                counts[2]++;
            } else if (grade == 'D') {
                counts[3]++;
            } else if (grade == 'F') {
                counts[4]++;
            }
        }
    }

    public int getNumA() {
        return counts[0];
    }

    public int getNumB() {
        return counts[1];
    }

    public int getNumC() {
        return counts[2];
    }

    public int getNumD() {
        return counts[3];
    }

    public int getNumF() {
        return counts[4];
    }
}