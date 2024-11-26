package RMI;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class Character {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6"); //Thay MSV mã đề tương ứng
        
        //b. Xử lý
        //Giả sử với xâu s đề cho, các bận xử lý tỉ tỉ bước, rồi xâu cuối cùng thu được là xâu res gì đấy
        
        //c. Gửi
        sv.submitCharacter("B21DCCN015", "0JaasIw6", res);//Gửi xâu kq lên cho sv, thay msv mã đề và tên biến kq tương ứng
    }
}
