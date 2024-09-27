package TCP;

import java.io.*;
import java.net.*;

public class StudentServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(809);
        while (true) {
            // Chấp nhận kết nối từ client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // Nhận mã sinh viên và mã câu hỏi từ client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Tạo đối tượng Student giả định từ server và gửi cho client
            Student student = new Student(1, "B20DCCN999", 3.5f);
            System.out.println("Sending Student object to client: " + student);
            out.writeObject(student);
            out.flush();

            // Nhận đối tượng Student đã xử lý từ client
            Student processedStudent = (Student) in.readObject();
            System.out.println("Received processed Student from client: " + processedStudent);
        }
    }
}
