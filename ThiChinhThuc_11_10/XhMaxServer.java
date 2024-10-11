package ThiChinhThuc_11_10;
import java.net.*;
public class XhMaxServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket server = new DatagramSocket(2207);  // Tạo socket cho server tại cổng 2207
        System.out.println("Server is running.");
        while (true) {
            //a. Nhận chuỗi mã sinh viên và mã câu hỏi từ client
            byte[] buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            server.receive(dpNhan);  // Nhận dữ liệu từ client
            String request = new String(dpNhan.getData()); 
            System.out.println("a. Received from client: " + request);
            //b. Gửi 1 chuỗi lên cho client
            String s = "ABCD;Qnc8d5x78ald5GWWmaAAjyg3";
            DatagramPacket dpGui = new DatagramPacket(s.getBytes(), s.length(),  dpNhan.getAddress(), dpNhan.getPort());
            server.send(dpGui);
            System.out.println("b. Da gui thanh cong");
            //c. Nhận tổng các số
            byte []buffer1 = new byte[1024];
            DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
            server.receive(dpNhan1);
            String res = new String(dpNhan1.getData());
            System.out.println("c. Ket qua: " + res);
            break;  
        }
    }
}