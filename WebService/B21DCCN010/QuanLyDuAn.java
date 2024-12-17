package WebService.B21DCCN010;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import vn.medianews.*;
import java.util.*;
import javax.xml.datatype.XMLGregorianCalendar;
import vn.medianews.*;
public class QuanLyDuAn {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN010", qCode = "R6UOuyyE";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Project>a = (List<Project>)port.requestListProject(msv, qCode);
        for(Project p: a) System.out.println(p);
        List<Project> send = new java.util.ArrayList<>();
        for(Project x : a){
            LocalDate end = x.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
            LocalDate start = LocalDate.now();
            long days = ChronoUnit.DAYS.between(start, end);
            if(x.getCompletionPercentage() >= 80 && days <= 15 && days > 0){
                send.add(x);
                System.out.println(x + " " + days);
            }
        }
        port.submitListProject(msv, qCode, send);
    }
}
