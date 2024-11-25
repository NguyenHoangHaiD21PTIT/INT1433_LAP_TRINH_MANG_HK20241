package RMI.B21DCCN015;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class LietKeSoNguyenTo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        // b. Xử lý: Tìm list các SNT
        List<Integer> res = new ArrayList<>();
        for(int i = 2;i<=N;i++){
            if(check(i)==1) res.add(i);
        }
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN015", "NMATI6Zw", res);
    }
    public static int check(int n){//ktra snt
        for(int i = 2;i*i<=n;i++){
            if(n%i==0) return 0;
        }
        return 1;
    }
}
