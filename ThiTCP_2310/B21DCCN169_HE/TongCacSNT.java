package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class TongCacSNT{
    public static int check(int n){
        if(n<=1) return 0;
        for(int i = 2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //MSV mã đề
        String code = "B21DCCN377;htKatHFO";
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
        int tong = 0;
        for(int x: a){
            if(check(x)==1)tong+=x;
        }
        String ans = String.format("%d", tong);
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}