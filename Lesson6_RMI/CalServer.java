package Lesson6_RMI;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class CalServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        // Tạo và khởi động RMI Registry trên cổng mặc định (1099)
        LocateRegistry.createRegistry(1099);
        // Tạo đối tượng Caculator
        Caculator cal = new Caculator();
        // Đăng ký đối tượng Caculator với RMI Registry
        Naming.rebind("rmi://localhost/call03", cal);
        System.out.println("Success");
    }
}
