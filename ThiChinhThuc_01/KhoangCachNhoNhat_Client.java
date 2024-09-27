package ThiChinhThuc_01;
import java.io.*;
import java.net.*;
import java.util.*;
public class KhoangCachNhoNhat_Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 807);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN319; 805";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        ArrayList<Integer>a = new ArrayList<>();
        String []a1 = s.trim().split(",");
        for(String x: a1) a.add(Integer.parseInt(x));
        Collections.sort(a);
        int ans = 1000; 
        int lon = 0, be = 0;
        for(int i = a.size() - 1;i>=1;i--){
            if(a.get(i) - a.get(i - 1) < ans){
                ans = a.get(i) - a.get(i - 1);
                lon = a.get(i); be = a.get(i - 1);
            }
        }
        String q = "";
        q = String.valueOf(ans) + ", " + String.valueOf(be) + ", " + String.valueOf(lon);
        System.out.println(q);
        out.write(q.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
