package WebService.B21DCCN001;

import vn.medianews.*;
import java.util.*;

public class QuanLySinhVien {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN001", qCode = "2RjVBzv0"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();

        // Lấy danh sách sinh viên từ server
        List<StudentY> a = (List<StudentY>) port.requestListStudentY(msv, qCode);
        System.out.println("Danh sách nhận được từ server:");
        for (StudentY x : a) System.out.println(x);
        System.out.println();

        // Lọc sinh viên đạt điểm cao nhất theo từng môn học
        Map<String, StudentY> hsg = new HashMap<>();
        for (StudentY x : a) {
            String mon = x.getSubject();
            if (!hsg.containsKey(mon) || x.getScore() > hsg.get(mon).getScore()) {
                hsg.put(mon, x);
            }
        }

        // Chuyển danh sách từ Map sang List
        List<StudentY> ans = new java.util.ArrayList<>(hsg.values());

        // Sắp xếp danh sách theo thứ tự tăng dần của subject
        ans.sort(Comparator.comparing(StudentY::getSubject));

        // In danh sách trước khi gửi
        System.out.println("Danh sách gửi lên server:");
        for (StudentY x : ans) System.out.println(x);

        // Gửi danh sách đã sắp xếp lên server
        port.submitListStudentY(msv, qCode, ans);
    }
} 
//Đang bug
