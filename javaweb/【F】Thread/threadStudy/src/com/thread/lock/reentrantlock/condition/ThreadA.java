package com.thread.lock.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadA extends Thread{
	private  Lock lock = new ReentrantLock();
	private String requestId;
	
	public ThreadA(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + "wait!");
		
		DataCache.setLock(requestId, lock);
		Condition condition = lock.newCondition();
		DataCache.setCondition(requestId, condition);
		try {
			System.out.println(Thread.currentThread().getName() + "执行完业务  进入等待……");
			condition.await();
			System.out.println(Thread.currentThread().getName() + "被唤醒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
