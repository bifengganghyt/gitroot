package com.thread.lock.reentrantlock.produceconsume;

public class MyThreadB extends Thread{
	private Myservice myservice;

	public MyThreadB(Myservice myservice) {
		super();
		this.myservice = myservice;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			myservice.get();
		}
	}
}
