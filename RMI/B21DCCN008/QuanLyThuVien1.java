package RMI.B21DCCN008;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Book;
public class QuanLyThuVien1 {
    public static void main(String[] args) throws Exception {
        //a. Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Book book = (Book) sv.requestObject("B21DCCN008", "nCOdwcKJ");
        System.out.println(book);
        //Tạo mã
        String code = "";
        String[] tmp = book.getAuthor().split(" ");
        code+=String.format("%c%c", Character.toUpperCase(tmp[0].charAt(0)), Character.toUpperCase(tmp[tmp.length - 1].charAt(0)));
        code+=String.format("%02d%d%03d", book.getYearPublished()%100, 
                book.getTitle().trim().length(), book.getPageCount());
        book.setCode(code);
        System.out.println(book);
        // c. 
        sv.submitObject("B21DCCN008", "nCOdwcKJ", book);
    }
}



