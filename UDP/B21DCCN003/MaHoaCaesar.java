package UDP.B21DCCN003;
import java.net.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B21DCCN003;vNIIU53V";
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
        String rI = sTmp[0]; String s = sTmp[1]; int doDich = Integer.parseInt(sTmp[2].trim());
        //
        String ans = "";
        for(char x: s.toCharArray()){
            char base = Character.isUpperCase(x) ? 'A' : 'a';
            x = (char) ((x - base + doDich) % 26 + base);
            ans+=x;
        }
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
