package RMI.B21DCCN029;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Event;
public class ToChucSuKien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Event event = (Event) sv.requestObject("B21DCCN029", "FKrGvwLM");
        System.out.println(event);
        //b.
        String ans = "";
        int x = event.getExpectedAttendance();
        //
        if(x>=1000) ans = "L";
        else if (x>=500 && x<=999) ans = "M";
        else ans = "S";
        //
        String []tmp = event.getEventName().trim().split("\\s+");
        ans+=Character.toUpperCase(tmp[0].charAt(0));
        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(0));
        //
        String tmp1 = event.getEventDate();
        tmp1 = tmp1.replace("-", " ");
        String []tmp2 = tmp1.trim().split("\\s+");
        ans+=tmp2[2] + tmp2[1];
        event.setEventCode(ans);
        //c.
        System.out.println(event);
        sv.submitObject("B21DCCN029", "FKrGvwLM", event);
    }
//    public static void main(String[] args) {
//        Event event = new Event("EV001", "Charity Run", "2024-05-12", 1200);
//        System.out.println(event);
//        String ans = "";
//        int x = event.getExpectedAttendance();
//        //
//        if(x>=1000) ans = "L";
//        else if (x>=500 && x<=999) ans = "M";
//        else ans = "S";
//        //
//        String []tmp = event.getEventName().trim().split("\\s+");
//        ans+=Character.toUpperCase(tmp[0].charAt(0));
//        ans+=Character.toUpperCase(tmp[tmp.length - 1].charAt(0));
//        //
//        String tmp1 = event.getEventDate();
//        tmp1 = tmp1.replace("-", " ");
//        String []tmp2 = tmp1.trim().split("\\s+");
//        ans+=tmp2[2] + tmp2[1];
//        //
//        event.setEventCode(ans);
//        System.out.println(event);
//    }   
}
//Chưa test được
