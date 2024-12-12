package WebService.B21DCCN016;
import vn.medianews.*;
import java.util.*;
public class XoayVongKyTu {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN016", qCode = "32He7sZg"; 
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<Character>a = new java.util.ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        System.out.println(a);
        int xoay = a.get(0)%(a.size());
        Collections.rotate(a, xoay);
        System.out.println(a);
    }
}
//Lỗi kiểu dữ liệu nên đang làm demo
