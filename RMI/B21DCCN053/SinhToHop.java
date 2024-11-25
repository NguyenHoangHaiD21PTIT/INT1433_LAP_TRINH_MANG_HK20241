package RMI.B21DCCN053;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
public class SinhToHop {
    static int ok; 
    public static void kt(int a[], int k) {
        for (int i = 1; i <= k; i++) a[i] = i;
    }
    public static void sinh(int a[], int n, int k) {
        int i = k;
        while (i >= 1 && a[i] == n - k + i) i--;
        if (i == 0) {
            ok = 0;
        } else {
            a[i]++;
            for (int j = i + 1; j <= k; j++) a[j] = a[j - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String)sv.requestData("B21DCCN053", "juC3u7C6");
        //String s = "2, 0, 5, 8, 1 ;3"; 
        System.out.println(s);
        int idx = s.indexOf(";");
        String s1 = s.substring(0, idx), s2 = s.substring(idx + 1);
        int k = Integer.parseInt(s2.trim());// Lấy số k
        // Lấy ra mảng và sắp xếp
        ArrayList<Integer> a = new ArrayList<>();
        s1 = s1.replace(",", " ");
        String[] tmp = s1.trim().split("\\s+");
        for (String x : tmp) a.add(Integer.parseInt(x));
        // Bắt đầu sinh tổ hợp. Khởi tạo
        int n = a.size();
        int[] genIdx = new int[k + 1];
        kt(genIdx, k);
        ok = 1;
        // Duyệt qua từng tổ hợp chỉ số
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (ok == 1) {
            ArrayList<Integer> tmp1 = new ArrayList<>();
            for (int i = 1; i <= k; i++) tmp1.add(a.get(genIdx[i] - 1));
            ans.add(tmp1);
            sinh(genIdx, n, k);
        }
        //c.
        System.out.println(ans);
        sv.submitData("B21DCCN053", "juC3u7C6", ans);
    }
}
