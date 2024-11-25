package RMI.B21DCCN564;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;
public class XHMin {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN564", "L7A2NPQU");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[10005]; 
        for (byte x : a) cnt[x]++;
        byte ptuMin = a[0];
        int slMin = cnt[a[0]];
        for (byte x : a) {
            if (cnt[x] < slMin) {
                ptuMin = x;
                slMin = cnt[x];
            }
        }
        System.out.println(ptuMin + " " + slMin);
        // c. Gửi
        byte[] res = {ptuMin, (byte)slMin};
        sv.submitData("B21DCCN564", "L7A2NPQU", res);
    }
}