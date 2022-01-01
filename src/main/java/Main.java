import Comparators.Student.StudentComparator;
import Comparators.University.UniversityComparator;
import ReadAndWrite.JsonWriter;
import ReadAndWrite.XmlWriter;
import enums.StudComparatorsEnum;
import enums.UnivComparatorsEnum;
import ReadAndWrite.FileReader;
import ReadAndWrite.XlsWriter;
import studUni.FullInfo;
import studUni.Statistics;
import studUni.Student;
import studUni.University;
import Utils.EnumReader;
import Utils.JsonUtil;
import Utils.StatUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(Level.INFO, "Application started, Logger configured");
        List<University> universities =
                FileReader.UniversityInfo("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                EnumReader.getUniversityComparator(UnivComparatorsEnum.YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);

        List<Student> students =
                FileReader.StudentInfo("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                EnumReader.getStudentComparator(StudComparatorsEnum.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);
        logger.log(Level.INFO, "App finished");
    }
}