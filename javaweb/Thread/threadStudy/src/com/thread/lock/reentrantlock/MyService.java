package com.thread.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private Lock lock = new ReentrantLock();//�ǹ�ƽ��
	private Condition condition = lock.newCondition();
	
	public void await() {
		try {
			lock.lock();
			System.out.println("awaitʱ��Ϊ:" + System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
			System.out.println("await���ͷ���");
		}
	}
	
	public void signal() {
		try {
			lock.lock();
			System.out.println("signalʱ��Ϊ:" + System.currentTimeMillis());
			condition.signal();
		} catch (Exception e) {
		} finally {
			lock.unlock();
			System.out.println("signal���ͷ���");
		}
	}
}
