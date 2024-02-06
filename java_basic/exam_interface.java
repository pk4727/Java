/* WAP in java to create an interface exam with the decleration of methode percentage also create a student class
   that consists of name, rollno. and marks of individual subj implement the program by creating result class that
   will avaible compute the pecentage of student using multiple inheritance */
// Exam interface with percentage method declaration

interface Exam 
{
    float percentage(float[] marks);
}
class Student
{
    String name;
    int rollno;
    float[] marks;

    Student(String name, int rollno, float[] marks) 
    {
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }
}
class Result extends Student implements Exam 
{
    Result(String name, int rollno, float[] marks) 
    {
        super(name, rollno, marks);
    }
    public float percentage(float[] marks) 
    {
        float total = 0;
        for (float mark : marks) 
        {
            total += mark;
        }
        return (total / marks.length);
    }
}
class Main 
{
    public static void main(String[] args) 
    {
        float[] marks = {85.5f, 90.0f, 92.5f, 80.0f, 88.5f};
        Result result = new Result("John", 12345, marks);
        System.out.println("Student Name: " + result.name);
        System.out.println("Roll No.: " + result.rollno);
        System.out.println("Percentage: " + result.percentage(marks));
    }
}
class raugh 
{
    public int myField;
    public void myMethod() 
    {
        System.out.println("Hello from Superclass");
    }
    public static void main(String[] args) 
    {
        Subclass s=new Subclass();
        s.myMethod();
    }
}
class Subclass extends raugh 
{
    public int myField;
    public void myMethod() 
    {
        super.myMethod(); 			// calls the myMethod() method of the superclass
        System.out.println("Hello from Subclass");
    }
    
    public void anotherMethod() 
    {
        super.myField = 42;			 // accesses the myField field of the superclass
        this.myField = 24;			 // accesses the myField field of the subclass
    }
}