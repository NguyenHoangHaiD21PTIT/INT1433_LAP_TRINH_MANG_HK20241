package ThiThu;
import java.io.*;
import java.net.*;
public class UCLNVaBCNN {
    public static int UCLN(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.188.19.218", 1605);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN799;JKT5DjN";
        out.writeUTF(code);
        out.flush();
        int a = in.readInt(), b = in.readInt();
        int ucln = UCLN(a, b);
        int bcnn = a * b/ucln;
        out.writeInt(ucln);
        out.writeInt(bcnn);
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
