package WebService.B21DCCN021;
import vn.medianews.*;
import java.util.*;
public class DonHang2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "CuW1L0ev"; 
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Order>a = (List<Order>)port.requestListOrder(msv, qCode);
        for(Order x: a){
            System.out.println(x);
        }
    }
}
//Data đang rỗng nên chờ làm sau
