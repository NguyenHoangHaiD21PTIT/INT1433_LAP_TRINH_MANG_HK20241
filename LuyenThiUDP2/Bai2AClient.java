package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai2AClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCCN319;cb";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData()).trim();
        System.out.println(s);
        //c.
        int []cnt = new int [1000];
        ArrayList<Character>a = new ArrayList<>();
        for(char x: s.toCharArray()){
            cnt[x]++;
        }
        for(char x: s.toCharArray()){
            if(x != ' ' && cnt[x] > 1&&a.contains(x)==false) a.add(x);
        }
        String res = "";
        for(char x: a) res+=String.valueOf(x) + ":" + String.valueOf(cnt[x]) + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
