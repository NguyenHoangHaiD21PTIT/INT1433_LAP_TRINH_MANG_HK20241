package RMI.B21DCCN021;
import RMI.Order;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
public class TDMT {
//    public static void main(String[] args) throws Exception{
//        // a. Tạo đối tượng Order ngẫu nhiên (giả lập nhận từ server)
//        Order order = new Order("O123", "C123456", "2023-10-05", "Express");
//        System.out.println(order);
//        // b. Tạo mã orderCode
//        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
//        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
//        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
//        String orderCode = x + y + z;
//        order.setOrderCode(orderCode);
//        System.out.println(order);
//    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Order order = (Order) sv.requestObject("B21DCCN021", "vLJWvWpf");
        System.out.println(order);
        //b.
        String x = order.getShippingType().substring(0, 2).toUpperCase(); // Hai ký tự đầu của shippingType
        String y = order.getCustomerCode().substring(order.getCustomerCode().length() - 3); // Ba ký tự cuối của customerCode
        String z = order.getOrderDate().substring(8, 10) + order.getOrderDate().substring(5, 7); // ddMM từ orderDate
        String orderCode = x + y + z;
        order.setOrderCode(orderCode);
        //c
        System.out.println(order);
        sv.submitObject("B21DCCN021", "vLJWvWpf", order);
    }
}
//Chưa test được
