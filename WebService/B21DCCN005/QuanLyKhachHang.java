package WebService.B21DCCN005;
import java.util.*;
import java.time.*;
import javax.xml.datatype.XMLGregorianCalendar;
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
        List<CustomerY> ans = new java.util.ArrayList<>();
        for (CustomerY customer : cus) {
            LocalDate lastTransactionDate = toLocalDate(customer.getLastTransactionDate());
            if (lastTransactionDate.isBefore(today.minusMonths(6))) ans.add(customer);
        }
        for (CustomerY x: ans) System.out.println(x);
        port.submitListCustomerY(msv, qCode, ans);
    }
    private static LocalDate toLocalDate(XMLGregorianCalendar calendar) {
        return calendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }
}
