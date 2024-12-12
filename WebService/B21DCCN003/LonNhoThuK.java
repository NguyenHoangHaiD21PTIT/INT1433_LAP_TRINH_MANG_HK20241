package WebService.B21DCCN003;
import vn.medianews.*;
import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int k = a.get(0);
        Collections.sort(a);
        List<Integer>ans = new java.util.ArrayList<>();
        port.submitDataIntArray(qCode, qCode, a);
        int x = a.get(a.size() - k - 1), y = a.get(k);
        ans.add(x); ans.add(y);
        port.submitDataIntArray(msv, qCode, ans);
        System.out.println(ans);
    }
}
//Chờ log
