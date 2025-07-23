package B21DCCN005_HE;
import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;
public class SapXepTuDienNguoc {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a. Gửi MSV, mã đề
        String code = ";B21DCCN005;9UfU4Vky";
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
        ArrayList<String> a = new ArrayList <>();
        for(int i = 1; i < tmp1.length; i++) a.add(tmp1[i]);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toLowerCase().compareTo(s1.toLowerCase());
            }
        });
        String res = rqID + ";";
        for(String x: a) res += x + ",";
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        //d. Gửi lên server
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);
        socket.close();
    }
}
//Phải đưa về cùng một kiểu rồi mới sắp xếp được
