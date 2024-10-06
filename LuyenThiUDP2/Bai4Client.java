package LuyenThiUDP2;
import java.io.*;
import java.net.*;
import java.util.*;
public class Bai4Client {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCCN319;cn";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        System.out.println(s);
        //c.
        String []a = s.trim().split(",");
        ArrayList<Integer>a1 = new ArrayList<>();
        for(String x: a) a1.add(Integer.parseInt(x));
        Collections.sort(a1);
        int soLon = 0, soBe = 0, chenh = 100000;
        for(int i = a1.size() - 1;i>=1;i--){
            int tmp = a1.get(i) - a1.get(i - 1);
            if(tmp < chenh){
                chenh = tmp;
                soLon = a1.get(i); soBe = a1.get(i - 1);
            }
        }
        String res = "%d,%d,%d".formatted(chenh, soBe, soLon);
        System.out.println(res);
        //d.
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        
    }
}
