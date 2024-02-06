public class classs
{
    int a;
    public void input()
    {
        a=5;
    }
    public void display()
    {
        System.out.println("Value of a = "+a);
    }
}
class BBB
{
    public static void main(String args[])
    {
        classs a1=new classs();
        a1.input();
        a1.display();
    }
}
