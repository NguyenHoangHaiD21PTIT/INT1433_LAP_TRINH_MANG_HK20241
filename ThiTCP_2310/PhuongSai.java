import java.io.*;
import java.net.*;
public class PhuongSai{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN624;1pKJUCce";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        int []a = new int[n];
        for(int i = 0;i<n;i++) a[i] = in.readInt();
        int tong = 0;
        for(int i = 0;i<n;i++) tong+=a[i];
        float tbc = (float)tong/n;
        float tmp = 0;
        for(int i = 0;i<n;i++) tmp+=(float)(a[i] - tbc) * (a[i] - tbc);
        float pSai = tmp/n;
        out.writeInt(tong); out.flush();
        out.writeFloat(tbc); out.flush();
        out.writeFloat(pSai); out.flush();
        in.close();
        out.close();
        socket.close();
    }
}