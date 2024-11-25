package RMI.B21DCCN012;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.BookX;
public class QuanLyThuVien2 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        BookX book = (BookX) sv.requestObject("B21DCCN012", "CoWosBho");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(tmp[tmp.length - 1].length() - 1);
        code+=String.format("%02d%d%d", book.getYearPublished()%100, 
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c. 
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}
