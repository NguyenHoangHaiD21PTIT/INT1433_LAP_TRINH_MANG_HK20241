package RMI.B21DCCN021;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.CharacterService;
public class MaHoaVigen {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN021", "Y7YMXHs4");
        System.out.println(s);
        int idx = s.indexOf(";");
        String keyW = s.substring(0, idx), text = s.substring(idx + 1), ans = "";
        for(int i = 0;i<text.length();i++){
            char x = text.charAt(i), y = keyW.charAt(i % keyW.length());
            char z;
            if (Character.isUpperCase(x)) z = (char) ((x - 'A' + y - 'A') % 26 + 'A');
            else z = (char) ((x - 'a' + y - 'a') % 26 + 'a');
            ans+=z;
        }
        System.out.println(ans);
        sv.submitCharacter("B21DCCN021", "Y7YMXHs4", ans);
    } 
}
