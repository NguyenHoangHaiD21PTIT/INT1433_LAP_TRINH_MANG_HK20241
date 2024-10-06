package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class XXacAClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCCN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        int []cnt = new int[10];
        int n = 0;
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        n = Integer.parseInt(s.trim());
        System.out.println(n);
        
        for(int i = 0;i<n;i++){
            byte []bufferi = new byte[1024];
            DatagramPacket dpNhani = new DatagramPacket(bufferi, bufferi.length);
            socket.receive(dpNhani);
            String si = new String(dpNhani.getData());
            int ni = Integer.parseInt(si.trim());
            cnt[ni]++;
        }
        
        //c.
        for(int i = 0;i<6;i++){
            float x = (float)cnt[i]/n;
            System.out.println(x + " ");
            String si = String.valueOf(x);
            DatagramPacket dpGuii = new DatagramPacket(si.getBytes(), si.length(), sA, sP);
            socket.send(dpGuii);
        }
    }
}
