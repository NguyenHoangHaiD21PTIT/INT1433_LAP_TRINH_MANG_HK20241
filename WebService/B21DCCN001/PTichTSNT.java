package WebService.B21DCCN001;
import vn.medianews.*;
import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "TwZpbqUg"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer> a = port.getData(msv, qCode);
        System.out.println(a);
        List<vn.medianews.ArrayList> res = new java.util.ArrayList<>();
        for (int x : a) {
            vn.medianews.ArrayList tmp = new vn.medianews.ArrayList();
            for (int i = 2; i * i <= x; i++) {
                while (x % i == 0) {
                    x /= i;
                    tmp.getItem().add(i);  
                }
            }
            if (x > 1) tmp.getItem().add(x);  
            res.add(tmp);
        }
        System.out.println(res.get(0).getItem());
        port.submitDataIntMatrix(msv, qCode, res);
    }
}
//Chờ
