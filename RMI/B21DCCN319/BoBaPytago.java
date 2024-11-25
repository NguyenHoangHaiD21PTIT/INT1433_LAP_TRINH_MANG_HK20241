package RMI.B21DCCN319;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class BoBaPytago {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");
        System.out.println(N);
        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    if (a * a + b * b == c * c) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(a); triple.add(b); triple.add(c);
                        res.add(triple);
                    }
                }
            }
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res);
    }
}
