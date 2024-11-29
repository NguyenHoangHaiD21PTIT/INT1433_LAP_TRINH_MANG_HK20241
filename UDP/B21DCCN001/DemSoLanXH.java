package UDP.B21DCCN001;
import java.net.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s1 = new String(dpNhan.getData());
        System.out.println(s1);
        String []sTmp = s1.trim().split(";");
        String rI = sTmp[0]; String s = sTmp[1];
        //Đếm
        String res = ""; int []cnt = new int[10005];
        for(char x: s.toCharArray()) cnt[x]++;
        for(char x: s.toCharArray()){
            if(cnt[x]>0){
                res+=String.format("%d%c", cnt[x], x);
                cnt[x] = 0;
            }
        }
        res = rI + ";" + res;
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
