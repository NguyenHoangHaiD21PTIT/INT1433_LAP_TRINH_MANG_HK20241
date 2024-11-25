package RMI.B21DCCN036;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ByteService;
public class NenRLE {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN036", "2uG0lQGi");
        for (byte x : a) System.out.print(x + " ");
        System.out.println();
        // b. 
        int cnt = 1;
        ArrayList<Byte>res = new ArrayList<>();
        for(int i = 1;i<a.length;i++){
            if(a[i] == a[i - 1]) cnt++;
            else{
                res.add(a[i - 1]); res.add((byte)cnt);
                cnt = 1;
            }
        }
        res.add(a[a.length - 1]); res.add((byte)cnt);
        //Cóp sang mảng
        byte []ans = new byte[res.size()];
        int idx = 0;
        for(byte x: res) ans[idx++] = x;
        for(byte x: ans) System.out.print(x + " ");
        sv.submitData("B21DCCN036", "2uG0lQGi", ans);        
    }
}
