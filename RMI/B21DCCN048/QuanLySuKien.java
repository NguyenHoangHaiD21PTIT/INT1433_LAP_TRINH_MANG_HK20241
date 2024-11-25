package RMI.B21DCCN048;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Ticket;
import java.util.*;
public class QuanLySuKien {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Ticket ticket = (Ticket) sv.requestObject("B21DCCN048", "Uct8bABt");
        //Ticket ticket = new Ticket(1, "Charity Concert", "15/06/2024");
        System.out.println(ticket);
        //Lấy tên
        String s = ticket.getEventName().toUpperCase();
        String res = "";
        res+=String.format("%c%c", Character.toUpperCase(s.charAt(0)), (char)Character.toUpperCase(s.charAt(s.length() - 1)));
        //Lấy ngày sinh
        String s1 = ticket.getSaleDate();
        s1 = s1.replace("/", " ");
        String []tmp = s1.trim().split("\\s+");
        res+=tmp[1] + tmp[0];
        //Lấy 2 chữ số
        Set<Integer>si = new HashSet<>();
        for(char x: s1.toCharArray()){
            if(Character.isDigit(x)) si.add(x - '0');
        }
        for(int i = 9;i >= 0;i--){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        for(int i = 0;i<=9;i++){
            if(!si.contains(i)){
                res+=i;
                break;
            }
        }
        ticket.setTicketCode(res);
        System.out.println(ticket);
        //c.
        sv.submitObject("B21DCCN048", "Uct8bABt", ticket);
    }
}
//Chưa test được
