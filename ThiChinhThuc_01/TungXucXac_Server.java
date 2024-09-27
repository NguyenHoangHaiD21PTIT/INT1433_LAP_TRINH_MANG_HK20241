package ThiChinhThuc_01;
import java.io.*;
import java.net.*;
public class TungXucXac_Server {
    public static void main(String[] args) throws IOException{
        // Tạo server socket tại cổng 807
        ServerSocket serverSocket = new ServerSocket(807);
        System.out.println("Server is running...");
        while (true) {
            // Chấp nhận kết nối từ client
            Socket socket = serverSocket.accept();
            DataInputStream in  = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //a. Nhận mã sinh viên và mã câu hỏi
            String code = in.readUTF();
            // b. Gửi số lần tung, rồi chuỗi tung
            int n = 10;
            String x = "1,4,6,1,3,5,6,4,2,6";
            out.writeInt(n);
            out.writeUTF(x);
            //c. Nhận xác suất
            float[] p = new float[n];
            for(int i = 1;i<=6;i++) p[i] = in.readFloat();
            for(int i = 1;i<=6;i++) System.out.printf("%.2f ", p[i]);
            //d. Đóng kết nối sau khi hoàn tất giao tiếp
            in.close();
            out.close();
            socket.close();
        }
    }
}
