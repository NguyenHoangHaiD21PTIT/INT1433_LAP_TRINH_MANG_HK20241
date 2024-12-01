package WebService.B21DCCN001;
import vn.medianews.*;
import java.util.*;
public class PTichTSNT {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN001", qCode = "TwZpbqUg"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int n = 28;
        List<Integer>ans = new ArrayList<>();
        for(int i = 2;i*i<=n;i++){
            while(n%i==0){
                n/=i;
                ans.add(i);
            }
        }
        if(n!=1) ans.add(n);
        System.out.println(ans);
        port.submitDataInt(msv, qCode, n);
    }
}
