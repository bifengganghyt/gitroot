package test;

import com.thread.www.MyThread5;

public class TestMyThread5 {
	public static void main(String[] args) {
		MyThread5 myThread5 = new MyThread5();
		Thread a = new Thread(myThread5);
		Thread b = new Thread(myThread5);
		Thread c = new Thread(myThread5);
		Thread d = new Thread(myThread5);
		Thread e = new Thread(myThread5);
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
