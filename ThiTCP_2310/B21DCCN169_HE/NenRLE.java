package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class NenRLE {
    public static String xauDao(String s){
        String res = "";
        for(int i = s.length() - 1;i>=0;i--) res+=String.format("%c", s.charAt(i));
        return res;
    }
    public static String RLE(String s){
        int cnt = 1;
        String ans = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))cnt++;
            else {
                ans+=String.format("%c", s.charAt(i - 1));
                if(cnt >=2) ans+= String.format("%d", cnt);
                cnt = 1;
            }
        }
        ans+=String.format("%c", s.charAt(s.length() - 1));
        if(cnt >=2) ans+= String.format("%d", cnt);
        return ans;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN169;ji3fQD3Q";
        bw.write(code); bw.newLine(); bw.flush();
        //Nhận xâu
        String s = br.readLine(); System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        ArrayList<String>a = new ArrayList<>();
         // Đảo ngược từng từ rồi nén RLE
        for (String word : tmp) {
            String dao = xauDao(word);
            String nen = RLE(dao);
            a.add(nen);
        }
        // Ghép lại thành chuỗi kết quả
        String res = String.join(" ", a);
        System.out.println(res);
        bw.write(res); bw.newLine(); bw.flush();
        br.close();
        bw.close();
        socket.close();
    }

}
