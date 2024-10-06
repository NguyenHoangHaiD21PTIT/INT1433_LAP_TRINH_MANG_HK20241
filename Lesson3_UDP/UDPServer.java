package Lesson3_UDP;
import java.io.*;
import java.net.*;
public class UDPServer {
    public static void main(String[] args) throws IOException{
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("Server is running.");
        while(true){
            byte []buffer = new byte[1024];
            //Tiếp nhận dữ liệu
            DatagramPacket dpReq = new DatagramPacket(buffer, buffer.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData());
            System.out.println(strReq);
            //Xử lý
            String strRes = StrUtils.Reverse(strReq);
            DatagramPacket dpRes = new DatagramPacket(strRes.getBytes(), strRes.length(), dpReq.getAddress(), dpReq.getPort());
            //Gửi bản tin
            server.send(dpRes);
        }
    }
}
