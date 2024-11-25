package RMI.B21DCCN028;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class LietKeSoCP {
    public static boolean check(int x){
        double y = Math.sqrt(x);
        int y1 = (int)y;
        return y == y1;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN028", "eTHcAYZh");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(check(i)) a.add(i);
        }
        System.out.println(a);
        sv.submitData("B21DCCN028", "eTHcAYZh", a);
    }
}