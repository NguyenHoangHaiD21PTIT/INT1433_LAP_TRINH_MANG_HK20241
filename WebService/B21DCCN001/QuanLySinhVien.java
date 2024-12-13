package WebService.B21DCCN001;
import vn.medianews.*;
import java.util.*;
public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        for (StudentY x : a) System.out.println(x);
        System.out.println();
        Map<String, Float> hsg = new HashMap<>(); //key: tên môn, value: điểm thi cao nhất môn đó
        for(StudentY x: a){
            String mon = x.getSubject();
            Float diemMon = x.getScore();
            if ((!hsg.containsKey(mon)) || (diemMon > hsg.get(mon))) hsg.put(mon, diemMon);
        }
        List<Float>diemMax = new java.util.ArrayList<>(hsg.values());
        List<StudentY>ans = new java.util.ArrayList<>();
        for(StudentY x: a){
            if(diemMax.contains(x.getScore())) ans.add(x);
        }
        port.submitListStudentY(msv, qCode, ans);
    }
} 

