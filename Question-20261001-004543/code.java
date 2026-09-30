class Employee
{
    public void calculateSalary()
    {
        System.out.println("Calculating employee salary");
    }
}
class FullTimeEmployee extends Employee
{
    private double monthlySalary;
    public FullTimeEmployee(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }
    @Override
    public void calculateSalary()
    {
        System.out.println("Full-Time Employee Salary (Fixed Monthly): "+monthlySalary);
    }
}
class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(int hoursWorked, double hourlyRate)
    {
        this.hoursWorked = hoursWorked;
        this.hourlyRate =hourlyRate;
    }
    @Override
    public void calculateSalary()
    {
        double salary = hoursWorked*hourlyRate;
        System.out.println("Part-Time Employee Salary ("+hoursWorked+" hours at "+hourlyRate+" per hour): "+salary);
    }
}
public class code
{
    public static void main(String args[])
    {
        Employee emp;
        emp = new FullTimeEmployee(5000.0);
        emp.calculateSalary();
        emp = new PartTimeEmployee(80,25.0);
        emp.calculateSalary();
    }
}