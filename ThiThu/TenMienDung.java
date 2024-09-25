package ThiThu;
import java.io.*;
import java.net.*;
import java.util.*;
public class TenMienDung {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.188.19.218", 1606);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN174;m1NkVqY";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String []a = s.trim().split("\\, ");
        ArrayList<String>res = new ArrayList<>();
        String q = "";
        for(String x: a){
            if(x.endsWith(".edu")) res.add(x);
        }
        for(int i = 0;i<res.size() - 1;i++) q+=res.get(i) + ", ";
        q+=res.get(res.size() - 1);
        bw.write(q);
        System.out.println(q);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
