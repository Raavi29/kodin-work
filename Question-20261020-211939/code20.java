import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
interface Counter
{    
    void increment();    
    int get();
}
class UnsafeCounter implements Counter
{    
    private int count = 0;    
    public void increment() 
    { 
        count++; 
    }                 
    public int get()        
    { 
        return count; 
    }
}
class SyncCounter implements Counter
{    
    private int count = 0;    
    public synchronized void increment() 
    { 
        count++; 
    }    
    public synchronized int get()        
    { 
        return count; 
    }
}
class AtomicCounter implements Counter
{    
    private AtomicInteger count = new AtomicInteger(0);    
    public void increment() 
    { 
        count.incrementAndGet(); 
    } 
    public int get()        
    { 
        return count.get(); 
    }
}
class Shopper implements Runnable
{    
    private Counter counter;    
    private CountDownLatch startSignal;    
    Shopper(Counter counter, CountDownLatch startSignal)    
    {        
        this.counter = counter;        
        this.startSignal = startSignal;    
    }    
    public void run()    
    {        
        try 
        { 
            startSignal.await(); 
        } 
        catch (InterruptedException e) { }   
        for (int i = 0; i < 1000; i++)        
        {            
            counter.increment();        
        }    
    }
}
public class code20
{    
    static void test(String label, Counter counter) throws InterruptedException    
    {        
        CountDownLatch startSignal = new CountDownLatch(1);        
        Thread[] threads = new Thread[10];        
        for (int i = 0; i < 10; i++)        
        {            
            threads[i] = new Thread(new Shopper(counter, startSignal));        
        }        
        for (Thread t : threads) t.start();
        long start = System.nanoTime();        
        startSignal.countDown();                
        for (Thread t : threads) t.join();        
        long end = System.nanoTime();        
        int result = counter.get();        
        System.out.printf("%-14s final = %5d  expected = 10000  correct = %-5b  time = %.3f ms%n",                label, result, result == 10000, (end - start) / 1_000_000.0);    
    }    
    public static void main(String[] args) throws InterruptedException    
    {        
        test("Unsynchronized", new UnsafeCounter());        
        test("Synchronized", new SyncCounter());        
        test("AtomicInteger", new AtomicCounter());    
    }
}