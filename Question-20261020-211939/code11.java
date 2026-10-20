class BankAccount
{    
    private double balance;    
    private final int accountNumber;    
    private String holderName;    
    BankAccount(int accountNumber, String holderName, double openingBalance)    
    {        
        this.accountNumber = accountNumber;        
        this.holderName = holderName;        
        this.balance = openingBalance >= 0 ? openingBalance : 0;    
    }    
    public void deposit(double amount)    
    {        
        if (amount <= 0)        
        {            
            System.out.println("Deposit rejected: amount must be positive");            
            return;        
        }        
        balance = balance + amount;        
        System.out.println("Deposited " + amount + " | Balance: " + balance);    
    }    
    public void withdraw(double amount)    
    {        
        if (amount <= 0)        
        {            
            System.out.println("Withdraw rejected: amount must be positive");        
        }        
        else if (amount > balance)        
        {            
            System.out.println("Withdraw rejected: insufficient balance (no overdraft)");        
        }        
        else        
        {            
            balance = balance - amount;            
            System.out.println("Withdrew " + amount + " | Balance: " + balance);        
        }    
    }    
    public double getBalance()        
    { 
        return balance; 
    }    
    public int getAccountNumber()     
    { 
        return accountNumber; 
    }    
    public String getHolderName()     
    { 
        return holderName; 
    }
}
public class code11
{    
    public static void main(String[] args)    
    {        
        BankAccount acc = new BankAccount(5001, "Parneet Kaur", 1000);        
        System.out.println("Holder: " + acc.getHolderName() + ", Account: " + acc.getAccountNumber());
        System.out.println("Opening balance: " + acc.getBalance());        
        acc.deposit(500);        
        acc.withdraw(300);        
        acc.withdraw(5000);       
        acc.deposit(-50);         
        acc.withdraw(0);          
        System.out.println("Final balance: " + acc.getBalance());    
    }
}