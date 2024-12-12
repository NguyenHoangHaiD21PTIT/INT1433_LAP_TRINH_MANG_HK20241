package WebService.B21DCCN088;
import vn.medianews.*;
import java.util.*;
public class SXChanLe {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN088", qCode = "0BEtJAT9"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        List<Integer>chan = new java.util.ArrayList<>(), le = new java.util.ArrayList<>(), ans = new java.util.ArrayList<>();
        for(int x: a){
            if(x%2==0) chan.add(x);
            else le.add(x);
        }
        int k = Integer.min(chan.size(), le.size());
        for(int i = 0;i < k;i++){
            ans.add(chan.get(i)); ans.add(le.get(i));
        }
        int k1 = chan.size() - k, k2 = le.size() - k;
        if(k1 > 0){
            for(int i = k;i<chan.size();i++) ans.add(chan.get(i));
        }
        if(k2 > 0){
            for(int i = k;i<le.size();i++) ans.add(le.get(i));
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
