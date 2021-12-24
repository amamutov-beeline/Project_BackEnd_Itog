package studUni;

import enums.StudyProfile;

public class Statistics {

    private StudyProfile profile;
    private double examAvg;
    private int totalStudents;
    private int totalUniversities;
    private String universityName;



    public double getExamAvg() {
        return examAvg;
    }

    public void setExamAvg(double examAvg) {
        this.examAvg = examAvg;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalUniversities() {
        return totalUniversities;
    }

    public void setTotalUniversities(int totalUniversities) {
        this.totalUniversities = totalUniversities;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }
}
