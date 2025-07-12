package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class DoiChieuBienThien {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN169;oNGj55wV";
        out.writeUTF(code);
        out.flush();
        //Nhận dãy số
        String s = in.readUTF(); System.out.println(s);
        //Chuyển chuỗi thành dãy số
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x.trim()));
        //Chuyển vào dãy kết quả
        int bienThien = 0, n = a.size();
        for(int i = 0;i< n - 1;i++) bienThien+=Math.abs(a.get(i) - a.get(i + 1));
        int doiChieu = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((a.get(i) > a.get(i - 1) && a.get(i) > a.get(i + 1)) ||(a.get(i) < a.get(i - 1) && a.get(i) < a.get(i + 1)))  doiChieu++;
        }
        out.writeInt(doiChieu); System.out.println(doiChieu);
        out.writeInt(bienThien); System.out.println(bienThien);
        in.close(); out.close(); socket.close();
    }
}