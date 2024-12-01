package WebService.B21DCCN016;
import vn.medianews.*;
import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "32He7sZg"; 
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        System.out.println(a);
    }
}
