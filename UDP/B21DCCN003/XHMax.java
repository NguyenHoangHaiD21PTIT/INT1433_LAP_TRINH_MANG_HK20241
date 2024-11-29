package UDP.B21DCCN003;
import java.net.*;
public class XHMax {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B21DCCN003;KFPR3GWV";
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
        String ans = "";
        int []cnt = new int[1000];
        for(char x: s.toCharArray()) cnt[x]++;
        //Tìm max
        int Max = -1; char chr = ' ';
        for(char x: s.toCharArray()){
            if(cnt[x] > Max){
                Max = cnt[x];
                chr = x;
            }
        }
        ans = rI + ";" + chr + ":";
        //Lôi các vị trí có sẵn ra
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==chr) ans+=String.format("%d,", i + 1);
        }
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
