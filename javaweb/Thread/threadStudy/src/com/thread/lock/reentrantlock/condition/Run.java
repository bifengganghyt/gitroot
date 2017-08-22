package com.thread.lock.reentrantlock.condition;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		Myservice myservice = new Myservice();
		ThreadA threadA = new ThreadA(myservice);
		threadA.setName("A");
		threadA.start();
		
		ThreadB threadB = new ThreadB(myservice);
		threadB.setName("B");
		threadB.start();
		
		Thread.sleep(3000);
		myservice.siganlAll_A();
	}
}
