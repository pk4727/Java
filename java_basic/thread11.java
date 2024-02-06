public class thread11 extends Thread
{
	public void run()
	{
		try
		{
			Thread.sleep(10);
			for(int i = 10;i<=50;i++)
			{
				if(i%2==0)
				{
					System.out.println("Even = "+i+" ");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Child Thread Is Interrupted");
		}
	System.out.println("\n");
	}
}
class BBBB
{
	public static void main(String args[])
	{
		thread1 even = new thread1();
		even.start();
		try
		{
			Thread.sleep(1000);
			for(int i = 10;i<=50;i++)
			{
				if(i%2!=0)
				{
					System.out.println("Odd ="+i+" ");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Main Thread Is Interrupted");
		}
	}
}
