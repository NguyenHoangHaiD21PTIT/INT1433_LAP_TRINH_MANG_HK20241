package B21DCCN005_HE;
import UDP.Employee;
import java.io.*;
import java.net.*;
import java.util.*;
public class QuanLyTTNhanVien {
    public static String chuanHoa1(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanHoaTen(String s){
        String []tmp = s.trim().split("\\s+");
        String ans = "";
        for(String x: tmp) ans += chuanHoa1(x) + " ";
        ans = ans.substring(0, ans.length() - 1);
        return ans;
    }
    public static String chuanhoaNgay(String s){
        s = s.replace("-", " ");
        String[] part = s.split("\\s+");
        return part[2] + "/" + part[1] + "/" + part[0]; 
    }
    //Đã chuẩn hoá ngày rồi thì muốn tăng phải lấy theo ngày đã chuẩn hoá
    public static double tangLuong (String ngay, double luongCu){
        ngay = ngay.replace("/", " ");
        String[] part = ngay.split("\\s+");
        int tong = 0;
        for (char c : part[2].toCharArray()) tong += c - '0'; 
        double luongMoi = luongCu * (1 + tong / 100.0);
        return luongMoi;
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN005;ySsumsIE";
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
        Employee emp = (Employee) ois.readObject();
        System.out.println(emp);
        // c. Chỉnh sửa đối tượng theo yêu cầu
        emp.setName(chuanHoaTen(emp.getName()));
        emp.setHireDate(chuanhoaNgay(emp.getHireDate()));
        emp.setSalary(tangLuong(emp.getHireDate(), emp.getSalary()));
        System.out.println(emp);
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(emp);
        oos.flush();
        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];                
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
