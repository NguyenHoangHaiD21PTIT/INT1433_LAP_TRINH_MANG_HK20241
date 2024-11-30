package UDP.B17DCAT176;
import java.net.*;
public class LietKeSNT {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B17DCAT176;78CCQ6xD";
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
        String rI = sTmp[0]; String s1 = sTmp[1];int n = Integer.parseInt(s1.trim());
        //
        String ans = "";int cnt = 0;
        for(int i = 2;i<=1000000;i++){
            if(check(i)){
                cnt++;
                ans+=String.format("%d,", i);
                if(cnt==n) break;
            }
        }
        ans = ans.substring(0, ans.length() - 1);
        ans = rI + ";" + ans;
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
    public static boolean check(int n){
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
