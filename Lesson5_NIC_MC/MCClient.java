package Lesson5_NIC_MC;
import java.io.*;
import java.net.*;
import java.util.*;
public class MCClient {
    public static void main(String[] args) throws Exception {
        MulticastSocket client = new MulticastSocket(2209);
        client.joinGroup(InetAddress.getByName("224.2.2.3"));
        System.out.println("Join success");
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            client.receive(p);
            System.out.println(new String(p.getData()).trim());
        }
    }
}
