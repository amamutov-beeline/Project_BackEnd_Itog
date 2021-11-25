import StudUni.Student;
import StudUni.University;
import enums.StudyProfile;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Asd Fgh Jkl");
        student.setUniversityId("1");
        student.setCurrentCourseNumber(5);
        student.setAvgExamScore(2.2F);

        System.out.println(student);

        University university = new University();
        university.setId("1");
        university.setFullName("Harvard University");
        university.setShortName("HU");
        university.setYearOfFoundation(1636);
        university.setMainProfile(StudyProfile.MEDICINE);

        System.out.println(university);
    }
}
