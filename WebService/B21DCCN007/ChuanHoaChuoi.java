package WebService.B21DCCN007;
import vn.medianews.*;
import java.util.*;
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN007", qCode = "sBQjqANT"; 
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức 
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        s = s.replace('_', ' ');
        String []tmp = s.trim().split("\\s+");
        String p = "", c = tmp[0].toLowerCase(), sn = "";
        for(String x: tmp) p+=chuanhoa(x); 
        for(int i = 1;i<tmp.length;i++) c+=chuanhoa(tmp[i]);
        for(String x: tmp) sn+=x.toLowerCase()+"_"; sn = sn.substring(0, sn.length() - 1);
        List<String>ans = new java.util.ArrayList<>();
        ans.add(p); ans.add(c); ans.add(sn);
        System.out.println(ans);
        //c
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    public static String chuanhoa(String s){
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
