package WebService.B21DCCN004;
import vn.medianews.*;
import java.util.*;
public class LietKeUoc {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN004", qCode = "nhFjYg0F"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        //int a = (int)port.getDataDouble(msv, qCode);
        int n = 12; int cnt = 0;
        System.out.println(n);
        List<Integer>ans = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0){
                ans.add(i);
                cnt++;
            }
        }
        ans.add(0, cnt);
        System.out.println(ans);
        port.submitDataIntArray(msv, qCode, 0);
    }
}
