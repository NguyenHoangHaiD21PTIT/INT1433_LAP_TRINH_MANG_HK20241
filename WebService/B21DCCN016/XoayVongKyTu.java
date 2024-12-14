package WebService.B21DCCN016;
import vn.medianews.*;
import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "YDcPHFgN"; 
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Integer>a = port.requestCharacter(msv, qCode);
        int timeRot = a.get(0)%(a.size());
        Collections.rotate(a, timeRot);
        port.submitCharacterCharArray(msv, qCode, a);
    }
}

