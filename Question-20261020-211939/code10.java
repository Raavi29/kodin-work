class Account
{    
    private int accountNumber;    
    private String holder;    
    Account(int accountNumber, String holder)    
    {        
        this.accountNumber = accountNumber;        
        this.holder = holder;    
    }    
    @Override    
    public boolean equals(Object obj)    
    {        
        if (this == obj) 
            return true;        
        if (obj == null || getClass() != obj.getClass()) 
            return false;        
        Account other = (Account) obj;        
        return accountNumber == other.accountNumber;     
    }    
    @Override    
    public int hashCode()    
    {        
        return Integer.hashCode(accountNumber);    
    }
}
class PlainAccount          
{    
    int accountNumber;    
    PlainAccount(int accountNumber)    
    {        
        this.accountNumber = accountNumber;    
    }
}
public class code10
{    
    public static void main(String[] args)    
    {        
        Account a1 = new Account(1001, "Aman");        
        Account a2 = new Account(1001, "Aman");        
        Account a3 = a1;        
        Account a4 = new Account(1002, "Riya");        
        System.out.println("a1 == a2      : " + (a1 == a2));        
        System.out.println("a1.equals(a2) : " + a1.equals(a2));        
        System.out.println("a1 == a3      : " + (a1 == a3));        
        System.out.println("a1.equals(a4) : " + a1.equals(a4));        
        PlainAccount p1 = new PlainAccount(2001);        
        PlainAccount p2 = new PlainAccount(2001);        
        System.out.println("p1.equals(p2) (no override) : " + p1.equals(p2));        
        String s1 = "java";        
        String s2 = "java";        
        String s3 = new String("java");        
        System.out.println("s1 == s2      : " + (s1 == s2));        
        System.out.println("s1 == s3      : " + (s1 == s3));        
        System.out.println("s1.equals(s3) : " + s1.equals(s3));    
    }
}