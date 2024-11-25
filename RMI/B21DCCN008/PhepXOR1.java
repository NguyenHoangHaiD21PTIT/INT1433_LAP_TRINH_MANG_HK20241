package RMI.B21DCCN008;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class PhepXOR1 {
    public static void main(String[] args) throws Exception{
        // a. 
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN008", "Xidb0Thk");
        System.out.println(s);
        // b. Xử lý xâu
        String []tmp = s.split(";");
        String xorKey =tmp[0], inp = tmp[1], res = "";
        for(int i = 0;i<inp.length();i++) res+=(char)(inp.charAt(i) ^ xorKey.charAt(i % xorKey.length()));
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN008", "Xidb0Thk", res);
    }
}

