package WebService.B21DCCN008;
import vn.medianews.*;
import java.util.*;
public class DaoNguoc {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN008", qCode = "rT6Ql5GH"; 
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức 
        String s = port.requestString(msv, qCode);
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x)) ans = x + ans;
        }
        System.out.println(ans);
        //c
        port.submitCharacterString(msv, qCode, ans);
    }
}
