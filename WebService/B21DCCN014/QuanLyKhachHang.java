package WebService.B21DCCN014;
import vn.medianews.*;
import java.util.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN014", qCode = "lgKj7lIF"; 
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Customer>a = (List<Customer>)port.requestListCustomer(msv, qCode);
        for(Customer x: a) System.out.println(x);
        List<Customer>ans = new java.util.ArrayList<>();
        for(Customer x: a){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >=5) ans.add(x);
        }
        System.out.println();
        for(Customer x: ans) System.out.println(x);
        port.submitListCustomer(msv, qCode, ans);
    }
}
