package ThiChinhThuc_01;
import java.io.*;
import java.net.*;
public class TungXucXac_Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 807);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN319;001";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        int[] cnt = new int[10];
        String s = in.readUTF();
        String[]a = s.trim().split(",");
        for(String x: a) cnt[Integer.parseInt(x)]++;
        float[] ans = new float[10];
        for(int i = 1;i<=6;i++) ans[i] = (float)cnt[i]/n;
        for(int i = 1;i<=6;i++) out.writeFloat(ans[i]);
    }
}
