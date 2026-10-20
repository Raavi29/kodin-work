abstract class PaymentProcessor
{    
    protected double amount;    
    protected String transactionId;    
    PaymentProcessor(String transactionId, double amount)    
    {        
        this.transactionId = transactionId;        
        this.amount = amount;    
    }    
    abstract void initiatePayment();    
    abstract boolean validateTransaction();    
    abstract void generateReceipt();    
    final void process()    
    {        
        System.out.println("---- Transaction " + transactionId + " ----");        
        initiatePayment();        
        if (validateTransaction())        
        {            
            generateReceipt();        
        }        
        else        
        {            
            System.out.println("Payment FAILED for " + transactionId + ". No receipt generated.");        
        }        System.out.println();    
    }
}
class CreditCardPayment extends PaymentProcessor
{    
    private String cardNumber;    
    private int cvv;    
    CreditCardPayment(String id, double amount, String cardNumber, int cvv)    
    {        
        super(id, amount);        
        this.cardNumber = cardNumber;        
        this.cvv = cvv;    
    }    
    void initiatePayment()    
    {        
        System.out.println("Credit Card: charging " + amount + " to card ending " + cardNumber.substring(cardNumber.length() - 4));    
    }    
    boolean validateTransaction()    
    {        
        return cardNumber.length() == 16 && cvv >= 100 && cvv <= 999 && amount <= 50000;    
    }    
    void generateReceipt()    
    {        
        System.out.println("Receipt [Credit Card] " + transactionId + " : " + amount + " paid");    
    }
}
class UPIPayment extends PaymentProcessor
{    
    private String upiId;    
    UPIPayment(String id, double amount, String upiId)    
    {        
        super(id, amount);        
        this.upiId = upiId;    
    }    
    void initiatePayment()    
    {        
        System.out.println("UPI: collect request of " + amount + " sent to " + upiId);    
    }    
    boolean validateTransaction()    
    {        
        return upiId.contains("@") && amount <= 100000;    
    }    
    void generateReceipt()    
    {        
        System.out.println("Receipt [UPI] " + transactionId + " : " + amount + " paid by " + upiId);    
    }
}
class NetBankingPayment extends PaymentProcessor
{    
    private String bankName;    
    private String userId;    
    NetBankingPayment(String id, double amount, String bankName, String userId)    
    {        
        super(id, amount);        
        this.bankName = bankName;        
        this.userId = userId;    
    }    
    void initiatePayment()    
    {        
        System.out.println("Net Banking: redirecting " + userId + " to " + bankName + " portal");    
    }    
    boolean validateTransaction()    
    {        
        return !userId.isEmpty() && amount > 0;    
    }    
    void generateReceipt()    
    {        
        System.out.println("Receipt [Net Banking] " + transactionId + " : " + amount + " paid via " + bankName);    
    }
}
class WalletPayment extends PaymentProcessor
{    
    private double walletBalance;    
    WalletPayment(String id, double amount, double walletBalance)    
    {        
        super(id, amount);        
        this.walletBalance = walletBalance;    
    }    
    void initiatePayment()    
    {        
        System.out.println("Wallet: debiting " + amount + " from balance " + walletBalance);    
    }    
    boolean validateTransaction()    
    {        
        return walletBalance >= amount;    
    }    
    void generateReceipt()    
    {        
        System.out.println("Receipt [Wallet] " + transactionId + " : " + amount + " paid, balance left " + (walletBalance - amount));    
    }
}
public class code13
{    
    public static void main(String[] args)    
    {        
        PaymentProcessor[] payments = {            
            new CreditCardPayment("TXN101", 2500, "4111111111111111", 123),            
            new UPIPayment("TXN102", 799, "parneet@upi"),            
            new NetBankingPayment("TXN103", 12000, "SBI", "parneet01"),            
            new WalletPayment("TXN104", 900, 450)      
        };        
        for (PaymentProcessor p : payments)        
        {            
            p.process();        
        }    
    }
}