class Animal
{
    String name;
    void show()
    {
        System.out.println("Inside show method");
        System.out.println("Name: "+name);
    }
}
class Rabbit extends Animal
{
    int age;
    void Eat()
    {
        System.out.println("Eats carrorts");
    }
}
class code
{
    public static void main (String args[])
    {
        Animal a1 = new Animal();
        a1. name = "Small Animal";
        Rabbit r1 = new Rabbit();
        r1.name = "Rabbit";
        r1.show();
        r1.Eat();
    }
}