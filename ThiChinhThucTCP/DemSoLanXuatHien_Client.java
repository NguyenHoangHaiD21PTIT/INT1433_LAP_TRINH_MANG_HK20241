package ThiChinhThuc_01;
import java.io.*;
import java.util.*;
import java.net.*;

public class DemSoLanXuatHien_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 807);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN000;001";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        int[] cnt = new int[256]; 
        for (char x : s.toCharArray()) {
            if (Character.isLetter(x)||Character.isDigit(x)) cnt[x]++;
        }
        ArrayList<Character> b = new ArrayList<>();
        for (char x : s.toCharArray()) {
            if ((Character.isLetter(x)||Character.isDigit(x)) && cnt[x] > 1 && !b.contains(x)) b.add(x); 
        }
        String ans = "";
        for (char x : b) ans += x + ":" + cnt[x] + ","; // Nối kết quả vào chuỗi ans
        if (ans.length() > 0) ans = ans.substring(0, ans.length() - 1); // Loại bỏ dấu phẩy cuối cùng
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
