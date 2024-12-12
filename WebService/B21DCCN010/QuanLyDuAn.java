package WebService.B21DCCN010;
import java.time.LocalDate;
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
        List<Project> done = new java.util.ArrayList<>();
        //Không AC được
    }
}











