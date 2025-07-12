package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class DaoNguocDoanDaiK {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN169;dCNDHojG";
        out.writeUTF(code);
        out.flush();
        //Nhận k và dãy số
        int k = in.readInt(); System.out.println(k);
        String s = in.readUTF(); System.out.println(s);
        //Chuyển chuỗi thành dãy số
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x.trim()));
        //Chuyển vào dãy kết quả
        ArrayList<Integer>res = new ArrayList<>();
        int n = a.size();
        for(int i = 0;i<n;i+=k){
            int j = Math.min(i + k - 1, n - 1);
            for(int o = j; o >= i; o--) res.add(a.get(o)); //Đưa từng đoạn đảo ngược
        }
        String ans = "";
        for(int i = 0;i<n;i++){
            ans+=String.format("%d", res.get(i));
            if(i!=n-1) ans+=",";
        }
        System.out.println(ans);
        out.writeUTF(ans);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}