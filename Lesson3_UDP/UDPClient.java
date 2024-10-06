package Lesson3_UDP;
import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket client = new DatagramSocket();
        //Gửi dữ liệu
        String strReq = "PTIT";
        DatagramPacket dpReq = new DatagramPacket(strReq.getBytes(), strReq.length(), 
                InetAddress.getByName("localhost"), 2207);
        client.send(dpReq);
        System.out.println("Send success");
        //Nhận kết quả
        byte []buffer = new byte[1024];
        DatagramPacket dpRes = new DatagramPacket(buffer, buffer.length);
        client.receive(dpRes);
        System.out.println(new String(dpRes.getData()));
    }
}
