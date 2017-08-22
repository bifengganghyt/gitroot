package com.thread.lock.reentrantlock.condition;

public class ThreadA extends Thread{
	private Myservice myservice;

	public ThreadA(Myservice myservice) {
		super();
		this.myservice = myservice;
	}

	@Override
	public void run() {
		myservice.awaitA();
	}
}
