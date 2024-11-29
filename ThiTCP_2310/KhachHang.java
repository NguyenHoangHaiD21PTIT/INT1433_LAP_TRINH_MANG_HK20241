package TCP;
import java.io.*;
import java.net.*;
import TCP.Customer;
public class KhachHang {
    public static void main(String[] args) throws Exception{
        // Kết nối tới server
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = "B21DCCN004;6Tw3qHNF";
        out.writeObject(code);
        out.flush();
        // b. Nhận đối tượng Customer từ server
        Customer customer = (Customer) in.readObject();
        System.out.println(customer);
        // c. Chuẩn hóa thông tin khách hàng
        //Chuẩn hoá tên
        String []tenTmp = customer.getName().split("\\s+");
        String tenMoi = "";
        tenMoi+=tenTmp[tenTmp.length - 1].toUpperCase()+", ";
        for(int i = 0;i<tenTmp.length - 1;i++) tenMoi+=Character.toUpperCase(tenTmp[i].charAt(0)) + tenTmp[i].substring(1).toLowerCase() + " ";
        customer.setName(tenMoi.trim());
        //Chuẩn hoá ngày sinh
        String []nsTmp = customer.getDayOfBirth().split("-");
        String nsMoi = nsTmp[1] + "/" + nsTmp[0] + "/" + nsTmp[2];
        customer.setDayOfBirth(nsMoi);
        //Tạo username
        String userMoi = "";
        for(int i = 0;i<tenTmp.length - 1;i++) userMoi+=Character.toLowerCase(tenTmp[i].charAt(0));
        userMoi+=tenTmp[tenTmp.length - 1].toLowerCase();
        customer.setUserName(userMoi);
        // d. Gửi lại đối tượng đã được sửa đổi
        System.out.println(customer);
        out.writeObject(customer);
        out.flush();
    }

    
}
