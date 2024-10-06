package LuyenThiUDP;
import java.net.*;
public class Bai4Server {    
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(2207);
        System.out.println("Server is running");
        while(true){
            //a. Nhận MSV
            byte []buffer = new byte[1024];
            DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
            socket.receive(dpNhan);
            String s = new String(dpNhan.getData());
            System.out.println("a. Nhan ma sinh vien: " + s);
            //b. Gửi chuỗi
            String s1 = "giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu";
            DatagramPacket dpGui = new DatagramPacket(s1.getBytes(), s1.length(), dpNhan.getAddress(), dpNhan.getPort());
            socket.send(dpGui);
            System.out.println("b. Da gui thanh cong");
            //c. Nhận lại chuỗi
            byte []buffer1 = new byte[1024];
            DatagramPacket dpNhan1 = new DatagramPacket(buffer1, buffer1.length);
            socket.receive(dpNhan1);
            String s2 = new String(dpNhan1.getData());
            System.out.println("c. Chuoi thu duoc la: " + s2);
        }
    }
}

