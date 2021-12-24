import Comparators.Student.StudentComparator;
import Comparators.University.UniversityComparator;
import enums.StudComparatorsEnum;
import enums.UnivComparatorsEnum;
import ReadAndWrite.FileReader;
import ReadAndWrite.XlsWriter;
import studUni.Statistics;
import studUni.Student;
import studUni.University;
import ReadAndWrite.EnumReader;
import Utils.JsonUtil;
import Utils.StatUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universities =
                FileReader.UniversityInfo("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                EnumReader.getUniversityComparator(UnivComparatorsEnum.YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверяем, что json создан успешно
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(universityFromJson);
        });

        List<Student> students =
                FileReader.StudentInfo("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                EnumReader.getStudentComparator(StudComparatorsEnum.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            System.out.println(studentFromJson);
        });

        List<Statistics> statisticsList = StatUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");
    }
}