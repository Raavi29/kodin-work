class Student
{
    private String name;
    private int rollNumber;
    public Student (String name, int rollNumber)
    {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public void displaydetails()
    {
        System.out.println("Student Name: "+name+", Roll Number: "+rollNumber);
    }
}
public class code
{
    public static void main (String args[])
    {
        Student student1 = new Student("Alice",101);
        Student student2 = new Student("Bob",102);
        System.out.println("Student Details:");
        student1.displaydetails();
        student2.displaydetails();
    }
}