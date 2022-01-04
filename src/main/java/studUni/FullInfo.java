package studUni;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class FullInfo {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentsEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universityInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticalEntry")
    private List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public FullInfo(){}


    public List<Student> getStudentList() {
        return studentList;
    }

    public FullInfo setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public FullInfo setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public FullInfo setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public FullInfo setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}
