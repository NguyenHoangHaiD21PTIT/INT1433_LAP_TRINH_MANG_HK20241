package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class HieuHaiTapHop {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN003;vYbP7vOA";
        bw.write(code); bw.newLine(); bw.flush();
        String s1 = br.readLine(); System.out.println(s1);
        String s2 = br.readLine(); System.out.println(s2);
        String ans = "";
        int []cnt = new int[10005]; 
        for(char x: s2.toCharArray()) cnt[x]++;
        for(char x: s1.toCharArray()){
            if(cnt[x]==0) ans+=x;
        }
        System.out.println(ans);
        bw.write(ans); bw.newLine(); bw.flush();
    }
}
