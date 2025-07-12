package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class Tong_x2_TB{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //MSV mã đề
        String code = "B21DCCN169;TL9Pol9D";
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
        Collections.sort(a);
        //Xử lí
        ///Tính TBC
        int tong = 0, n = a.size();
        for(int i = 0;i<n;i++) tong+=a.get(i);
        float tbc = (float)tong/n;
        ///Khởi trị 2 số và khoảng cách
        float kcach = Float.MAX_VALUE, mucTieu = 2 * tbc;//Khoảng cách giữa cụm tổng 2 số với tbc
        int so1 = 0, so2 = 0;
        //Tìm số gần TB nhất
        for(int i = 0;i<n;i++){
            for(int j = i + 1;j<n;j++){
                int sum = a.get(i) + a.get(j);
                float hieu = Math.abs(sum - mucTieu);
                if (hieu < kcach) {
                    kcach = hieu;
                    so1 = a.get(i);
                    so2 = a.get(j);
                }
            }
        }
        String ans = String.format("%d,%d", so1, so2);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}