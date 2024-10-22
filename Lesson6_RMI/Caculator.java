package Lesson6_RMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Caculator extends UnicastRemoteObject implements CalInf {
    public Caculator() throws RemoteException {
        super(); // Gọi constructor của UnicastRemoteObject
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("A client request");
        return a + b;
    }
}
