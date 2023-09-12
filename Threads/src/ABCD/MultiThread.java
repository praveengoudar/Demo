package ABCD;
class Demo
{
	synchronized public void print()
	{
		System.out.println(Thread.currentThread().getName());
	}
}
class A extends Demo implements Runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			print();
		}
	}
}
class B extends Demo implements Runnable
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			print();
		}  
				
	}
}

public class MultiThread 

{
	public static void main(String[] args) throws InterruptedException
	{
		A a=new A();
		Thread t1=new Thread(a);
		t1.start();
		t1.join();
		
		B b=new B();
		Thread t2=new Thread(b);
		t2.start();
		t2.join();
	}
}

