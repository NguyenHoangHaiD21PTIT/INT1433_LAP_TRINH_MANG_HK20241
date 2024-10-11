import java.net.*;
public class SoConThieuClient {
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
        System.out.println(s);
        int idx = s.indexOf(";");
        String rI = s.substring(0, idx);
        String num = s.substring(idx + 1).trim();
        //Xử lý mảng - Đếm
        int []cnt = new int[1000005];
        String []tmp = num.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0]);
        for(int i = 1;i<tmp.length;i++) cnt[Integer.parseInt(tmp[i])]++;
        //Thiếu
        String res = rI + ";";
        for(int i = 1;i<=n;i++){
            if(cnt[i]==0) res+=String.format("%d ", i);
        }
        System.out.println(res);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        //d.
        socket.close();
    }
}
