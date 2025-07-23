package B21DCCN005_HE;
import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;
public class TongSoNguyenLon {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;2sIjAYaU";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        // b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        System.out.println(tmp);
        // c. Xử lý chuỗi và gửi lại kết quả
        tmp = tmp.replace(';', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        BigInteger a = new BigInteger(tmp1[1]), b = new BigInteger(tmp1[2]);
        BigInteger tong = a.add(b), hieu = a.subtract(b);
        String res = String.format("%s;%s,%s", rqID, tong.toString(), hieu.toString());
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
