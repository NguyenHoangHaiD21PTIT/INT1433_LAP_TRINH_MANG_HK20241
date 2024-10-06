package LuyenThiUDP;
import java.net.*;
public class Bai3Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        System.out.println("Server is running");
        while(true){
            //a. Nhận MSV
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            String s = new String(dpNhan.getData());
            System.out.println("a. Nhan ma sinh vien: " + s);
            //b. Gửi chuỗi
            String s1 = "ưertyuiopasdfghjklzxcvbnm";
            DatagramPacket dpGui = new DatagramPacket(s1.getBytes(), s1.length(), dpNhan.getAddress(), dpNhan.getPort());
            socket.send(dpGui);
            System.out.println("b. Da gui thanh cong");
            //c. Nhận lại chuỗi
            byte []buffer1 = new byte[1024];
            DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
            socket.receive(dpNhan1);
            String s2 = new String(dpNhan1.getData());
            System.out.println("c. Chuoi thu duoc la: " + s2);
        }
    }
}
/*
Đề bài giả định: Một chương trình server được triển khai tại địa chỉ localhost (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình Client thực hiện kết nối tới server tại cổng 2207, sử dụng giao thức UDP để trao đổi thông tin theo thứ tự: 
a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". 
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên. 
b. Nhận một chuỗi từ server
c. Loại bỏ các nguyên âm trong chuỗi, gửi lại chuỗi mới lên server
d. Đóng kết nối và kết thúc
*/
