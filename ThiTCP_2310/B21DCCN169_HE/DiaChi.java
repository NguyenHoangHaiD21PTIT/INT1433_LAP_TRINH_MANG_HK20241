package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import TCP.Address;
public class DiaChi {
    public static String loaiBo1 (String s){ //Loại bỏ ký tự đặc biệt
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x) || Character.isDigit(x)) ans+=String.format("%c", x);
        }
        return ans;
    }
    public static String chuanHoa1 (String s){ //Chuẩn hoá địa chỉ
        String ans = "";
        String []tmp = s.trim().split("\\s+");
        for(String x: tmp) ans+=loaiBo1(x) + " ";
        return ans;
    }
    public static String loaiBo2 (String s){ //Loại bỏ ký tự đặc biệt
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isDigit(x) || x=='-') ans+=String.format("%c", x);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String code = "B21DCCN377;4Hk2Ww16";
        out.writeObject(code);
        out.flush();
        Address ad = (Address)in.readObject();
        System.out.println(ad);
        ad.setAddressLine(chuanHoa1(ad.getAddressLine()));
        ad.setPostalCode(loaiBo2(ad.getPostalCode()));
        System.out.println(ad);
        out.writeObject(ad);
        out.flush();
        in.close();out.close();socket.close();
    }
}
