import java.io.*;
import java.net.*;
import java.util.*;
public class MaHoaCaesar {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String code = "B22DCCN146;doW5fnkq";
        out.writeUTF(code);
        out.flush();
        String s = in.readUTF(); int k = in.readInt();
        System.out.println(s + " " + k);
        String ans = "";
        for(char x: s.toCharArray()){
            if (Character.isLetter(x)) {
                char base = Character.isUpperCase(x) ? 'A' : 'a';
                x = (char) (((x - base - k + 26) % 26) + base);
            }
            ans+=x;
        }
        System.out.println(ans);
        out.writeUTF(ans);
        out.flush();
    }
}
