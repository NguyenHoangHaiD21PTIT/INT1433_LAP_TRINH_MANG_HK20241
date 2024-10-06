package UDP;
import UDP.Product;
import java.io.*;
import java.net.*;
public class SanPham {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;
        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];  
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Lấy phần requestId (08 byte đầu)
        String reId = new String(dpNhan.getData(), 0, 8);
        System.out.println("Request ID: " + reId);

        // Lấy phần Product (byte còn lại)
        ByteArrayInputStream bais = new ByteArrayInputStream(dpNhan.getData(), 8, dpNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println("Nhận sản phẩm: " + product);

        // c. Chỉnh sửa đối tượng Product theo yêu cầu
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());

        // Đảo ngược số lượng
        String tmp = String.valueOf(product.getQuantity());
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        System.out.println("Sản phẩm sau khi chỉnh sửa: " + product);

        // d. Gửi lại đối tượng Product đã sửa cùng requestId lên server
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];                
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);
    }
}
/*
IntrinsicCandidate
    public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

public String(Luồng byte từ package, chỉ số bắt đầu, độ rộng) {
*/

