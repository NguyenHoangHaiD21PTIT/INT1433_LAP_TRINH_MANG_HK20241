package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class DayConKhongLapDaiNhat {
    public static void main(String[] args) throws Exception{
        //
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //
        String code = "B21DCCN214;HyHAk4P5";
        out.write(code.getBytes());
        out.flush();
        //
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //
        int ans = 0;//độ dài xâu con dài nhất không lặp
        String strMax = "";//dãy con dài nhất không lặp
        String res = "";
        for(int i = 0;i<s.length();i++){
            int []cnt = new int[256];
            String tmp = "";
            for(int j = i;j<s.length();j++){
                if(cnt[s.charAt(j)]==1) break;
                else{
                    cnt[s.charAt(j)]=1;
                    tmp+=s.charAt(j);
                    if(tmp.length() > strMax.length()){ 
                        strMax = tmp;
                        ans = tmp.length();
                    }
                }
            }
        }
        res = String.format("%s;%d", strMax, ans);
        System.out.println(res);
        //
        out.write(res.getBytes());
        out.flush();
    }
}
