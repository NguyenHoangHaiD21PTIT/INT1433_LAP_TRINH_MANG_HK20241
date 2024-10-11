package UDP;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket(2209);  // Server lắng nghe trên cổng 2209
        System.out.println("Server is running...");

        // RequestId cố định do server tạo ra
        String requestId = "REQ12345";  // Giả định requestId là chuỗi cố định

        while (true) {
            // a. Nhận chuỗi chứa mã sinh viên và mã câu hỏi từ client
            byte[] buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            
            // Chuyển đổi dữ liệu nhận được thành chuỗi, cắt bỏ byte thừa
            String receivedMessage = new String(dpNhan.getData(), 0, dpNhan.getLength());
            System.out.println("Received: " + receivedMessage);

            // b. Gửi lại thông tin đối tượng Product cho client
            // Tạo đối tượng Product với dữ liệu ban đầu
            Product product = new Product("P001", "C001", "lenovo thinkpad T520", 9981);

            // Chuyển đối tượng Product thành byte[] để gửi cho client
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(product);
            out.flush();

            byte[] responseBytes = new byte[8 + bout.size()];
            System.arraycopy(requestId.getBytes(), 0, responseBytes, 0, 8);  // Sao chép requestId
            System.arraycopy(bout.toByteArray(), 0, responseBytes, 8, bout.size());  // Sao chép đối tượng Product

            // Gửi đối tượng Product kèm requestId về cho client
            DatagramPacket dpGui = new DatagramPacket(responseBytes, responseBytes.length, dpNhan.getAddress(), dpNhan.getPort());
            socket.send(dpGui);
            System.out.println("Sent product to client: " + product);

            // c. Nhận lại đối tượng Product đã được sửa đổi từ client
            DatagramPacket dpNhanLai = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhanLai);
            String rI = new String(dpNhanLai.getData(), 0, 8);  // Nhận lại requestId

            // Đọc lại đối tượng Product từ thông điệp nhận
            ByteArrayInputStream bin = new ByteArrayInputStream(dpNhanLai.getData(), 8, dpNhanLai.getLength() - 8);
            ObjectInputStream in = new ObjectInputStream(bin);
            Product modifiedProduct = (Product) in.readObject();
            System.out.println("Received modified product from client: " + modifiedProduct);

            // Xử lý hoặc lưu trữ đối tượng product đã sửa đổi...
        }
    }
}

