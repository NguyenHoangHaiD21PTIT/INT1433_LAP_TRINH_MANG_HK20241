package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class SapXepTheoDoDai {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN169;we3kcWxZ";
        bw.write(code); bw.newLine(); bw.flush();
        //Nhận xâu
        String s = br.readLine(); System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        ArrayList<String>a = new ArrayList<>();
        for(String x: tmp) a.add(x);
        int n = a.size();
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        String ans = "";
        for(int i = 0;i<n - 1;i++) ans+=a.get(i) + ", ";
        ans+=a.get(n - 1);
        System.out.println(ans);
        bw.write(ans); bw.newLine(); bw.flush();
    }
}