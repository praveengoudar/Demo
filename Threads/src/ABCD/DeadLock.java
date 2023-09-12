package ABCD;
class A1  extends Thread
{
	public synchronized  void set(B1 b)
    {
        System.out.println("Thread1 Starts Execution of set()");

        try 
        {

            Thread.sleep(5000);

        }
        catch (InterruptedException e) 
        {

            e.printStackTrace();

        }

        System.out.println("Thread1 trying to call b.print");

        b.print2();
    }
    public synchronized void print1()

    {
        System.out.println("Inside A, This is last()");
    }
}

class B1 extends Thread
{

    public synchronized void get(A1 a)

    {

        System.out.println("Thread2 Starts Execution of get()");

        try 
        {

            Thread.sleep(500);

        }
        catch (InterruptedException e)
        {

            e.printStackTrace();

        }

        System.out.println("Thread2 trying to call a.print");

        a.print1();

    }

    public void print2()

    {

        System.out.println("Inside B, This is print()");

    }
}
public class DeadLock implements Runnable
{

    B1 b= new B1();

    A1 a = new A1();

     DeadLock()

    {
        Thread t = new Thread(this);
          t.start();

        a.set(b);
    }
    public static void main(String[] args) 
    {
        DeadLock d= new DeadLock();
    }
    @Override
    public void run()
    {   
    }

}