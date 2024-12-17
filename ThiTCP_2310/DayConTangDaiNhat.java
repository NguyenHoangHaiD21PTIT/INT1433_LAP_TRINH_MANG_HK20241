package TCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class DayConTangDaiNhat {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        String code = "B21DCCN001;XGIm2Fc7";
        out.write(code.getBytes());
        out.flush();
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);
        System.out.println(s);
        ArrayList<Integer>a = new ArrayList<>();
        String []tmp = s.trim().split(",");
        for(String x: tmp) a.add(Integer.parseInt(x));
        int n = a.size();
        int []f= new int[n], trace = new int[n]; Arrays.fill(trace, -1);
        for(int i = 0;i<n;i++) f[i] = 1;
        for(int i=0;i<n;i++){
            for(int j = 0;j<i;j++){
		if(a.get(j) < a.get(i) && f[i] < f[j] + 1){
                    f[i] = Integer.max(f[i],f[j]+1);
                    trace[i] = j;
                }
            }
	}
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] > maxLength) {
                maxLength = f[i];
                endIndex = i;
            }
        }
        // Khôi phục dãy con LIS
        ArrayList<Integer> lis = new ArrayList<>();
        while (endIndex != -1) {
            lis.add(0, a.get(endIndex));
            endIndex = trace[endIndex];
        }
        String ans = String.format("%d", lis.get(0));
        for(int i = 1;i<lis.size();i++) ans+=String.format(",%d", lis.get(i));
        ans+=String.format(";%d", lis.size());
        System.out.println(ans);
        out.write(ans.getBytes()); out.flush();
        in.close(); out.close(); socket.close();
    }
}
