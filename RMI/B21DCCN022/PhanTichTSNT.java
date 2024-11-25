package RMI.B21DCCN022;
import java.util.*;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhanTichTSNT {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN022", "zzmmquoc");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                a.add(i);
                n/=i;
            }
        }
        if(n>1) a.add(n);
        System.out.println(a);
        sv.submitData("B21DCCN022", "zzmmquoc", a);
    }
}
