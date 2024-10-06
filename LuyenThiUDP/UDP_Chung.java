package LuyenThiUDP;
import java.net.*;
public class UDP_Chung {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");//Thay bằng cổng tương ứng đề bài
        int sP = 2207;//port đề cho
        //a. Gửi 
        //Tất cả cái gì muốn gửi thì gửi qua String
        String code = "B21DCCN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cái gì đó
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        //Xử lý tiếp từ đây
    }
}
