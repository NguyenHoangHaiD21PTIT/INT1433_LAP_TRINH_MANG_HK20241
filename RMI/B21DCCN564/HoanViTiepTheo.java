package RMI.B21DCCN564;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import RMI.DataService;
public class HoanViTiepTheo {
    public static void main(String[] args) throws Exception {
        // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        String s = (String) sv.requestData("B21DCCN564", "3Qe0Qb5w");
        System.out.println(s);
        //Đẩy hết vào mảng để xử lý
        s = s.replace(",", " ");
        String[] tmp = s.trim().split("\\s+");
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        //b. Sinh hoán vị kế tiếp
        // Bước 1: Tìm vị trí đầu tiên từ cuối mà tại đó nó nhỏ hơn số đằng sau nó
        int i = n - 2;
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        // Bước 2: Kiểm tra nếu không còn hoán vị nào lớn hơn
        if (i < 0) Collections.sort(a); // Đưa về hoán vị đầu tiên
        else {
            // Bước 3: Tìm vị trí đầu tiên từ cuối lớn hơn a[i]
            int j = n - 1;
            while (a.get(j) <= a.get(i)) j--;
            Collections.swap(a, i, j);// Hoán đổi a[i] và a[j]
            // Bước 4: Lật ngược đoạn từ i + 1 đến cuối mảng
            int l = i + 1, r = n - 1;
            while (l < r) {
                Collections.swap(a, l, r);
                l++;
                r--;
            }
        }
        String res = "";
        for(int x: a) res+=String.format("%d,", x);
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
        // c. Gửi kết quả
        sv.submitData("B21DCCN564", "3Qe0Qb5w", res);
    }
}

