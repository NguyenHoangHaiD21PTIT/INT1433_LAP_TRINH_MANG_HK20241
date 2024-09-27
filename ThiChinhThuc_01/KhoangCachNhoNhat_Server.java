package ThiChinhThuc_01;
import java.io.*;
import java.net.*;
public class KhoangCachNhoNhat_Server {
    public static void main(String[] args) throws IOException{
        // Tạo server socket tại cổng 807
        ServerSocket serverSocket = new ServerSocket(807);
        System.out.println("Server is running...");
        while (true) {
            // Chấp nhận kết nối từ client
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            //a. Nhận mã sinh viên và mã câu hỏi
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            // b. Gửi chuỗi số nguyên chưa sắp xếp
            String x = "1,5,3,19,25,4,8,12";
            out.write(x.getBytes());
            out.flush();
            //c. Nhận chuỗi đã sắp xếp từ client
            bytesRead = in.read(buffer);
            String ans = new String(buffer, 0, bytesRead).trim();
            System.out.println(ans);
            //d. Đóng kết nối sau khi hoàn tất giao tiếp
            in.close();
            out.close();
            socket.close();
        }
    }
}
