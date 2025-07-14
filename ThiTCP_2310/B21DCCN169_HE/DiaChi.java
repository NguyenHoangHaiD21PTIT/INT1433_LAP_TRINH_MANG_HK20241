package B21DCCN169_HE;
import java.io.*;
import java.net.*;
import TCP.Address;
public class DiaChi {
    public static String loaiBo1 (String s){ //Loại bỏ ký tự đặc biệt
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isAlphabetic(x) || Character.isDigit(x)) ans+=String.format("%c", x);
        }
        return ans;
    }
    public static String chuanHoa1 (String s){ //Chuẩn hoá địa chỉ
        String ans = "";
        String []tmp = s.trim().split("\\s+");
        for(String x: tmp) ans+=loaiBo1(x) + " ";
        return ans;
    }
    public static String loaiBo2 (String s){ //Loại bỏ ký tự đặc biệt
        String ans = "";
        for(char x: s.toCharArray()){
            if(Character.isDigit(x) || x=='-') ans+=String.format("%c", x);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String code = "B21DCCN377;4Hk2Ww16";
        out.writeObject(code);
        out.flush();
        Address ad = (Address)in.readObject();
        System.out.println(ad);
        ad.setAddressLine(chuanHoa1(ad.getAddressLine()));
        ad.setPostalCode(loaiBo2(ad.getPostalCode()));
        System.out.println(ad);
        out.writeObject(ad);
        out.flush();
        in.close();out.close();socket.close();
    }
}
/* run:
Exception in thread "main" java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: TCP.Address
	at java.base/java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1660)
	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:495)
	at java.base/java.io.ObjectInputStream.readObject(ObjectInputStream.java:453)
	at TCP.DiaChi.main(DiaChi.java:32)
Caused by: java.io.NotSerializableException: TCP.Address
	at java.io.ObjectOutputStream.writeObject0(Unknown Source)
	at java.io.ObjectOutputStream.writeObject(Unknown Source)
	at Utils.QuestionUtils.Q1449(QuestionUtils.java:3746)
	at TCP.ObjectStreamHandler.run(ObjectStreamHandler.java:65)
	at java.util.concurrent.Executors$RunnableAdapter.call(Unknown Source)
	at java.util.concurrent.FutureTask.run(Unknown Source)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at java.lang.Thread.run(Unknown Source)
C:\Users\Hai\AppData\Local\NetBeans\Cache\25\executor-snippets\run.xml:111: The following error occurred while executing this line:
C:\Users\Hai\AppData\Local\NetBeans\Cache\25\executor-snippets\run.xml:68: Java returned: 1
BUILD FAILED (total time: 0 seconds) */
