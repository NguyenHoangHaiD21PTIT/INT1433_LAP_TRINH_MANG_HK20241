package ThiChinhThuc_01;
import java.io.*;
import java.net.*;

public class SapXep_Server {
    public static void main(String[] args) throws IOException {
        // Tạo server socket tại cổng 807
        ServerSocket serverSocket = new ServerSocket(807);
        System.out.println("Server is running...");
        while (true) {
            // Chấp nhận kết nối từ client
            Socket clientSocket = serverSocket.accept();
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            //a. Nhận mã sinh viên và mã câu hỏi
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String receivedCode = new String(buffer, 0, bytesRead).trim();
            // b. Gửi chuỗi số nguyên chưa sắp xếp
            String unsortedNumbers = "2,15,4,3,6,8,10,7,1";
            out.write(unsortedNumbers.getBytes());
            out.flush();
            System.out.println("b. Sent: " + unsortedNumbers);
            //c. Nhận chuỗi đã sắp xếp từ client
            bytesRead = in.read(buffer);
            String sortedResponse = new String(buffer, 0, bytesRead).trim();
            System.out.println("Dap so cuoi cung: " + sortedResponse); //Đây là đáp án khi chấm bài
            //d. Đóng kết nối sau khi hoàn tất giao tiếp
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
