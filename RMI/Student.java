package RMI;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20241130L;
    private int id;
    private String name;
    private int enrollmentYear;
    private String code;
    public Student() {}
    public Student(int id, String name, int enrollmentYear) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", code='" + code + '\'' + '}';
    }
}