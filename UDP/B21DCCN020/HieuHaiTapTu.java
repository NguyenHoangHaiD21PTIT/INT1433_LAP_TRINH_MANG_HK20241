package UDP.B21DCCN020;
import java.net.*;
public class HieuHaiTapTu {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN020;JQCO3izC";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //
        String st = new String(dpNhan.getData());
        System.out.println(st);
        String []sTmp = st.trim().split(";");
        String rI = sTmp[0]; String s1 = sTmp[1], s2 = sTmp[2];
        //
        String ans = "";
        int []cnt = new int[10005]; 
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
