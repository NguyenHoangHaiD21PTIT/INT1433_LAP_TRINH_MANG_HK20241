package ThiChinhThuc_01;
import java.io.*;
import java.util.*;
import java.net.*;

public class SapXep_Client {
    public static void main(String[] args) throws IOException {       
        Socket socket = new Socket("localhost", 807);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        // a. Gửi dữ liệu mã sinh viên và mã câu hỏi lên server
        String code = "B21DCCN000;abcde";
        out.write(code.getBytes());
        out.flush();
        //b. Nhận dữ liệu từ server
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead).trim();
        System.out.println("b. Received from server: " + s);
        //c. 1. Sắp xếp số chẵn và số lẻ
        String[] a = s.split(",");
        ArrayList<Integer> chan = new ArrayList<>(), le = new ArrayList<>();
        for (String x : a) {
            int x1 = Integer.parseInt(x);  // Thêm trim() để loại bỏ khoảng trắng
            if (x1 % 2 == 0) chan.add(x1);
            else le.add(x1);
        }
        Collections.sort(chan);
        Collections.sort(le);
        //2. In theo dạng
        String ans = "[";
        for(int i = 0;i<chan.size() - 1;i++) ans+=String.valueOf(chan.get(i)) + ", ";
        ans+=String.valueOf(chan.get(chan.size() - 1) + "];[");
        for(int i = 0;i<le.size() - 1;i++) ans+=String.valueOf(le.get(i)) + ", ";
        ans+=String.valueOf(le.get(le.size() - 1) + "]");
        //3. Gửi chuỗi kết quả lên server
        System.out.println("d. Sending to server: " + ans);
        out.write(ans.toString().getBytes());
        out.flush();
        //d. Đóng luồng và socket
        in.close();
        out.close();
        socket.close();
    }
}
