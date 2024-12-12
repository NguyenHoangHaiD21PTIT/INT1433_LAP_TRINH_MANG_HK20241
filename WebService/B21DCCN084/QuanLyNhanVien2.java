package WebService.B21DCCN084;
import vn.medianews.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX"; 
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
        start.setTime(e.getStartDate().toGregorianCalendar().getTime());
        end.setTime(e.getEndDate().toGregorianCalendar().getTime());
        int workingDays = 0;
        while (!start.after(end)) {
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) workingDays++;
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        e.setWorkingDays(workingDays);
        port.submitEmployee(msv, qCode, e);
        System.out.println(e);
    }
}
