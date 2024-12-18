package RMI.B21DCCN053;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.net.URLEncoder;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = URLEncoder.encode(s, "UTF-8");
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
}
//Sửa đề xong thì chịu không biết AC kiểu gì??
