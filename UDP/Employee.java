package UDP;
import java.io.*;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20261107L;
    private String id, name, hireDate;
    private double salary;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHireDate() {
        return hireDate;
    }
    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + '}';
    }
}
