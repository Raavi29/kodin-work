import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
class Account
{    
    final int id;    
    double balance;    
    Account(int id, double balance)    
    {        
        this.id = id;        
        this.balance = balance;    
    }
}
public class code18
{    
    static void pause(int ms)    
    {        
        try 
        { 
            Thread.sleep(ms); 
        } 
        catch (InterruptedException e) 
        { 

        }    
    }    
    static void unsafeTransfer(Account from, Account to, double amount)    
    {        
        synchronized (from)        
        {            
            System.out.println(Thread.currentThread().getName() + " locked Account " + from.id + ", waiting for Account " + to.id);            
            pause(200);                                     
            synchronized (to)            
            {                
                from.balance -= amount;                
                to.balance += amount;                
                System.out.println(Thread.currentThread().getName() + " transferred " + amount);            
            }        
        }    
    }    
    static void orderedTransfer(Account from, Account to, double amount)    
    {        
        Account first = from.id < to.id ? from : to;        
        Account second = from.id < to.id ? to : from;        
        synchronized (first)        
        {            
            System.out.println(Thread.currentThread().getName() + " locked Account " + first.id + ", next Account " + second.id);            
            pause(200);            
            synchronized (second)            
            {                
                from.balance -= amount;                
                to.balance += amount;                
                System.out.println(Thread.currentThread().getName() + " transferred " + amount);            
            }        
        }    
    }    
    public static void main(String[] args) throws InterruptedException    
    {        
        System.out.println("=== Part 1: deadlock ===");        
        Account x = new Account(1, 5000);        
        Account y = new Account(2, 5000);        
        Thread a = new Thread(() -> unsafeTransfer(x, y, 100), "Thread-A");        
        Thread b = new Thread(() -> unsafeTransfer(y, x, 200), "Thread-B");        
        a.setDaemon(true);          
        b.setDaemon(true);        
        a.start();        
        b.start();        
        a.join(2000);        
        b.join(2000);        
        System.out.println("Thread-A state: " + a.getState());        
        System.out.println("Thread-B state: " + b.getState());        
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();        
        long[] stuck = bean.findDeadlockedThreads();        
        System.out.println("Deadlocked threads found: " + (stuck == null ? 0 : stuck.length));          
        System.out.println("\n=== Part 2: fixed with lock ordering ===");        
        Account p = new Account(1, 5000);        
        Account q = new Account(2, 5000);        
        Thread c = new Thread(() -> orderedTransfer(p, q, 100), "Thread-C");        
        Thread d = new Thread(() -> orderedTransfer(q, p, 200), "Thread-D");        
        c.start();        
        d.start();        
        c.join();        
        d.join();        
        System.out.println("Account 1 balance: " + p.balance);        
        System.out.println("Account 2 balance: " + q.balance);        
        System.out.println("Both threads finished, no deadlock.");    
    }
}