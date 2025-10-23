package B22DCCN015;
import java.io.*;
import java.net.*;
import java.util.*;
public class SXTheoVTGoc{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN015;aKZwZxWk";
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
        String rqID = tmp[0]; 
        //Cho các xâu còn lại vào mảng
        TreeMap<Integer, String> mp = new TreeMap<>();
        for(int i = 1; i < tmp.length; i++){
            String []tmp_i = tmp[i].split(":");
            mp.put(Integer.parseInt(tmp_i[1]), tmp_i[0]);
        }
        //Tạo kết quả
        String ans = rqID + ";";
        int ok = 0;//ok = 1: Là xâu đầu
        for(String x: mp.values()){
            if(ok == 1) ans += ",";
            ans += x; ok = 1;
        }
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): aKZwZxWk].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
---string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"
c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"
d. Đóng socket và kết thúc chương trình.
*/
