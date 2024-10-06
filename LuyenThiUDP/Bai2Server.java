package LuyenThiUDP;
import java.net.*;
public class Bai2Server {
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
            String s = "2|5";
            DatagramPacket dpGui = new DatagramPacket(s.getBytes(), s.length(),  dpNhan.getAddress(), dpNhan.getPort());
            server.send(dpGui);
            System.out.println("b. Da gui thanh cong");
            //c. Nhận luỹ thừa lên
            byte []buffer1 = new byte[1024];
            DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
            server.receive(dpNhan1);
            String res = new String(dpNhan1.getData());
            System.out.println("c. Ket qua: " + res);
            break;  
        }
    }
}
/*
Đề bài giả định: Một chương trình server được triển khai tại địa chỉ localhost (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình Client thực hiện kết nối tới server tại cổng 2207, sử dụng giao thức UDP để trao đổi thông tin theo thứ tự: 
a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". 
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên. 
b. Nhận một chuỗi gồm 2 số nguyên a và b phân cách nhau bởi dấu | ví dụ "2|5"
c. Thực hiện tính toán a mũ b và gửi lên server. Ví dụ: 32
d. Đóng kết nối và kết thúc
*/
