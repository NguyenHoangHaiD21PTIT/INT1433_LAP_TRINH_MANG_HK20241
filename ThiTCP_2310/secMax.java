package ThiTCP_2310;
import java.io.*;
import java.net.*;
import java.util.*;
public class secMax {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //
        String ma = "B21DCCN370;4XNRzWzl";
        out.write(ma.getBytes());
        out.flush();
        //
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //
        String[] t = s.trim().split(",");
        ArrayList<Integer>a = new ArrayList<>(), b = new ArrayList<>();
        for(String x: t){
            int x1 = Integer.parseInt(x);
            a.add(x1); b.add(x1);
        }
        Collections.sort(a);
        int secMax = a.get(a.size() - 2), pos = 0;
        for(int i = 0;i<b.size();i++){
            if(b.get(i)==secMax) pos = i;
        }
        String res = String.format("%d,%d", secMax, pos);
        System.out.println(res);
        out.write(res.getBytes());
        out.flush();
        in.close();
        out.close();
        socket.close();
    }
}
/*
[Mã câu hỏi (qCode): 0lhEivaG].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách nhau bởi ký tự ",". Ví dụ: 1,3,9,19,33,20
c.	Tìm và gửi lên server giá trị lớn thứ hai cùng vị trí xuất hiện của nó trong chuỗi.Ví dụ: 20,5
d.	Đóng kết nối và kết thúc chương trình.
*/