import java.util.List;

public abstract class Student {
    // Constants
    private static final String ENGLISH = "English";
    private static final String SCIENCE = "Science";
    private static final String MATH = "Math";

    // Instance variables
    private final String firstName;
    private final String lastName;
    private final String subject;
    protected final List<Integer> grades;

    // Protected constructor to allow derived classes to access it
    protected Student(String firstName, String lastName, String subject, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public abstract double getAverage();

    public char getLetterGrade() {
        double average = getAverage();
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static String getEnglish() {
        return ENGLISH;
    }

    public static String getScience() {
        return SCIENCE;
    }

    public static String getMath() {
        return MATH;
    }

    public List<Integer> getGrades() {
        return grades;
    }

}
