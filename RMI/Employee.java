package RMI;
import java.io.Serializable;
public class Employee implements Serializable{
    private static final long serialVersionUID = 20241119L;
    private String id; 
    private String name; 
    private double baseSalary, finalSalary; 
    private int experienceYears;
    public Employee(){}
    public Employee(String id, String name, double baseSalary, int experienceYears) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceYears = experienceYears;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + ", finalSalary=" + finalSalary + ", experienceYears=" + experienceYears + '}';
    }
}
