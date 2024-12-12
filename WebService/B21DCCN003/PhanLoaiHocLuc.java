package WebService.B21DCCN003;
import vn.medianews.*;
import java.util.*;
public class PhanLoaiHocLuc {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN003", qCode = "qNfIMvid"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<Student> a = (List<Student>) port.requestListStudent(msv, qCode);
        for(Student x: a) System.out.println(x);
        System.out.println();
        List<Student>ans = new java.util.ArrayList<>();
        for(Student x: a){
            if(x.getScore() >=8.0) ans.add(x);
            else if (x.getScore() < 5) ans.add(x);
        }
        for(Student x: ans) System.out.println(x);
        port.submitListStudent(msv, qCode, ans);
    }
}
