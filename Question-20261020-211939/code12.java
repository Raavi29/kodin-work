final class ImmutableEmployee
{    
    private final String name;    
    private final int empId;    
    private final double salary;    
    ImmutableEmployee(String name, int empId, double salary)    
    {        
        this.name = name;        
        this.empId = empId;        
        this.salary = salary;    
    }    
    public String getName()    
    { 
        return name; 
    }    
    public int getEmpId()      
    { 
        return empId; 
    }    
    public double getSalary()  
    { 
        return salary; 
    }    
    public ImmutableEmployee withSalary(double newSalary)    
    {        
        return new ImmutableEmployee(name, empId, newSalary);    
    }    
    public String toString()    
    {        
        return empId + " | " + name + " | " + salary;    
    }
}
public class code12
{    
    public static void main(String[] args)    
    {        
        ImmutableEmployee e1 = new ImmutableEmployee("Aman Verma", 101, 40000);        
        System.out.println("e1 before : " + e1);               
        ImmutableEmployee e2 = e1.withSalary(55000);        
        System.out.println("e1 after  : " + e1);        
        System.out.println("e2 (new)  : " + e2 );        
        System.out.println("Same object? " + (e1 == e2));    
    }
}