package UDP.B21DCCN001;
import java.net.*;
public class TimSoConThieu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN001;XdHHmyiv";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String s = new String(dpNhan.getData());
        System.out.println(s);
        String []sTmp = s.trim().split(";");
        String rI = sTmp[0]; int n = Integer.parseInt(sTmp[1]);
        String num = sTmp[2];
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split(",");
        for(int i = 0;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d,", i);
        }
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
    }
}
