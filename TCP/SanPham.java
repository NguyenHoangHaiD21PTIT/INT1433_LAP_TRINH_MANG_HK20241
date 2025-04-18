package TCP;
import java.io.*;
import java.net.*;
import TCP.Product;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        //a.
        String code = "B21DCCN370;151GNZvT";
        out.writeObject(code);
        out.flush();
        //b.
        Product product = (Product) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        int x = (int) product.getPrice();
        int tong = 0;
        while(x > 0){
            tong+=x%10;
            x/=10;
        }
        product.setDiscount(tong);
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        //Đóng kết nối, chú ý là phải có phần này nếu không sẽ bị máy chấm ngoại lệ
        in.close();
        out.close();
        socket.close();
    }
}
