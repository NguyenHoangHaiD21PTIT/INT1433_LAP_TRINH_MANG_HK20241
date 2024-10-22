package Lesson6_RMI;
import java.rmi.*;
public interface CalInf extends Remote{
    public int add(int a, int b) throws RemoteException;
}
