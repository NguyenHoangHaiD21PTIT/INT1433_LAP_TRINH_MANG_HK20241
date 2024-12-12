package WebService.B21DCCN012;
import vn.medianews.*;
import java.util.*;
public class NhomTuTheoNguyenAm {
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN012", qCode = "32He7sZg"; 
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
                return s1.compareTo(s2);
            }
        });
        List<String>ans = new java.util.ArrayList<>();
        String gr = a.get(0);
        for(int i = 1;i<a.size();i++){
            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
            else{
                ans.add(gr);
                gr = a.get(i);
            }
        }
        ans.add(gr);
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, ans);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}
