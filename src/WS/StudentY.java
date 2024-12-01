package WS;

import java.io.Serializable;

public class StudentY implements Serializable {
    private String studentId;  // Mã sinh viên
    private String name;       // Tên sinh viên
    private String subject;    // Môn học
    private float score;       // Điểm số của sinh viên

    // Constructor
    public StudentY(String studentId, String name, String subject, float score) {
        this.studentId = studentId;
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    // Getter và Setter cho studentId
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Getter và Setter cho score
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    // Phương thức toString để in thông tin sinh viên
    @Override
    public String toString() {
        return "StudentY{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}