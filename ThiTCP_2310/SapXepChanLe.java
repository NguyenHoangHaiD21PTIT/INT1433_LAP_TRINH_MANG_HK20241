package ThiTCP_2310;
import java.io.*;
import java.net.*;
import java.util.*;
public class SapXepChanLe {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN222;rMdCliDV";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead).trim();
        System.out.println("b. Received from server: " + s);
        String[] a = s.split(",");
        ArrayList<Integer> chan = new ArrayList<>(), le = new ArrayList<>();
        for (String x : a) {
            int x1 = Integer.parseInt(x.trim());  
            if (x1 % 2 == 0) chan.add(x1);
            else le.add(x1);
        }
        Collections.sort(chan);
        Collections.sort(le);
        StringBuilder ans = new StringBuilder("[");
        for (int i = 0; i < chan.size(); i++) {
            ans.append(chan.get(i));
            if (i != chan.size() - 1) ans.append(", ");
        }
        ans.append("];[");
        for (int i = 0; i < le.size(); i++) {
            ans.append(le.get(i));
            if (i != le.size() - 1) ans.append(", ");
        }
        ans.append("]");
        System.out.println("d. Sending to server: " + ans.toString());
        out.write(ans.toString().getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
