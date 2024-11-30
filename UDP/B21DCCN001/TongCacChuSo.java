package UDP.B21DCCN001;
import java.net.*;
public class TongCacChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;0Iend7Pp";
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
        int tong = 0;
        for(char x: s.toCharArray()) tong+=(x - '0');
        String res = String.format("%s;%d", rI, tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
