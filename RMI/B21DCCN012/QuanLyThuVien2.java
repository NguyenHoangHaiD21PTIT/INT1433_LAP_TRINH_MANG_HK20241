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
        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(0);
        code+=String.format("%02d%d%d", book.getYearPublished()%100, 
                book.getGenre().trim().length(), book.getTitle().length()%10);
        book.setCode(code);
        // c. 
        sv.submitObject("B21DCCN012", "CoWosBho", book);
    }
}
//Chưa test được
//package RMI.B21DCCN012;
//import RMI.BookX;
//public class QuanLyThuVien2 {
//    public static void main(String[] args) {
//        BookX book = new BookX("B001", "1234", "Mark Twain", 1884, "Fiction");
//        System.out.println(book);
//        String code = "";
//        String[] tmp = book.getAuthor().split(" ");
//        code+=tmp[0].charAt(0);code+=tmp[tmp.length - 1].charAt(0);
//        code+=String.format("%02d%d%d", book.getYearPublished()%100, 
//                book.getGenre().trim().length(), book.getTitle().length()%10);
//        book.setCode(code);
//        System.out.println(book);
//    }
//}
