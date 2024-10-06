package LuyenThiUDP;
import java.net.*;
public class Bai1Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("localhost");
        int sP = 2207;
        String code = "B21DCCN319;abc";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        int []a = new int[2];
        for(int i = 0;i<2;i++){
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            String s = new String(dpNhan.getData()).trim();
            a[i] = Integer.parseInt(s);
        }
        System.out.println(a[0]);
        System.out.println(a[1]);
        int c = UCLN(a[0], a[1]);
        int d = a[0] * a[1]/c;
        int []res = {c, d};
        for(int x: res){
            String s = String.valueOf(x);
            DatagramPacket dpGui1 = new DatagramPacket(s.getBytes(), s.length(), sA, sP);
            socket.send(dpGui1);
            System.out.println(s);
        }
        socket.close();
    }
    public static int UCLN(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
/*
Đề bài giả định: Một chương trình server được triển khai tại địa chỉ localhost (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình Client thực hiện kết nối tới server tại cổng 2207, sử dụng giao thức UDP để trao đổi thông tin theo thứ tự: 
a/ Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". 
Ví dụ: "B20DCCN999;ABCDEF" với ABCDEF là mã bài tập đã đề cập ở trên. 
b. Nhận lần lượt hai số nguyên a và b từ server 
c. Thực hiện tính toán UCLN, BCNN và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server 
d. Đóng kết nối và kết thúc
*/
