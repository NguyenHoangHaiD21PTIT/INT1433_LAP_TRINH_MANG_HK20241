package ThiThuUDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class VietHoa {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN319;oC4JH4si";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String s = new String(dpNhan.getData()).trim();
        System.out.println(s);
        //c.
        s = s.replace(';', ' ');
        String []s1 = s.split("\\s+");
        String rqID = s1[0];
        ArrayList<String>a = new ArrayList<>();
        for(int i = 1;i<s1.length;i++) a.add(s1[i]);
        String res = rqID + ";";
        for(String x: a) res+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        System.out.println(res);
        //
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
