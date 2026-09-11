class student
{
    String name;
    int marks;
    student (String n, int m)
    {
        name = n;
        marks = m;
    }
    void show()
    {
        System.out.println(name + " " + marks);
    }
}
class code
{
    public static void main(String[] args)
    {
        student raavi = new student ("Parneet Kaur",95);
        raavi.show();
        student sakshi = new student ("Sakshi Kumari",90);
        sakshi.show();
    }
}