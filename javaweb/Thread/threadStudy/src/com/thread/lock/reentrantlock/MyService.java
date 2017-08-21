package com.thread.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();//非公平锁
	private Condition condition = lock.newCondition();
	
	public void await() {
		try {
			lock.lock();
			System.out.println("await时间为:" + System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
			System.out.println("await锁释放了");
		}
	}
	
	public void signal() {
		try {
			lock.lock();
			System.out.println("signal时间为:" + System.currentTimeMillis());
			condition.signal();
		} catch (Exception e) {
		} finally {
			lock.unlock();
			System.out.println("signal锁释放了");
		}
	}
}
