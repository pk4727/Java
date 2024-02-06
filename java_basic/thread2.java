class A1 extends Thread
{
	public void run()
	{
		for(int i = 10;i<=50;i++)
		{
			if(i%5==0)
			{
				System.out.println("Multiple of 5 = "+i);
			}
		}
	}
}

class B2
{
	public static void main(String args[])
	{
		A1 mul = new A1();
		mul.setPriority(1);
		Thread.currentThread().setPriority(10);
		System.out.println("priority of thread1(Multiple of 5) are :- "+mul.getPriority());
		System.out.println("priority of thread2 are(Multiple of 7) :- "+Thread.currentThread().getPriority());

		mul.start();
		
		for(int i = 10;i<=50;i++)
		{
			if(i%7==0)
			{
				System.out.println("Multiple of 7 ="+i);
			}
		}
	}
}