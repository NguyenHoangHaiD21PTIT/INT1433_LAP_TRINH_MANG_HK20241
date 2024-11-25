package RMI.B21DCCN012;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class DemSoLanXH2 {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN012", "ctRfIejL");
        System.out.println(s);
        int[] cnt = new int[256]; 
        for (char x : s.toCharArray()) cnt[x]++;
        String res = "";
        boolean first = true;
        for (char x : s.toCharArray()) {
            if (cnt[x] > 0) {
                if (!first) res+=", ";
                res+=String.format("\"%c\": %d", x, cnt[x]); 
                cnt[x] = 0; 
                first = false;
            }
        }
        res = "{" + res + "}";
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN012", "ctRfIejL", res);
    }
}
