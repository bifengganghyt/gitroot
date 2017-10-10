package com.thread.lock.reentrantlock.condition;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		ThreadB threadB = new ThreadB();
		threadB.setName("B");
		threadB.start();
		
		String requestId0 = "123";
		ThreadA threadA0 = new ThreadA(requestId0);
		threadA0.setName("A0");
		threadA0.start();
		
		String requestId1 = "abc";
		ThreadA threadA1 = new ThreadA(requestId1);
		threadA1.setName("A1");
		threadA1.start();
		
		String requestId2 = "abcde";
		ThreadA threadA2 = new ThreadA(requestId2);
		threadA2.setName("A2");
		threadA2.start();
	}
}
