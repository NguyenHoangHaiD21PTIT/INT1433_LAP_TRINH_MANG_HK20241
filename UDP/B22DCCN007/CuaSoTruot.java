package B22DCCN007;
import java.io.*;
import java.net.*;
import java.util.*;
public class DaySoCollazt{
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2207;
        //a.
        String code = ";B22DCCN007;iv00Hrq6";
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
        System.out.println(st);
        //Tách dữ liệu
        String []tmp = st.trim().split("\\s+");
        String rqID = tmp[0]; int n = Integer.parseInt(tmp[1]), k = Integer.parseInt(tmp[2]);
        //Cho các số còn lại vào mảng
        ArrayList<Integer>a = new ArrayList<>();
        for(int i = 3; i < tmp.length; i++) a.add(Integer.parseInt(tmp[i]));
        //Tạo String kết quả
        String ans = rqID + ";";
        //en - st + 1 = k -> st = en + 1 - k. en_max = n - 1 -> st_max = n - 1 + 1 - k = n - k
        for(int i = 0; i <=  n - k; i++){
            int Max = a.get(i);//Max mỗi đoạn con
            for(int j = i + 1; j <= i + k - 1; j++){ //en = st + k - 1
                if(a.get(j) > Max) Max = a.get(j);
            }
            ans += String.format("%d,", Max);
        }
        ans = ans.substring(0, ans.length() - 1);
        System.out.println(ans);
        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(ans.getBytes(), ans.length(), sA, sP);
        socket.send(dpGui1);
    }
}
/*
[Mã câu hỏi (qCode): iv00Hrq6].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B21DCCN795;ylrhZ6UM".
b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;n;k;z1,z2,...,zn", trong đó:
    requestId là chuỗi ngẫu nhiên duy nhất.
    n là số phần tử của mảng.
    k là kích thước cửa sổ trượt (k < n).
    z1 đến zn là n phần tử là số nguyên của mảng.
c. Thực hiện tìm giá trị lớn nhất trong mỗi cửa sổ trượt với kích thước k trên mảng số nguyên nhận được, và gửi thông điệp lên server theo định dạng "requestId;max1,max2,...,maxm", trong đó max1 đến maxm là các giá trị lớn nhất tương ứng trong mỗi cửa sổ.
Ví dụ: "requestId;5;3;1,5,2,3,4"
Kết quả: "requestId;5,5,4"
d. Đóng socket và kết thúc chương trình.
*/
