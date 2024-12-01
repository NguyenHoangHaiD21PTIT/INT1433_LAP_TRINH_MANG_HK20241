package WebService.B21DCCN033;
import vn.medianews.*;
import java.util.*;
public class LoaiBoTrungNhau {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN033", qCode = "E2Axwwf3"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        //List<Integer>a = port.getData(msv, qCode);
        List<Integer>a = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3));
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<Integer>ans = new ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        System.out.println(ans);
        //port.submitDataIntArray(msv, qCode, 0);
    }
}
