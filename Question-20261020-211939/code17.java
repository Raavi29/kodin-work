import java.util.LinkedList;
class OrderQueue
{    
    private final LinkedList<String> orders = new LinkedList<>();    
    private final int capacity;    OrderQueue(int capacity)    
    {        
        this.capacity = capacity;    
    }    
    synchronized void placeOrder(String dish) throws InterruptedException    
    {        
        while (orders.size() == capacity)        
        {            
            System.out.println("Counter full, chef waits...");            
            wait();                         
        }        
        orders.addLast(dish);        
        System.out.println("Chef prepared  : " + dish + "   [queue size " + orders.size() + "]");        
        notifyAll();                        
    }    
    synchronized String serveOrder() throws InterruptedException    
    {        
        while (orders.isEmpty())        
        {            
            System.out.println("Counter empty, waiter waits...");            
            wait();        
        }        
        String dish = orders.removeFirst();        
        System.out.println("Waiter served  : " + dish + "   [queue size " + orders.size() + "]");        
        notifyAll();                        
        return dish;    
    }
}
class Chef extends Thread
{    
    private OrderQueue queue;    
    Chef(OrderQueue queue) 
    { 
        this.queue = queue; 
    }    
    public void run()    
    {        
        String[] menu = {"Pizza", "Pasta", "Burger", "Noodles", "Paneer Tikka", "Dosa"};        
        try        
        {            
            for (String dish : menu)            
            {                
                queue.placeOrder(dish);                
                Thread.sleep(200);          
            }        
        }        
        catch (InterruptedException e)        
        {            
            e.printStackTrace();        
        }    
    }
}
class Waiter extends Thread
{    
    private OrderQueue queue;    
    Waiter(OrderQueue queue) 
    { 
        this.queue = queue; 
    }    
    public void run()    
    {        
        try        
        {            
            for (int i = 0; i < 6; i++)            
            {                
                queue.serveOrder();                
                Thread.sleep(600);          
            }        
        }        
        catch (InterruptedException e)        
        {            
            e.printStackTrace();        
        }    
    }
}
public class code17
{    
    public static void main(String[] args) throws InterruptedException    
    {        
        OrderQueue queue = new OrderQueue(2);       
        Chef chef = new Chef(queue);        
        Waiter waiter = new Waiter(queue);        
        chef.start();        
        waiter.start();        
        chef.join();        
        waiter.join();        
        System.out.println("All orders served.");    
    }
}