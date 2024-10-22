package Lesson5_NIC_MC;
import java.io.*;
import java.net.*;
import java.util.*;
public class NIC {
    public static void main(String[] args) throws Exception{
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        while(nis.hasMoreElements()){
            NetworkInterface ni = nis.nextElement();
            if(ni.isUp()) System.out.println(ni.getDisplayName() + " / " + ni.getName());//in ra những cái đang sử dụng
        }
    }
}
