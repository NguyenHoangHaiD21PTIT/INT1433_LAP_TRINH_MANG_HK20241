package WebService.B21DCCN082;
import vn.medianews.*;
import java.util.*;
public class TongCacSo {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN082", qCode = "hnVAHv3I"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int tong = 0;
        for(int x: a) tong+=x;
        System.out.println(tong);
        port.submitDataInt(msv, qCode, tong);
    }
}

