package ThiThu;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TongCacSo {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.188.19.218", 1604);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String ma = "B21DCCN307;PUh9Ki1";
        out.write(ma.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        String[] t = s.trim().split("\\|");
        int tong = 0;
        for(String x: t) tong+=Integer.parseInt(x);
        String res = String.valueOf(tong);
        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
