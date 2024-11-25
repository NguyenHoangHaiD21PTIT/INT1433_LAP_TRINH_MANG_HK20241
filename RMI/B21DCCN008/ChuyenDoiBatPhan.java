package RMI.B21DCCN008;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;
public class ChuyenDoiBatPhan {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN008", "HhPAxeDw");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. Chuyển đổi mảng byte thành chuỗi bát phân
        String res = "";
        for (byte x : a) res+=String.format("%03o", x & 0xFF);
        System.out.println(res);
        byte[] ans = res.toString().getBytes();
        sv.submitData("B21DCCN008", "HhPAxeDw", ans);
    }
}

