package RMI.B21DCCN319;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class XuLyVanBan {
    public static void main(String[] args) throws Exception {
        // a. Nhận chuỗi từ server
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN319", "NFldNPp6");
        System.out.println(s);
        // b. Xử lý xâu
        s = s.replace("\"", "");  s = s.replace("{", "");  s = s.replace("}", "");   
        String[] tmp = s.trim().split(",");// Tách chuỗi thành các cặp key-value
        String chan = "", le = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].trim(); 
            if (i % 2 == 0) {
                if (chan.length() > 0) chan+=", ";
                chan+=tmp[i];
            } else {
                if (le.length() > 0) le+=", ";
                le+=tmp[i];
            }
        }
        String res = chan + "; " + le;
        System.out.println(res);
        // c. Gửi kết quả lại server
        sv.submitCharacter("B21DCCN319", "NFldNPp6", res);
    }
}
