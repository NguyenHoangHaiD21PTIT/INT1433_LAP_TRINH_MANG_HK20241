package RMI.B21DCCN021;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoDoiXung {
    public static boolean check(int x){
        String s = x+"";
        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN021", "t3cBY2uk");
        System.out.println(s);
        s = s.replace(";", "");
        String []tmp = s.trim().split("\\s+");
        int n = Integer.parseInt(tmp[0].trim()), k = Integer.parseInt(tmp[1].trim());
        List<Integer>a = new ArrayList<>();
        for(int i = n;i<k;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN021", "t3cBY2uk", a);
    }
}
