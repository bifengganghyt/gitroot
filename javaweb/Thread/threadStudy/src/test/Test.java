package test;

import com.thread.www.MyThread2;

public class Test {
	public static void main(String[] args) {
		try {
			MyThread2 myThread2 = new MyThread2();
			myThread2.setName("myThread2");
			myThread2.start();
			
			for(int i=0; i<10; i++) {
				int time = (int) (Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("main=" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
