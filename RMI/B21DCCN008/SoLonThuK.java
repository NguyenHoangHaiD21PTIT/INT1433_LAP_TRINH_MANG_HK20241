package RMI.B21DCCN008;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class SoLonThuK {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}

