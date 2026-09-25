abstract class Vehicle
{
    abstract void startEngine();
}
class Car extends Vehicle
{
    @Override
    void startEngine()
    {
        System.out.println("Car Engine Started");
    }
}
class Motorcycle extends Vehicle
{
    @Override
    void startEngine()
    {
        System.out.println("Motorcycle Engine Started");
    }
}
public class code
{
    public static void main (String args[])
    {
        Car c = new Car();
        Motorcycle m = new Motorcycle();
        c.startEngine();
        m.startEngine();
    }
}