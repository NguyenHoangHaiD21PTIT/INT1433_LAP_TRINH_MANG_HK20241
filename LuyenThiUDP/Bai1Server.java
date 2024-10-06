package LuyenThiUDP;
import java.net.*;
public class Bai1Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(2207);  // Tạo socket cho server tại cổng 2207
        System.out.println("Server is running.");
        while (true) {
            //a. Nhận chuỗi mã sinh viên và mã câu hỏi từ client
            byte[] buffer = new byte[1024];
            DatagramPacket dpReq = new DatagramPacket(buffer, buffer.length);
            server.receive(dpReq);  // Nhận dữ liệu từ client
            String request = new String(dpReq.getData()); 
            System.out.println("a. Received from client: " + request);
            //b. Gửi lần lượt 2 số nguyên cho client
            int[] numbers = {36, 60};
            for (int i = 0; i < 2; i++) {
                String num = Integer.toString(numbers[i]);
                DatagramPacket dpRes = new DatagramPacket(num.getBytes(), num.length(), dpReq.getAddress(), dpReq.getPort());
                server.send(dpRes);  // Gửi số nguyên
                System.out.println("Sent number " + (i + 1) + " to client: " + num);
            }
            //c. Nhận lần lượt UCLN và BCNN từ client
            for (int i = 0; i < 2; i++) {
                byte[] buffer1 = new byte[1024];
                DatagramPacket dpResult = new DatagramPacket(buffer1, buffer1.length);
                server.receive(dpResult);
                String result = new String(dpResult.getData());
                System.out.println("Received result " + (i + 1) + " from client: " + result);
            }
            break;  
        }
    }
}
