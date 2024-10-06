package LuyenThiUDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai6Client {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B2D1CCN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        int []a = new int[2];
        for(int i = 0;i<2;i++){
            byte []bufferi = new byte[1024];
            DatagramPacket dpNhani = new DatagramPacket(bufferi, bufferi.length);
            socket.receive(dpNhani);
            String s = new String(dpNhani.getData()).trim();
            a[i] = Integer.parseInt(s);
            System.out.println(s);
        }
        //c.
        int tong = a[0] + a[1], hieu = a[0] - a[1], tich = a[0] * a[1];
        int []res = {tong, hieu, tich};
        for(int x: res){
            String s1 = String.valueOf(x);
            DatagramPacket dpGuii = new DatagramPacket(s1.getBytes(), s1.length(), sA, sP);
            socket.send(dpGuii);
        }
        socket.close();
    }
}
