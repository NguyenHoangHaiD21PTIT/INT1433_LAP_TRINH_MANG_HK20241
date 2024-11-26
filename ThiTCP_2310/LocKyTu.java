package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class LocKyTu {
    public static void main(String[] args) throws Exception{
        //
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //
        String code = "B21DCCN319;TuTa8p7";
        bw.write(code);
        bw.newLine();
        bw.flush();
        //
        String s = br.readLine();
        System.out.println(s);
        //
        bw.write("");
        bw.newLine();
        bw.flush();
        //
        br.close();
        bw.close();
        socket.close();
    }
}
