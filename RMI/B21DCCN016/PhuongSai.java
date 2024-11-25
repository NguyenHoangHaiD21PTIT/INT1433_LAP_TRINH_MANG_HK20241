package RMI.B21DCCN016;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class PhuongSai {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN016", "uZMEY3Zg");
        System.out.println(s);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        ArrayList<Double> a = new ArrayList<>();
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        for (String x : tmp) a.add(Double.parseDouble(x));
        int n = a.size(); 
        double tong = 0, tongTmp = 0;
        for (double x : a) tong += x;
        double tbc = tong / (double) n;
        for (double x : a) tongTmp += (x - tbc) * (x - tbc);
        double pSai = tongTmp / n;  
        double doLechChuan = Math.sqrt(pSai);
        System.out.println(pSai);
        System.out.println(doLechChuan);
        // c. Gửi kết quả
        String res = String.format("%.2f : %.2f", pSai, doLechChuan);
        System.out.println(res);
        sv.submitData("B21DCCN016", "uZMEY3Zg", res);
    }
}