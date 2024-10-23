package ThiTCP_2310;
import java.io.*;
import java.net.*;
import java.util.*;
public class SapXepChuoi {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN624;CZMrJdmx";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String []a = s.trim().split("\\s+");
        ArrayList<String>res = new ArrayList<>();
        String q = "";
        for(String x: a) res.add(x);
        Collections.sort(res);
        for(int i = 0;i<res.size() - 1;i++) q+=res.get(i) + " ";
        q+=res.get(res.size() - 1);
        bw.write(q);
        System.out.println(q);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
/*
[Mã câu hỏi (qCode): CZMrJdmx].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng một chương trình client thực hiện kết nối tới server và sử dụng luồng ký tự (BufferedWriter/BufferedReader) để trao đổi thông tin theo kịch bản sau:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;X1107ABC".
b. Nhận từ server một chuỗi ngẫu nhiên chứa nhiều từ, các từ phân tách bởi khoảng trắng.
c. Thực hiện các bước xử lý:
    Bước 1: Tách chuỗi thành các từ dựa trên khoảng trắng.
    Bước 2: Sắp xếp các từ theo thứ tự từ điển (có phân biệt chữ cái hoa thường).
d. Gửi lại chuỗi đã sắp xếp theo thứ tự từ điển lên server.
e. Đóng kết nối và kết thúc chương trình.
*/
