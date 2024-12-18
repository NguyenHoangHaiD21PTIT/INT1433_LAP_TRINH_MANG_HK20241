package WebService.B21DCCN005;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
public class QuanLyKhachHang {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "aYiLQ3wo";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<CustomerY> cus = (List<CustomerY>) port.requestListCustomerY(msv, qCode);
        for (CustomerY x: cus) System.out.println(x);
        System.out.println();
        LocalDate today = LocalDate.now();
        List<CustomerY> ans = new ArrayList<>();
        for (CustomerY x: cus) {
            String t = x.getLastTransactionDate().toString();
            t = t.substring(0, 10);
            LocalDate old = LocalDate.parse(t);
            long thang = ChronoUnit.MONTHS.between(old, today);
            if(thang >=6) ans.add(x);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
}
