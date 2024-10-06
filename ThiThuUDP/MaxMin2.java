package ThiThuUDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class MaxMin2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;

        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;Aisji6xy";
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
        tmp = tmp.replace(',', ' ');
        String[] tmp1 = tmp.trim().split("\\s+");
        String rqID = tmp1[0];
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i < tmp1.length; i++) a.add(Integer.parseInt(tmp1[i]));
        Collections.sort(a);
        int nho = a.get(1);
        int lon = a.get(a.size() - 2);
        String res = String.format("%s;%d,%d", rqID, lon, nho); 
        System.out.println(res);
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);

        // d. Đóng socket
        socket.close();
    }
}