import java.io.*;
import java.net.*;
import java.util.*;
public class TachChuoi {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String code = "B21DCCN718;uQWRjN4f";
        bw.write(code);
        bw.newLine();
        bw.flush();
        String s = br.readLine();
        System.out.println(s);
        String s1 = "", s2 = "";
        for(char x: s.toCharArray()){
            if(Character.isDigit(x)||Character.isAlphabetic(x)) s1+=String.valueOf(x);
            else s2+=String.valueOf(x);
        }
        System.out.println(s1);
        System.out.println(s2);
        //gui s1
        bw.write(s1);
        bw.newLine();
        bw.flush();
        //gui s2
        bw.write(s2);
        bw.newLine();
        bw.flush();
        //đóng kết nối
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();
    }
}
/*
[Mã câu hỏi (qCode): uQWRjN4f].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client thực hiện kết nối tới server và sử dụng luồng ký tự (BufferedWriter/BufferedReader) để trao đổi thông tin theo kịch bản
a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;5E263AE1"
b.	Nhận một chuỗi ngẫu nhiên từ server
c.	Tách chuỗi đã nhận thành 2 chuỗi và gửi lần lượt theo thứ tự lên server
           i.	Chuỗi thứ nhất gồm các ký tự và số (loại bỏ các ký tự đặc biệt)
          ii.	Chuỗi thứ hai gồm các ký tự đặc biệt
d.	Đóng kết nối và kết thúc chương trình
*/
