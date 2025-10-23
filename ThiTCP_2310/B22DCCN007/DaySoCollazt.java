package B22DCCN007;
import java.io.*;
import java.net.*;
import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        //Gửi mã sinh viên, mã đề
        String code = "B22DCCN007;BDF0CKv5";
        out.write(code.getBytes());
        out.flush();
        //Đọc luồng byte
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        //Nhận số n
        int n = Integer.parseInt(s);
        ArrayList<Integer>ans = new ArrayList<>();
        while (n != 1){
            ans.add(n);
            if (n % 2 == 1) n = 3 * n + 1;
            else n /= 2;
        }
        ans.add(1);
        int S = ans.size();
        String res = "";
        for(int i = 0; i < S - 1; i++) res += String.format("%d ", ans.get(i));
        res += String.format("%d; %d", ans.get(S - 1), S);
        System.out.println(res);
        out.write(res.getBytes()); out.flush();
        //Đóng kết nối
        in.close(); out.close(); socket.close();
    }
}
/*
[Mã câu hỏi (qCode): BDF0CKv5].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b. Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7
c. Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
Gọi n là số hiện tại, n1 là số tiếp theo. Ta có:
•	Nếu n là số chẵn  n1 = n / 2;
•	Nếu n là số lẻ  n1 = 3n + 1
Lặp lại quá trình trên cho đến khi n = 1, tại đó dừng thuật toán.
Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17
d.	Đóng kết nối và kết thúc chương trình.
*/