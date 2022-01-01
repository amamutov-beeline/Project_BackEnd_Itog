package Utils;

import Comparators.Student.*;
import Comparators.University.*;
import enums.StudComparatorsEnum;
import enums.UnivComparatorsEnum;

public class EnumReader {

    public static StudentComparator getStudentComparator(StudComparatorsEnum studComparatorsEnum) {
        switch (studComparatorsEnum) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            case COURSE_NUMBER:
                return new StudentCourseNumberComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UnivComparatorsEnum univComparatorsEnum) {
        switch (univComparatorsEnum) {
            case ID:
                return new UniversityIdComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
