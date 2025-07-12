package B21DCCN377_HE;
import java.io.*;
import java.net.*;
import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B21DCCN377;0LTGyX4p";
        out.writeUTF(code);
        out.flush();
        int n = in.readInt(); System.out.println(n);
        String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
        out.writeUTF(oct + ";" + hex); out.flush();
        in.close();out.close();socket.close();
    }
}