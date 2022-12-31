import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradesProcessor {
    public static void main(String[] args) {
        // Read input from file
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int numStudents = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < numStudents; i++) {
                String[] nameParts = reader.readLine().split(",");
                String lastName = nameParts[0].trim();
                String firstName = nameParts[1].trim();
                String subject = reader.readLine().split(" ")[0];
                String[] gradesStr = reader.readLine().split(" ");
                List<Integer> grades = new ArrayList<>();
                for (String gradeStr : gradesStr) {
                    grades.add(Integer.parseInt(gradeStr));
                }
                if (subject.equals(Student.getEnglish())) {
                    students.add(new EnglishStudent(firstName, lastName, grades));
                } else if (subject.equals(Student.getScience())) {
                    students.add(new ScienceStudent(firstName, lastName, grades));
                } else if (subject.equals(Student.getMath())) {
                    students.add(new MathStudent(firstName, lastName, grades));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }

        // Write output to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            int[] gradeCounts = new int[11];
            for (Student student : students) {
                List<Integer> grades = student.getGrades();
                writer.write(String.format("%s %s: Final Exam: %d, Average: %.2f, Grade: %c%n", student.getFirstName(), student.getLastName(), grades.get(grades.size() - 1), student.getAverage(), student.getLetterGrade()));
            }
            GradeTracker gradeTracker = new GradeTracker();
            gradeTracker.countGrades(students);
            writer.write(String.format("%nGrade distribution:%nA: %d%nB: %d%nC: %d%nD: %d%nF: %d%n", gradeTracker.getNumA(), gradeTracker.getNumB(), gradeTracker.getNumC(), gradeTracker.getNumD(), gradeTracker.getNumF()));
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
            System.exit(1);
        }
    }
}
