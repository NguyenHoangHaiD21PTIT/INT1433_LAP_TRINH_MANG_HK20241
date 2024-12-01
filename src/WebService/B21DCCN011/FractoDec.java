package WebService.B21DCCN011;
import vn.medianews.*;
import java.util.*;
public class FractoDec {
    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception{
        String msv = "B21DCCN011", qCode = "ny8Fb8BU"; 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        //double a = port.getDataDouble(msv, qCode);
        double a = 0.75;
        System.out.println(a);
        int tu, mau = 1;
        while (a!=(int)a){
            a*=10;
            mau*=10;
        }
        tu = (int)a;
        int tmp = gcd(tu, mau);
        tu/=tmp; mau/=tmp;
        List<Integer>ans = new ArrayList<>(Arrays.asList(tu, mau));
        System.out.println(ans);
    }
}
