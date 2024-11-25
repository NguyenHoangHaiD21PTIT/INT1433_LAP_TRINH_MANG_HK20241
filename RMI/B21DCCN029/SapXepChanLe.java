package RMI.B21DCCN029;
import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class SapXepChanLe {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        byte[] a = sv.requestData("B21DCCN029", "A7hytb1V");
        for(byte x: a) System.out.print(x + " ");
        System.out.println("");
        //b. sx
        byte []res = new byte[a.length];
        int idx = 0;
        for(byte x: a){
            if(x % 2==0)  res[idx++] = x;
        }
        for(byte x: a){
            if(x % 2==1)  res[idx++] = x;
        }
        for(byte x: res) System.out.print(x + " ");
        //c.
        sv.submitData("B21DCCN028", "A7hytb1V", res);
    }
}
