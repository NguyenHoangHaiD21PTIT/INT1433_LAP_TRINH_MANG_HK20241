package WebService.B21DCCN002;
import vn.medianews.*;
import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a); Collections.sort(a);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<String>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                String tmp = String.format("%d, %d", x, cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(String x: ans){
            System.out.println(x);
        }
        port.submitDataStringArray(msv, qCode, ans);
    }
}
