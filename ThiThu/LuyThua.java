package ThiThu;
import java.io.*;
import java.net.*;
public class LuyThua {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.188.19.218", 1604);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN768;Yi0enkF";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        String[] a = s.trim().split("\\|");
        int x = Integer.parseInt(a[0]), y = Integer.parseInt(a[1]);
        int z = (int) Math.pow(x, y);
        System.out.println(z);
        String res = String.valueOf(z);
        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
