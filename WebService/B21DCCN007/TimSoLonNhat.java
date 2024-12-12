package WebService.B21DCCN007;
import vn.medianews.*;
import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        List<Integer>a = port.getData(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        String ans = "";
        for(int x: a) ans+=(x + "");
        System.out.println(ans);
        port.submitDataString(msv, qCode, ans);
    }
}
//Chờ log
