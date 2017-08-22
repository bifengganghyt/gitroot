package com.thread.lock.reentrantlock.produceconsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Myservice {
	private Lock lock = new ReentrantLock();//�ǹ�ƽ��
	private Condition condition = lock.newCondition();
	public boolean hasValue = false;
	
	public void set() {
		try {
			lock.lock();
			while(hasValue==true) {
				System.out.println("�п���**����");
				condition.await();
			}
			
			System.out.println("��ӡ*");
			hasValue =true;
			//condition.signal();
			condition.signalAll();
			
		} catch (Exception e) {
			
		} finally {
			lock.unlock();
		}
	}
	
	public void get() {
		try {
			lock.lock();
			while(hasValue==false) {
				System.out.println("�п���&&����");
				condition.await();
			}
			
			System.out.println("��ӡ&");
			hasValue =false;
			//condition.signal();
			condition.signalAll();
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

}
