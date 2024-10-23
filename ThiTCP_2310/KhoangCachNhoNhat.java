package ThiTCP_2310;
import java.io.*;
import java.net.*;
import java.util.*;
public class KhoangCachNhoNhat{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN624;TbzkNfL3";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        ArrayList<Integer>a = new ArrayList<>();
        String []a1 = s.trim().split(",");
        for(String x: a1) a.add(Integer.parseInt(x));
        Collections.sort(a);
        int ans = 1000; 
        int lon = 0, be = 0;
        for(int i = a.size() - 1;i>=1;i--){
            if(a.get(i) - a.get(i - 1) < ans){
                ans = a.get(i) - a.get(i - 1);
                lon = a.get(i); be = a.get(i - 1);
            }
        }
        String q = "";
        q = String.valueOf(ans) + "," + String.valueOf(be) + "," + String.valueOf(lon);
        System.out.println(q);
        out.write(q.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
[Mã câu hỏi (qCode): TbzkNfL3].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;FF49DC02"
b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách nhau bởi ký tự ","
Ex: 1,3,9,19,33,20
c.	Thực hiện tìm giá trị khoảng cách nhỏ nhất của các phần tử nằm trong chuỗi và hai giá trị lớn nhất tạo nên khoảng cách đó. Gửi lên server chuỗi gồm "khoảng cách nhỏ nhất, số thứ nhất, số thứ hai". Ex: 1,19,20
d.	Đóng kết nối và kết thúc
*/