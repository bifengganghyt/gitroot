package com.thread.lock.reentrantlock.produceconsume;

public class MyThreadA extends Thread{
	private Myservice myservice;

	public MyThreadA(Myservice myservice) {
		super();
		this.myservice = myservice;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			myservice.set();
		}
	}
}
