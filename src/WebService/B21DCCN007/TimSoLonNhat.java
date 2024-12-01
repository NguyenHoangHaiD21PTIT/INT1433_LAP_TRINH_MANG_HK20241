package WebService.B21DCCN007;
import vn.medianews.*;
import java.util.*;
public class TimSoLonNhat {
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN007", qCode = "RiRH8wfk"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        //List<Integer>a = port.getData(msv, qCode);
        List<Integer>a = new ArrayList<>(Arrays.asList(7602,9136,1090,34319,7830,6179,10584,20166,28199,30250,32179,22544,3222,10320,30590,19279));
        System.out.println(a);
        ArrayList<String>b = new ArrayList<>();
        for(int x: a) b.add(x + "");
        String ans = "";
        Collections.sort(b, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        for(String x: b) ans+=x;
        System.out.println(ans);
        port.submitDataString(msv, qCode, 0);
    }
}
