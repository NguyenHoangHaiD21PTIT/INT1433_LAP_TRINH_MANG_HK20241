package ThiChinhThuc_01;
import java.util.*;
import java.io.*;
import java.net.*;
public class DemSoLanXuatHien_Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(807);
        while (true) {
            // Chấp nhận kết nối từ client
            Socket clientSocket = serverSocket.accept();
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            //a. Nhận mã sinh viên và mã câu hỏi
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String receivedCode = new String(buffer, 0, bytesRead).trim();
            System.out.println("a. Received: " + receivedCode);
            // b. Gửi xâu
            String s = "dgUOo ch2k22ldsOo";
            out.write(s.getBytes());
            out.flush();
            //c. Nhận chuỗi đã sắp xếp từ client
            bytesRead = in.read(buffer);
            String ans = new String(buffer, 0, bytesRead).trim();
            System.out.println(ans); //Đây là đáp án khi chấm bài
            //d. Đóng kết nối sau khi hoàn tất giao tiếp
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
