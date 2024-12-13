package WebService.B21DCCN033;
import vn.medianews.*;
import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, ans);
    }
}
