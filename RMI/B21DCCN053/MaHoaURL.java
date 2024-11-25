package RMI.B21DCCN053;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class MaHoaURL {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN053", "KkihaRAB");
        System.out.println(s);
        //b.
        String ans = "";
        for(char x: s.toCharArray()){
            if(!Character.isDigit(x) && !Character.isAlphabetic(x)) ans+="%" +  String.format("%02X", (int) x);
            else ans+=x;
        }
        System.out.println(ans);
        //c.
        sv.submitCharacter("B21DCCN053", "KkihaRAB", ans);
    }
//    public static void main(String[] args) {
//        String s = "Hello World!", ans = "";
//        for(char x: s.toCharArray()){
//            if(!Character.isDigit(x) && !Character.isAlphabetic(x)) ans+="%" +  String.format("%02X", (int) x);
//            else ans+=x;
//        }
//        System.out.println(ans);
//    }
}
//Chưa test được