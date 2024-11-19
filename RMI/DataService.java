package RMI;
import java.rmi.*;
public interface DataService extends Remote {
    Object requestData(String studentCode, String qCode) throws RemoteException;
    void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
