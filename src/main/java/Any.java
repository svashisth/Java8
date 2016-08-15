import java.util.concurrent.Semaphore;


public class Any
{
	private static Semaphore semaphore = new Semaphore(1);
	private static int sum = 0;
	private static int one = 1;

	public static void increment() 
	{
		try
		{
			semaphore.acquire();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		sum = sum + one;
		one++;
		semaphore.release();
	}

	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for (int i = 0; i < 5000; i++)
				{
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for (int i = 0; i < 5000; i++)
				{
					increment();
				}
			}
		});
		t1.start();
		;
		t2.start();
		try
		{
			t1.join();
			t2.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(sum);
	}
}
