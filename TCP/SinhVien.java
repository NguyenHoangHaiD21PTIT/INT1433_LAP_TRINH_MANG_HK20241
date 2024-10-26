package TCP;
import java.io.*;
import java.net.*;
import TCP.Student;
public class SinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN222;j5ELZdmS";
        out.writeObject(code);
        out.flush();
        //b.
        Student student = (Student) in.readObject();
        System.out.println("Sinh vien ban dau: " + student);
        //c.
        float x = student.getGpa();
        if (x >= 3.7) student.setGpaLetter("A");
        else if (x >= 3.0) student.setGpaLetter("B");
        else if (x >= 2.0) student.setGpaLetter("C");
        else if (x >= 1.0) student.setGpaLetter("D");
        else student.setGpaLetter("F");
        //d.
        System.out.println("Sinh vien luc sau: " + student);
        out.writeObject(student);
        out.flush();
    }
}