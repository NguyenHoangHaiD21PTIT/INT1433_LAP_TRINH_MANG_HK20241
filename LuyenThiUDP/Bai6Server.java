package LuyenThiUDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai6Server {
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
            int []a = {15, 17};
            for(int x: a){
                String s1 = String.valueOf(x);
                DatagramPacket dpGui = new DatagramPacket(s1.getBytes(), s1.length(), dpNhan.getAddress(), dpNhan.getPort());
                socket.send(dpGui);
            }
            int []res = new int[6];
            for(int i = 0;i<4;i++){
                byte []bufferi = new byte[1024];
                DatagramPacket dpNhani = new DatagramPacket(bufferi, bufferi.length);
                socket.receive(dpNhani);
                String s2 = new String(dpNhani.getData());
                System.out.println(s2);
            }
            break;
        }
    }
}
