package ThiChinhThuc_11_10;
import java.net.*;
import java.util.*;
public class DemSoLanXuatHienClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        //a.
        String code = "B21DCCN319;ccc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //Nhận xâu
        String s = new String(dpNhan.getData());
        int idx = s.indexOf(";");
        String rI = s.substring(0, idx);
        String s1 = s.substring(idx + 1).trim();
        System.out.println(s1);
        //Đếm số lần
        int[] cnt = new int[256]; 
        for (char x : s.toCharArray()) {
            if (Character.isLetter(x)||Character.isDigit(x)) cnt[x]++;
        }
        ArrayList<Character> b = new ArrayList<>();
        for (char x : s.toCharArray()) {
            if ((Character.isLetter(x)||Character.isDigit(x)) && cnt[x] > 1 && !b.contains(x)) b.add(x); 
        }
        //Gửi
        String res = rI + ";";
        for(char x: b) res+=String.format("%d%c", cnt[x], x);
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
