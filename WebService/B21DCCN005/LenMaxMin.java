package WebService.B21DCCN005;
import vn.medianews.*;
import java.util.*;
public class LenMaxMin {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN005", qCode = "9n2rfqST"; 
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        String []tmp = s.trim().split("\\s+");
        int lenMax = tmp[0].length(), lenMin  = tmp[0].length();
        String strMax = tmp[0], strMin = tmp[0];
        for(String x: tmp){
            if(x.length() < lenMin){
                strMin = x;
                lenMin = x.length();
            }
            if(x.length() > lenMax){
                strMax = x;
                lenMax = x.length();
            }
        }
        String ans = strMax + ";" + strMin;
        System.out.println(ans);
        port.submitCharacterString(msv, qCode, ans);
    }
}
