import Comparators.Student.StudentComparator;
import Comparators.University.UniversityComparator;
import Reader.EnumReader;
import Reader.FileReader;
import StudUni.Student;
import StudUni.University;
import enums.StudComparatorsEnum;
import enums.UnivComparatorsEnum;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = FileReader.UniversityInfo("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = EnumReader.getUniversityComparator(UnivComparatorsEnum.YEAR_OF_FOUNDATION);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        List<Student> students = FileReader.StudentInfo("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = EnumReader.getStudentComparator(StudComparatorsEnum.AVG_EXAM_SCORE);
        students.stream().sorted(studentComparator).forEach(System.out::println);
    }

}
