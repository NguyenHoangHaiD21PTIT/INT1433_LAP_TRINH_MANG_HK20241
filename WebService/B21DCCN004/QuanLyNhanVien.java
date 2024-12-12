package WebService.B21DCCN004;
import vn.medianews.*;
import java.util.*;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN004", qCode = "vewbvojZ"; 
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort(); 
        List<EmployeeY>a = port.requestListEmployeeY(msv, qCode);
        for(EmployeeY x: a) System.out.println(x);
        Collections.sort(a, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        System.out.println();
        for(EmployeeY x: a) System.out.println(x);
        port.submitListEmployeeY(msv, qCode, a);
    }
}
