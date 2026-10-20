class Account
{    
    protected int accNo;    
    protected double balance;    
    Account(int accNo, double balance)    
    {        
        this.accNo = accNo;        
        this.balance = balance;    
    }    
    void showBalance()    
    {        
        System.out.println("Account " + accNo + " balance: " + balance);    
    }
}
class SavingsAccount extends Account
{    
    private double rate = 0.04;    
    SavingsAccount(int accNo, double balance) 
    { 
        super(accNo, balance); 
    }    
    void addInterest()    
    {        
        balance = balance + balance * rate;        
        System.out.println("  Interest added, new balance: " + balance);    
    }
}
class CurrentAccount extends Account
{    
    private double overdraftLimit = 10000;    
    CurrentAccount(int accNo, double balance) 
    { 
        super(accNo, balance); 
    }    
    void showOverdraft()    
    {        
        System.out.println("  Overdraft limit: " + overdraftLimit);    
    }
}
class LoanAccount extends Account
{    
    private double emi = 5000;    
    LoanAccount(int accNo, double balance) 
    { 
        super(accNo, balance); 
    }    
    void payEmi()    
    {        
        balance = balance - emi;        
        System.out.println("  EMI paid, outstanding loan: " + balance);    
    }
}
public class code16
{    
    public static void main(String[] args)    
    {        
        Account[] accounts = {            
            new SavingsAccount(1, 20000),            
            new CurrentAccount(2, 15000),            
            new LoanAccount(3, 100000)        
        };        
        System.out.println("== Safe downcasting with instanceof ==");        
        for (Account a : accounts)        
        {            
            a.showBalance();            
            if (a instanceof SavingsAccount)            
            {                
                SavingsAccount s = (SavingsAccount) a;                
                s.addInterest();            
            }            
            else if (a instanceof CurrentAccount)            
            {                
                CurrentAccount c = (CurrentAccount) a;                
                c.showOverdraft();            
            }            
            else if (a instanceof LoanAccount)            
            {                
                LoanAccount l = (LoanAccount) a;                
                l.payEmi();            
            }        
        }        
        System.out.println("\n== Improper casting ==");        
        Account risky = accounts[0];            
        try        
        {            
            LoanAccount wrong = (LoanAccount) risky;    
            wrong.payEmi();        
        }        
        catch (ClassCastException e)        
        {            
            System.out.println("ClassCastException: a SavingsAccount object cannot be treated as a LoanAccount");        
        }        
        System.out.println("\n== Avoiding it ==");        
        if (risky instanceof LoanAccount)        
        {            
            ((LoanAccount) risky).payEmi();        
        }        
        else        
        {            
            System.out.println("Cast skipped: object is not a LoanAccount");        
        }    
    }
}