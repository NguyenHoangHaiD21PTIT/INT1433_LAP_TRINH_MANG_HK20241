package RMI.B21DCCN029;
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;
public class MaHoaBase64 {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN029", "psd4Jmnt");
        System.out.println(s);
        //
        byte []tmp = Base64.getEncoder().encode(s.getBytes());
        String ans = new String(tmp);
        System.out.println(ans);
        //
        sv.submitCharacter("B21DCCN029", "psd4Jmnt", ans);
    }
//    public static void main(String[] args) {
//        //a.
//        String s = "HELLO";
//        System.out.println(s);
//        byte []tmp = Base64.getEncoder().encode(s.getBytes());
//        String ans = new String(tmp);
//        System.out.println(ans);
//    }
    //Chưa test được
}
