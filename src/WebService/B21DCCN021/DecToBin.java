package WebService.B21DCCN021;
import vn.medianews.*;
import java.util.*;
public class DecToBin {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN021", qCode = "2jS1DTpU"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        //int n = a.get(0);
        int n = 9;
        String bin = Integer.toBinaryString(n);
        System.out.println(bin);
        //port.submitDataString(msv, qCode, n);
    }
}
