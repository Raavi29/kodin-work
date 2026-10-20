import java.util.ArrayList;
import java.util.List;
interface SmartDevice
{    
    void turnOn();    
    void turnOff();    
    String getStatus();
}
class Light implements SmartDevice
{    
    private boolean on;    
    public void turnOn()  
    { 
        on = true;  
        System.out.println("Light switched ON"); 
    }    
    public void turnOff() 
    { 
        on = false; 
        System.out.println("Light switched OFF"); 
    }    
    public String getStatus() 
    { 
        return "Light is " + (on ? "ON" : "OFF"); 
    }
}
class Fan implements SmartDevice
{    
    private boolean on;    
    private int speed;    
    public void turnOn()  
    { 
        on = true; 
        speed = 3; 
        System.out.println("Fan started at speed 3"); 
    }    
    public void turnOff() 
    { 
        on = false; 
        speed = 0; 
        System.out.println("Fan stopped"); 
    }    
    public String getStatus() 
    { 
        return "Fan is " + (on ? "ON at speed " + speed : "OFF"); 
    }
}
class AirConditioner implements SmartDevice
{    
    private boolean on;    
    private int temperature = 24;    
    public void turnOn()  
    { 
        on = true; 
        System.out.println("AC cooling to " + temperature + " C"); 
    }    
    public void turnOff() 
    { 
        on = false; 
        System.out.println("AC switched OFF"); 
    }    
    public String getStatus() 
    { 
        return "AC is " + (on ? "ON set to " + temperature + " C" : "OFF"); 
    }
}
class SecurityCamera implements SmartDevice
{    
    private boolean recording;    
    public void turnOn()  
    { 
        recording = true; 
        System.out.println("Camera recording started"); 
    }    
    public void turnOff() 
    { 
        recording = false; 
        System.out.println("Camera recording stopped"); 
    }    
    public String getStatus() 
    { 
        return "Camera is " + (recording ? "RECORDING" : "IDLE"); 
    }
}
public class code14
{    
    public static void main(String[] args)    
    {        
        List<SmartDevice> devices = new ArrayList<>();        
        devices.add(new Light());        
        devices.add(new Fan());        
        devices.add(new AirConditioner());        
        devices.add(new SecurityCamera());        
        System.out.println("== Turning everything on ==");        
        for (SmartDevice d : devices)        
        {            
            d.turnOn();        
        }        
        System.out.println("\n== Status ==");        
        for (SmartDevice d : devices)        
        {            
            System.out.println(d.getStatus());        
        }        
        System.out.println("\n== Turning everything off ==");        
        for (SmartDevice d : devices)        
        {            
            d.turnOff();        
        }        
        System.out.println("\n== Status ==");        
        for (SmartDevice d : devices)        
        {            
            System.out.println(d.getStatus());        
        }    
    }
}