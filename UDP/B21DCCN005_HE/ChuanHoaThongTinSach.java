package B21DCCN005_HE;
import UDP.Book;
import java.io.*;
import java.net.*;
import java.util.*;
public class ChuanHoaThongTinSach {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoaTitle(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaISBN(String s){
        //Ví dụ: Input: 9783161484100. Ouput: 978-3-16-148410-0
        return String.format("%s-%s-%s-%s-%s", s.substring(0, 3), s.substring(3, 4), s.substring(4, 6), s.substring(6, 12), s.substring(12));                
    }
    public static String chuanhoaAuthor(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = tmp[0].toUpperCase() + ", ";
        for(int i = 1;i < tmp.length; i++) ans += chuanHoa1(tmp[i]) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[1] + "/" + part[0]; 
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;LFACr5Bi";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];  
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);
        // Lấy (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Book book = (Book) ois.readObject();
        System.out.println(book);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        book.setTitle(chuanhoaTitle(book.getTitle()));
        book.setAuthor(chuanhoaAuthor(book.getAuthor()));
        book.setIsbn(chuanhoaISBN(book.getIsbn()));
        book.setPublishDate(chuanhoaNgay(book.getPublishDate()));
        System.out.println(book);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(book);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];                
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
