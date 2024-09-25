package ThiThu;
import java.io.*;
import java.net.*;
public class DaoNguocChuoi {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.188.19.218", 1605);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String ma = "B21DCCN768;BdxyEqh";
        out.writeUTF(ma);
        out.flush();
        String s = in.readUTF();
        String q = "";
        for(int i = s.length() - 1;i>=0;i--) q+=s.charAt(i);
        out.writeUTF(q);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
