package WebService.B21DCCN025;
import vn.medianews.*;
import java.util.*;
public class HeCoSo8 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN025", qCode = "QBDJ1GGL"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        //int n = a.get(0);
        int n = 64;
        String oct = Integer.toOctalString(n), hex = Integer.toHexString(n);
        List<String>res = new ArrayList<>(Arrays.asList(oct, hex));
        System.out.println(res);
        //port.submitDataString(msv, qCode, n);
    }
}
