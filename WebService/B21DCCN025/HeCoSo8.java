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
        List<String>res = new java.util.ArrayList<>();
        for(int n: a){
            String oct = Integer.toOctalString(n), hex = Integer.toHexString(n).toUpperCase();
            String tmp = oct + "|" + hex;
            res.add(tmp);
        }
        System.out.println(res);
        port.submitDataStringArray(msv, qCode, res);
    }
}

