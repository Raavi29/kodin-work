class Calculator
{
    public int add(int a, int b)
    {
        return a+b;
    }
    public double add(double a, double b)
    {
        return a+b;
    }
    public int add(int a, int b, int c)
    {
        return a+b+c;
    }
    public int add(int a, int b, int c, int d)
    {
        return a+b+c+d;
    }
}
public class code
{
    public static void main(String args[])
    {
        Calculator calc = new Calculator();
        System.out.println("Sum of 2 integers (10+20): "+calc.add(10,20));
        System.out.println("Sum of 2 decimals (10.5+20.3): "+calc.add(10.5,20.3));
        System.out.println("Sum of 3 integers (5+10+15): "+calc.add(5,10,15));
        System.out.println("Sum of 4 integers (1+2+3+4): "+calc.add(1,2,3,4));
    }
}