package WebService.B21DCCN003;
import vn.medianews.*;
import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        //List<Integer>a = port.getData(msv, qCode);
        List<Integer>a = new ArrayList<>(Arrays.asList(3, 5, 1, 4, 2));
        System.out.println(a);
        int k = a.get(0);
        Collections.sort(a);
        List<Integer>ans = new ArrayList<>();
        ans.add(a.get(a.size() - k - 1)); ans.add(a.get(k));
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, 0);
    }
}
