package com.thread.lock.reentrantlock;

public class Run {
	public static void main(String[] args) {
		MyService myService = new MyService();
		ThreadA threadA = new ThreadA(myService);
		threadA.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myService.signal();
	}
}
