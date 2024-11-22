package RMI.B21DCCN319;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Product;
public class XuLySanPham {
    public static void main(String[] args) throws Exception {
        //Nhận sản phẩm từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Product product = (Product) sv.requestObject("B21DCCN319", "dx3nt4Ij");
        System.out.println("Truoc chuan hoa: " + product);
        // b. Thực hiện chuẩn hóa sản phẩm:
        product.setCode(product.getCode().toUpperCase());// Chuyển mã sản phẩm thành in hoa
        product.setExportPrice(product.getImportPrice() * 1.2f);// Cập nhật giá xuất (exportPrice) bằng giá nhập (importPrice) + 20%
        System.out.println("Sau chuan hoa: " + product);
        // c. Gửi ngược lên server
        sv.submitObject("B21DCCN319", "dx3nt4Ij", product);
    }
}
