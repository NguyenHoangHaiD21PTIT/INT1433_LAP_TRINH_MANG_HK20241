package WebService.B21DCCN002;
import vn.medianews.*;
import java.util.*;
public class QuanLySanPham {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN002", qCode = "itT8hvxF"; // Mã câu hỏi
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        ProductY product = (ProductY) port.requestProductY(msv, qCode);
        System.out.println(product);
        float price = product.getPrice(), taxRate = product.getTaxRate(),discount = product.getDiscount();
        float finalPrice = price * (1 + taxRate / 100) * (1 - discount / 100);
        product.setFinalPrice(finalPrice);
        System.out.println(product);
        port.submitProductY(msv, qCode, product);
    }
}
