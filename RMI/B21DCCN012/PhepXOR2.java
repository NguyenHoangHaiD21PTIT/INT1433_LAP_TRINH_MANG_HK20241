import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.ByteService;
public class PhepXOR2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN012", "4BraNTI5");
        for(byte x: a) System.out.print(x + " ");
        System.out.println();
        //b. Mã hoá
        String tmp = "PTIT";
        byte[] tmpB = tmp.getBytes(); // Chuyển khóa thành mảng byte
        byte[] maHoa = new byte[a.length];
        for(int i = 0;i<a.length;i++) maHoa[i] = (byte) (a[i] ^ tmpB[i % tmpB.length]);
        for(byte x: maHoa) System.out.print(x + " ");
        //c. Gửi
        sv.submitData("B21DCCN012", "4BraNTI5", maHoa);
    }
}
