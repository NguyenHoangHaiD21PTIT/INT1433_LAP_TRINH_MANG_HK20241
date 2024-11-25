package RMI.B21DCCN015;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.CharacterService;
public class ChuyenDoiLaMaThapPhan {
    public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService) rg.lookup("RMICharacterService");
        String s = sv.requestCharacter("B21DCCN015", "0JaasIw6");
        System.out.println(s);
        //c. Gửi
        System.out.println(change(s));
        sv.submitCharacter("B21DCCN015", "0JaasIw6", String.valueOf(change(s)));
    }
}

