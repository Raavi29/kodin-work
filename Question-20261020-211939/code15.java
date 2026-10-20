class Employee
{    
    protected String name;    
    protected double basicSalary;    
    Employee(String name, double basicSalary)    
    {        
        this.name = name;        
        this.basicSalary = basicSalary;    
    }    
    double computeSalary()    
    {        
        return basicSalary;    
    }    
    void show()    
    {        
        System.out.println(getClass().getSimpleName() + " " + name + " earns " + computeSalary());    
    }
}
class Manager extends Employee
{    
    protected int teamSize;    
    Manager(String name, double basicSalary, int teamSize)    
    {        
        super(name, basicSalary);        
        this.teamSize = teamSize;    
    }    
    @Override    
    double computeSalary()    
    {        
        double teamBonus = teamSize * 2000;                  
        return super.computeSalary() + teamBonus;    
    }
}
class Director extends Manager
{    
    private int performanceRating;      
    Director(String name, double basicSalary, int teamSize, int performanceRating)    
    {        
        super(name, basicSalary, teamSize);        
        this.performanceRating = performanceRating;    
    }    
    @Override    
    double computeSalary()    
    {        
        double incentive = performanceRating * 10000;   
        return super.computeSalary() + incentive;       
    }
}
public class code15
{    
    public static void main(String[] args)    
    {        
        Employee e = new Employee("Aman", 30000);        
        Employee m = new Manager("Riya", 50000, 5);          
        Employee d = new Director("Kabir", 90000, 12, 4);    
        Employee[] staff = {e, m, d};        
        for (Employee emp : staff)        
        {            
            emp.show();         
        }    
    }
}