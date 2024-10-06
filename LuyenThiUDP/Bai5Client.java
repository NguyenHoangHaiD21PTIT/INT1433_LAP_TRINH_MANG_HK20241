package LuyenThiUDP;
import java.util.*;
import java.io.*;
import java.net.*;
public class Bai5Client {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCNN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. 
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData()).trim();
        System.out.println(s);
        //c.
        int tong = 0;
        String []a = s.split("\\|");
        for(String x: a) tong+=Integer.parseInt(x);
        System.out.println(tong);
        //Gửi
        String res = String.valueOf(tong);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d. Đóng
        socket.close();
    }
}
