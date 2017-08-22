package com.thread.lock.reentrantlock.condition;

public class ThreadB extends Thread{
	private Myservice myservice;

	public ThreadB(Myservice myservice) {
		super();
		this.myservice = myservice;
	}

	@Override
	public void run() {
		myservice.awaitB();
	}
}
