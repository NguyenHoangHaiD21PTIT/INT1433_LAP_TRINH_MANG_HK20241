import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
//Khung chung các bài làm dạng Data
public class Data {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw"); //Thay tương ứng MSV mã câu hỏi vào
        //Chú ý thay kiểu dữ liệu tương ứng và ép kiểu, cú pháp tương tự
        //Ví dụ đề bài cần String thì ghi: String x = (String)sv.requestData (MSV, mã đề)
        //Ta tiếp tục xử lý với inp nhận được...
        
        // b. Xử lý: 
        //Tuỳ vào đề thi, các bạn sẽ cần gửi trả lại server một cái gì đấy, xâu, số, v.v..
        //Ở đây mình giả sử sau 1001 bước xử lý thì kết quả ta thu được là một biến int res chẳng hạn
        int res = 0;
        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", res); //Chú ý thay MSV mã đề tương ứng
    }
}
