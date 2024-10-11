package ThiChinhThuc_11_10;
import java.net.*;
import java.util.*;
public class XhMaxClient {
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
        System.out.println(s);
        //Đếm số lần
        int[] cnt = new int[256]; 
        for (char x : s1.toCharArray()) {
            if (Character.isLetter(x)||Character.isDigit(x)) cnt[x]++;
        }
        ArrayList<Character> b = new ArrayList<>();
        for (char x : s1.toCharArray()) {
            if ((Character.isLetter(x)||Character.isDigit(x)) && cnt[x] > 1 && !b.contains(x)) b.add(x); 
        }
        //Xử lý
        String res = rI + ";";
        int Max = -1;
        char chr = ' ';
        for(char x: b){
            if(cnt[x]>Max){
                Max = cnt[x];
                chr = x;
            }
        }
        res+=String.valueOf(chr) + ":";
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i)==chr) res+=String.format("%d,", i + 1);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
