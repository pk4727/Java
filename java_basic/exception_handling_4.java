class exception_handling_4
{
    void check()
    {
        int a[]=new int[10];
        try
        {
            System.out.println("value is "+a[22]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
class ff
{
    public static void main(String[] args)
    {
        exception_handling_4 a=new exception_handling_4();
        a.check();
    }
}