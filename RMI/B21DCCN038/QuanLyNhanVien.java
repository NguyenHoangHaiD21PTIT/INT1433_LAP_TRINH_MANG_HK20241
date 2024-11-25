package RMI.B21DCCN038;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.ObjectService;
import RMI.Employee;
public class QuanLyNhanVien {
    public static void main(String[] args) throws Exception{
        //a.
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService) rg.lookup("RMIObjectService");
        Employee employee = (Employee) sv.requestObject("B21DCCN038", "7fSWnlHB");
        System.out.println(employee);
        //b.tổng cs
        int tongCS = 0, x = employee.getExperienceYears(), y = employee.getExperienceYears();
        while(x>0){
            tongCS+=x%10;
            x/=10;
        }
        //tổng ước
        int soUoc = 0;
        for(int i = 1;i<=y;i++){
            if(y%i==0) soUoc++;
        }
        //factor
        double factor = (double)(employee.getExperienceYears() + tongCS + soUoc)/100.0;
        double Final = (employee.getBaseSalary()) * (1 + factor);
        //
        employee.setFinalSalary(Final);
        System.out.println(employee);
        //c.
        sv.submitObject("B21DCCN038", "7fSWnlHB", employee);
    }
}
