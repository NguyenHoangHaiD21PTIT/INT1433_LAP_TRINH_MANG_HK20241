package RMI;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
//import RMI.tên lớp;
//Ví dụ
import RMI.Book;
public class Object {
    public static void main(String[] args) throws Exception{
        //a. Nhận đối tượng từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        //Tên lớp a = (Tên lớp)sv.requestObject(Mã sinh viên, Mã câu hỏi); //Chú ý ép kiểu
        //Ví dụ: 
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        
        //b. Xử lý đối tượng
        //Sau bước này, ta thu được đối tượng book đã xử lý chẳng hạn
        
        //c. Gửi lại
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);//Thay MSV mã câu hỏi và tên đối tượng tương ứng
    }
}
