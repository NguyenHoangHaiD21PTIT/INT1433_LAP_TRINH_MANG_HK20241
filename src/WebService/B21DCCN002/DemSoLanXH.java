package WebService.B21DCCN002;
import vn.medianews.*;
import java.util.*;
public class DemSoLanXH {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN002", qCode = "TU4ULIgh"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        //List<Integer>a = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3));
        System.out.println(a);
        int []cnt = new int[10005];
        for(int x: a) cnt[x]++;
        List<List<Integer>>ans = new ArrayList<>();
        for(int x: a){
            if(cnt[x]>0){
                List<Integer>tmp = new ArrayList<>(Arrays.asList(x, cnt[x]));
                ans.add(tmp);
                cnt[x] = 0;
            }
        }
        port.submitDataIntMatrix(msv, qCode, 15);
    }
}
