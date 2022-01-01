package Utils;

import enums.StudyProfile;
import org.apache.poi.ss.formula.functions.Log;
import studUni.Statistics;
import studUni.Student;
import studUni.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatUtil {

    private static final Logger logger = Logger.getLogger(StatUtil.class.getName());

    private StatUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students,
                                                    List<University> universities) {
        logger.log(Level.INFO, "Statistics module started");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setTotalUniversities(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityName(
                            statistics.getUniversityName() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setTotalStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setExamAvg(0);
            avgExamScore.ifPresent(value -> statistics.setExamAvg(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        logger.log(Level.INFO, String.format("Statistics module finished with %s statistical objects", statisticsList.size()));

        return statisticsList;
    }
}