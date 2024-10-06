package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class XXacAServer {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(2207);
        System.out.println("Server is running");
        while(true){
            //a. 
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            String s = new String(dpNhan.getData());
            System.out.println(s);
            //b. 
            int n = 10;
            String n1 = String.valueOf(n);
            DatagramPacket dpGui = new DatagramPacket(n1.getBytes(), n1.length(), dpNhan.getAddress(), dpNhan.getPort());
            socket.send(dpGui);
            int []a = {1,4,6,1,3,5,6,4,2,6};
            for(int x: a){
                String s1 = String.valueOf(x);
                DatagramPacket dpGui1 = new DatagramPacket(s1.getBytes(), s1.length(), dpNhan.getAddress(), dpNhan.getPort());
                socket.send(dpGui1);
            }
            //c.
            System.out.println();
            for(int i = 0;i<6;i++){
                byte []buffer1 = new byte[1024];
                DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
                socket.receive(dpNhan1);
                String s2 = new String(dpNhan1.getData());
                System.out.println(s2);
            }
        }
    }
}
