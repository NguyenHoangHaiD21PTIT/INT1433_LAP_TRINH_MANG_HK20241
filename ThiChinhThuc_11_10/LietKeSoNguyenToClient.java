package ThiChinhThuc_11_10;
import java.net.*;
import java.util.*;
public class LietKeSoNguyenToClient {
    public static int checkPrime(int n){
        if(n<=1) return 0;
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
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
        int n = Integer.parseInt(s1);
        System.out.println(s1);
        //Đếm số lần
        ArrayList<Integer>a = new ArrayList<>();
        a.add(2);
        for(int i = 3;i<=1000000;i+=2){ 
            if(checkPrime(i)==1){
                a.add(i);
                if(a.size()==n) break;
            }
        }
        //Gửi
        String res = rI + ";";
        for(int x: a) res+=String.format("%d ", x);
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
