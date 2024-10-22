package Lesson5_NIC_MC;
import java.io.*;
import java.net.*;
import java.util.*;
public class MCServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Server is running.");
        int i = 0;
        while(true){
            String strMessage = "Message " + i;
            DatagramPacket dp = new DatagramPacket(strMessage.getBytes(), strMessage.length()
            , InetAddress.getByName("224.2.2.3"), 2209);
            ds.send(dp);
            Thread.sleep(2000);
            i++;
        }
    }
}
