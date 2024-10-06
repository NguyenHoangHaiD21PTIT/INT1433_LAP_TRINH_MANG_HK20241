package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai4Server {    
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(2207);
        System.out.println("Server is running.");
        while(true){
            //a.
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            String s = new String(dpNhan.getData());
            System.out.println(s);
            //b.
            String s1 = "1,5,3,19,25,4,8,12";
            DatagramPacket dpGui = new DatagramPacket(s1.getBytes(), s1.length(), dpNhan.getAddress(), dpNhan.getPort());
            socket.send(dpGui);
            //c.
            byte []buffer1 = new byte[1024];
            DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
            socket.receive(dpNhan1);
            String s2 = new String(dpNhan1.getData());
            System.out.println(s2);
        }
    }
}
