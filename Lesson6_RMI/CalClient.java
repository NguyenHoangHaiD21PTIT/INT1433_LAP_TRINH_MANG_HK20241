package Lesson6_RMI;
import java.rmi.*;
public class CalClient {
    public static void main(String[] args) throws Exception{
        CalInf cal = (CalInf)Naming.lookup("rmi://localhost/call03");
        System.out.println("Sum: " + cal.add(100,200));
    }
}
