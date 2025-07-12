package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class ViTriCanBang{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //MSV mã đề
        String code = "B21DCCN169;zmNHK0Y7";
        out.write(code.getBytes());
        out.flush();
        //Đọc xâu
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //Chuyển xâu thành dãy số
        ArrayList<Integer>a = new ArrayList<>();
        String []a1 = s.trim().split(",");
        for(String x: a1) a.add(Integer.parseInt(x));
        //Xử lí
        ///Xét từng vị trí rồi tính độ lệch giữa mảng trái và mảng phải
        int n = a.size(), pos = 0, res = Integer.MAX_VALUE, tongTrai = 0, tongPhai = 0;
        for(int i = 1;i<n - 1;i++){
            int tong1 = 0, tong2 = 0;
            for (int j = 0; j < i; j++) tong1 += a.get(j);
            for (int j = i + 1; j < n; j++) tong2 += a.get(j);
            int hieu = Math.abs(tong1 - tong2);
            if (hieu < res) {
                res = hieu;
                pos = i;
                tongTrai = tong1;
                tongPhai = tong2;
            }
        }
        String ans = String.format("%d,%d,%d,%d", pos, tongTrai, tongPhai, res);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}