package WebService.B21DCCN003;
import vn.medianews.*;
import java.util.*;
public class LonNhoThuK {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN003", qCode = "WpaUTFMu"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        int k = a.get(0); a.remove(0);
        System.out.println(a + " " + k);
        Collections.sort(a);
        int nhoThuK = a.get(k - 1), lonThuK = a.get(a.size() - k);
        List<Integer>ans = new java.util.ArrayList<>(Arrays.asList(lonThuK, nhoThuK));
        port.submitDataIntArray(msv, qCode, ans);
    }
}

