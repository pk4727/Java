public class methods
{
    static int squre(int a)
    {
       return a*a;
    }
    static void sum()
    {
        System.out.println("no return and use static keyword  so no need of object");
    }
    void Sum()
    {
        System.out.println("no static method so we need object for it when calling");
    }
    public static void main (String[] args)
    {
        int r=squre(5);
        System.out.println("squre is "+r);
        sum();
        methods m=new methods();
        m.Sum();
    }
}