package TCP;
import java.io.*;
import java.net.*;
public class StudentClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("localhost", 809);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String code = "B21DCCN319;003";
        out.writeUTF(code);
        out.flush();
        // Nhận đối tượng Student từ server
        Student student = (Student) in.readObject();
        System.out.println("Received Student object from server: " + student);
        //Nhận đối tượng
        System.out.println("Processed Student object: " + student);
        // Gửi lại đối tượng Student đã xử lý cho server
        out.writeObject(student);
        out.flush();
        System.out.println("Sent processed Student object to server.");
    }
}
