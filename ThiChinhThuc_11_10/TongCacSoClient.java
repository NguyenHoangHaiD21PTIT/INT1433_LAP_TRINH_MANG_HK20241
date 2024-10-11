import java.net.*;
public class TongCacSoClient {
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
        //
        String s = new String(dpNhan.getData());
        int idx = s.indexOf(";");
        String rI = s.substring(0, idx);
        String num = s.substring(idx + 1).trim();
        System.out.println(rI + num);
        int ans = 0;
        for(char x: num.toCharArray()) ans+=Integer.parseInt(String.valueOf(x));
        System.out.println(ans);
        String res = String.valueOf(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
