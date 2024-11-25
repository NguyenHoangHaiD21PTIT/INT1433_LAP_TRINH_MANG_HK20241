package RMI.B21DCCN023;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Student;
public class QuanLySinhVien {
    public static String chuanhoa(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
    public static String chuanhoa2(String s){
        String []tmp = s.trim().split("\\s+");
        String res = "";
        for(int i = 0;i<tmp.length - 1;i++) res+=chuanhoa(tmp[i]) + " ";
        res+=tmp[tmp.length - 1].toUpperCase();
        return res;
    }
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Student student = (Student) sv.requestObject("B21DCCN023", "lNV6xzmk");
        System.out.println(student);
        student.setName(chuanhoa2(student.getName()));
        String code = String.format("B%d", student.getEnrollmentYear()%100);
        String []tmp = student.getName().split("\\s+");
        code+=tmp[tmp.length - 1].toUpperCase() + "_";
        for(int i = 0;i<tmp.length - 1;i++) code+=Character.toUpperCase(tmp[i].charAt(0));
        student.setCode(code);
        System.out.println(student);
        //c.
        sv.submitObject("B21DCCN023", "lNV6xzmk", student);
    }
}
