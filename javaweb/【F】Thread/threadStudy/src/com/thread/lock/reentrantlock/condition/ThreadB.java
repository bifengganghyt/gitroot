package com.thread.lock.reentrantlock.condition;

public class ThreadB extends Thread{

	@Override
	public void run() {
		System.out.println("threadB start!");
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//此处rabbitmq一直在监听是否有推送消息过来，如果有message,取出requestId,传给相应的C线程，在C线程中去唤醒对应的A线程
			String requestId = "123";
			ThreadC threadC= new ThreadC(requestId);
			threadC.setName("C");
			threadC.start();
				
			String requestId2 = "abc";
			ThreadC threadC2 = new ThreadC(requestId2);
			threadC2.setName("C2");
			threadC2.start();
		}
	}
}
