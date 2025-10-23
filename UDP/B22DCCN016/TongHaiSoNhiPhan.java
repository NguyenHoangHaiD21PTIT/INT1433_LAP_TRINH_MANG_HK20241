package B22DCCN016;
import java.io.*;
import java.net.*;
import java.util.*;
public class TongHaiSoNhiPhan{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;
        //a.
        String code = ";B22DCCN016;lIQVug9S";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b.
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //In chuỗi đề cho
        String st = new String(dpNhan.getData());
        System.out.println(st);
        st = st.replace(",", " "); st = st.replace(";", " ");
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; long b1 = Integer.parseInt(tmp[1], 2); long b2 = Integer.parseInt(tmp[2], 2);
        long tong = b1 + b2;
        String ans = String.format("%d", tong);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): lIQVug9S].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2208. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN000;XbYdNZ3”.
b. Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;b1,b2”, trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    b1 là số nhị phân thứ nhất
    b2 là số nhị phân thứ hai.
Ví dụ: requestId;0100011111001101,1101000111110101
c. Thực hiện tính tổng hai số nhị phân nhận được, chuyển về dạng thập phân và gửi lên server theo định dạng “requestId;sum”
Kết quả: requestId;72130 
d. Đóng socket và kết thúc chương trình.
*/
