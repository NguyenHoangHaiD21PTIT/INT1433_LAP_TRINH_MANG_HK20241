package RMI.B21DCCN008;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class SoLonThu3 {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN008", "wzG6G9ji");
        System.out.println(s);
        //b. Xử lý dữ liệu
        int x = s.indexOf(";");
        String list = s.substring(0, x), k = s.substring(x + 1);
        ArrayList<Integer>a = new ArrayList<>();
        int k1 = Integer.parseInt(k.trim());
        String []tmp = list.trim().split(",");
        for(String x1: tmp) a.add(Integer.parseInt(x1.trim()));
        Collections.sort(a);
        int ans = a.get(a.size() - k1);
        //c. Gửi dữ liệu
        sv.submitData("B21DCCN008", "wzG6G9ji", ans);
        System.out.println(ans);
    }
}
/*
[Mã câu hỏi (qCode): wzG6G9ji].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một chuỗi chứa mảng số nguyên và một số nguyên K từ server với định dạng: “mảng; số nguyên K”.
b. Sử dụng thuật toán phù hợp để tìm phần tử lớn thứ K trong mảng số nguyên đã cho.
Ví dụ: Với Chuỗi “3, 1, 5, 12, 2, 11; 3” nghĩa là mảng [3, 1, 5, 12, 2, 11] và K = 3 -> cần tìm phần tử lớn thứ 3 là 5.
c. Triệu gọi phương thức submitData để gửi kết quả phần tử lớn thứ K đã tìm được trở lại server.
d. Kết thúc chương trình client.
*/
