import java.util.concurrent.atomic.AtomicInteger;
class TicketCounter
{    
    private int seats = 1;                                  
    private final AtomicInteger bookings = new AtomicInteger();    
    void bookUnsafe(String user)    
    {        
        if (seats > 0)                                      
        {            
            pause();                                                   
            seats--;                                        
            bookings.incrementAndGet();            
            System.out.println(user + " booked the seat");        
        }        
        else        
        {            
            System.out.println(user + " found no seat");        
        }    
    }    
    synchronized void bookSafe(String user)                 
    {        
        if (seats > 0)        
        {            
            pause();            
            seats--;            
            bookings.incrementAndGet();            
            System.out.println(user + " booked the seat");        
        }        
        else        
        {            
            System.out.println(user + " found no seat");        
        }    
    }    
    int getSeats()    
    { 
        return seats; 
    }    
    int getBookings() 
    { 
        return bookings.get(); 
    }    
    private void pause()    
    {        
        try 
        { 
            Thread.sleep(50); 
        } 
        catch (InterruptedException e) { }    
    }
}
class Customer extends Thread
{    
    private TicketCounter counter;    
    private boolean safe;    
    Customer(String name, TicketCounter counter, boolean safe)    
    {        
        super(name);        
        this.counter = counter;        
        this.safe = safe;    
    }    
    public void run()    
    {        
        if (safe) 
            counter.bookSafe(getName());        
        else      
            counter.bookUnsafe(getName());    
    }
}
public class code19
{    
    static void simulate(boolean safe) throws InterruptedException    
    {        
        TicketCounter counter = new TicketCounter();        
        Customer[] users = new Customer[10];        
        for (int i = 0; i < 10; i++)        
        {            
            users[i] = new Customer("User-" + (i + 1), counter, safe);        
        }        
        for (Customer u : users) 
            u.start();        
        for (Customer u : users) 
            u.join();        
        System.out.println("Seats available at the start : 1");        
        System.out.println("Successful bookings          : " + counter.getBookings());        
        System.out.println("Seats left                   : " + counter.getSeats());    
    }    
    public static void main(String[] args) throws InterruptedException    
    {        
        System.out.println("=== Without synchronization ===");        
        simulate(false);        
        System.out.println("\n=== With synchronized ===");        
        simulate(true);    
    }
}