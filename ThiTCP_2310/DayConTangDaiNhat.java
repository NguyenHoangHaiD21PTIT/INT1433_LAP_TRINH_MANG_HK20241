package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class DayConTangDaiNhat {
    public static void main(String[] args) throws Exception{
        //
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //
        String code = "B21DCCN001;XGIm2Fc7";
        out.write(code.getBytes());
        out.flush();
        //
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        int []tang = new int[n];
        for(int i = 0;i<n;i++) tang[i] = 1;
        for(int i=0;i<n-1;i++){
            if(a.get(i + 1) > a.get(i)) tang[i+1] = tang[i] + 1;
	}
        int res = tang[0];
        for(int i = 1;i<n;i++) res = Math.max(res, tang[i]); 
        System.out.println(res);
        //
        String q = res + "";
        out.write(q.getBytes());
        out.flush();
        //
        in.close();
        out.close();
        socket.close();
    }
}
//Đề đang chặn data??
