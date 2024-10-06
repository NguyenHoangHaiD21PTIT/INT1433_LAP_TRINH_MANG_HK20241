package LuyenThiUDP;
import java.net.*;
import java.util.*;
public class Bai4Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        String code = "B21DCCN319;ppp";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData());
        System.out.println(s);
        s = s.replace(',', ' ');
        String res = "";
        ArrayList<String>a = new ArrayList<>();
        String []tmp = s.trim().split("\\s+");
        for(String x: tmp){
            if(x.endsWith(".edu")) a.add(x);
        }
        for(String x: a) res+=x+" ";
        System.out.println(res);
        DatagramPacket dpGui2 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui2);
    }
}
