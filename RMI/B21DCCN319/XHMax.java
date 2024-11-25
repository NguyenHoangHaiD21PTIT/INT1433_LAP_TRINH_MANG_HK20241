package RMI.B21DCCN319;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;
public class XHMax {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN319", "1mPMIkGJ");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. Đếm
        int[] cnt = new int[128]; 
        for (byte x : a) cnt[x]++;
        byte ptuMax = a[0];
        int slMax = cnt[ptuMax];
        for (byte x : a) {
            if (cnt[x] > slMax) {
                ptuMax = x;
                slMax = cnt[x];
            }
        }
        System.out.println(ptuMax + " " + slMax);
        // c. Gửi
        byte[] res = {ptuMax, (byte) slMax};
        sv.submitData("B21DCCN319", "1mPMIkGJ", res);
    }
}
