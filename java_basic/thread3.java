class thread3
{
    public static void main(String[] args) 
    {
        thread1 t1=new thread1();
        thread2 t2=new thread2();
        t1.start();
        t2.start();
        try
        {
            for (int i=0;i<5;i++)
            {
                System.out.println("pradhuman");
                Thread.sleep(3000);
            } 
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
class thread1 extends Thread
{
    public void run()
    {
        try
        {
            for (int i=0;i<5;i++)
            {
                System.out.println(i);
                Thread.sleep(1000);
            } 
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
class thread2 extends Thread
{
    public void run()
    {
        try
        {
            for (int i=0;i<5;i++)
            {
                System.out.println("pk");
                Thread.sleep(2000);
            } 
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
