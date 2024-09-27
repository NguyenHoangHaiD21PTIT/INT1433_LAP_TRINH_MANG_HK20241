package TCP;
import java.io.Serializable;
public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;
    public Student(int id, String code, float gpa) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        if (gpa >= 3.7) gpaLetter = "A";
        else if (gpa >= 3.0) gpaLetter = "B";
        else if (gpa >= 2.0) gpaLetter = "C";
        else if (gpa >= 1.0) gpaLetter = "D";
        else gpaLetter = "F";
    }
    @Override
    public String toString() {
        return this.id + " " + this.code + " " + this.gpa + " " + this.gpaLetter;
    }
}
