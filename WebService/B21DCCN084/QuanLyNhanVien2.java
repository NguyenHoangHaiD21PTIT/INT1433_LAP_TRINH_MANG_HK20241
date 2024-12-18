package WebService.B21DCCN084;
import vn.medianews.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class QuanLyNhanVien2 {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN084", qCode = "L8CainEX"; 
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        Employee e = port.requestEmployee(msv, qCode);
        System.out.println(e);
        String bd = e.getStartDate().toString(), kt = e.getEndDate().toString();
        bd = bd.substring(0, 10); kt = kt.substring(0, 10);
        LocalDate stDay = LocalDate.parse(bd), enDay = LocalDate.parse(kt);
        long tmp = ChronoUnit.DAYS.between(stDay, enDay);
        int cnt = 0;
        for(int i = 0;i<=tmp;i++){
            LocalDate curDay = stDay.plusDays(i);
            if(curDay.getDayOfWeek().getValue()<=5) cnt++;
        }
        e.setWorkingDays(cnt);
        System.out.println(e);
        port.submitEmployee(msv, qCode, e);
    }
}
