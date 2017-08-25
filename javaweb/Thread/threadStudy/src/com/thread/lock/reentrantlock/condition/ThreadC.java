package com.thread.lock.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


public class ThreadC extends Thread {
	
	private String requestId;
	
	public ThreadC(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"start!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Lock lock = DataCache.getLock(requestId);
		lock.lock();
		Condition condition = DataCache.getConditon(requestId);
		if (condition != null) {
			condition.signalAll();
		}
		System.out.println(Thread.currentThread().getName()+"end");
		lock.unlock();
	}
}
