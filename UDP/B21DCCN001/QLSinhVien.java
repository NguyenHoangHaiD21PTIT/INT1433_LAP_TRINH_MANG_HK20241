package UDP.B21DCCN001;
import UDP.Student;
import java.io.*;
import java.net.*;
public class QLSinhVien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN001;QABGDFxd";
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
        Student student = (Student) ois.readObject();
        System.out.println(student);

        // c. Chỉnh sửa đối tượng theo yêu cầu
        //Chuẩn hoá tên
        String name = student.getName();
        String[] words = name.trim().split("\\s+");
        name = "";
        for(String x: words) name+=Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        student.setName(name.trim());
        //Tạo email
        String email = words[words.length - 1].toLowerCase();
        for(int i = 0;i<words.length - 1;i++) email+=Character.toLowerCase(words[i].charAt(0));
        email+="@ptit.edu.vn";
        student.setEmail(email);
        System.out.println(student);
        
        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];                
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}