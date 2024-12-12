package WebService.B21DCCN002;
import vn.medianews.*;
import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<vn.medianews.ArrayList> ans = new java.util.ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                vn.medianews.ArrayList tmp = new vn.medianews.ArrayList();
                tmp.getItem().add(x); tmp.getItem().add(cnt[x]);
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        for(vn.medianews.ArrayList x: ans) System.out.print(x.getItem() + ";");
        port.submitDataIntMatrix(msv, qCode, ans);
    }
}
//Chờ log
