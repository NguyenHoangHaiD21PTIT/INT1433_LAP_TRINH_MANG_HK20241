package RMI;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;
public class snt {
    public static void main(String[] args) throws Exception {
        //a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN015", "nD8MdtME");
        System.out.println(N);
        //b. Xử lý
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) primes.add(i);
        }
        // c. Gửi
        sv.submitData("B21DCCN015", "nD8MdtME", primes);
        System.out.println(primes);
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
/*
[Mã câu hỏi (qCode): nD8MdtME].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một số nguyên dương N từ server, đại diện cho giới hạn trên của khoảng cần kiểm tra.
b. Thực hiện tìm tất cả các số nguyên tố trong khoảng từ 1 đến N. Ví dụ: Với N = 10, kết quả là danh sách các số nguyên tố “2, 3, 5, 7”.
c. Triệu gọi phương thức submitData để gửi List< Integer> danh sách các số nguyên tố đã tìm được trở lại server.
d. Kết thúc chương trình client.
*/
