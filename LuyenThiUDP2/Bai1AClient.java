package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai1AClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCCN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. 
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData()).trim();
        System.out.println(s);
        //c.
        ArrayList<Integer>chan = new ArrayList<>(), le = new ArrayList<>();
        String []a = s.split(",");
        for(String x: a){
            int y = Integer.parseInt(x);
            if(y%2==0) chan.add(y);
            else le.add(y);
        }
        Collections.sort(le);
        Collections.sort(chan);
        String res = "[";
        for(int i = 0;i<chan.size() - 1;i++) res+=String.valueOf(chan.get(i)) + ",";
        res+=String.valueOf(chan.get(chan.size() - 1)) + "];[";
        for(int i = 0;i<le.size() - 1;i++) res+=String.valueOf(le.get(i)) + ",";
        res+=String.valueOf(le.get(le.size() - 1)) + "]";
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
