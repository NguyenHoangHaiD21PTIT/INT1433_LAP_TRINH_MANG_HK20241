package RMI.B21DCCN012;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class DoiTien {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN012", "Iz06p8Zw"), res = 0;
        System.out.println(n);
        // b. Xử lý: Tìm số đồng tiền
        String ans = "";
        int[] a = {1, 2, 5, 10}; 
        for (int i = 3; i >= 0; i--) {
            int p = n / a[i]; 
            if (p > 0) {
                res += p; 
                n -= p * a[i]; 
                for (int j = 0; j < p; j++) ans+=a[i] + ",";
            }
        }
        if (n > 0) ans = "-1";
        else {
            ans = ans.substring(0, ans.length() - 1);
            ans= String.format("%d; ", res) + ans;
        }
        System.out.println(ans);
        // c. Gửi kết quả
        sv.submitData("B21DCCN012", "Iz06p8Zw", ans);
    }
}


