package ThiTCP_2310;
import java.io.*;
import java.net.*;
import java.util.*;
public class TungXucXac {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN370;PpWEQ6F0";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt();
        int []a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = in.readInt();
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int []cnt = new int[15];
        for(int x: a) cnt[x]++;
        for(int i = 1;i<=6;i++){
            out.writeFloat((float)cnt[i]/n);
            System.out.print((float)cnt[i]/n + " ");
        }
        in.close();
        out.close();
        socket.close();
    }
}
