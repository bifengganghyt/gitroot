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
			
			//�˴�rabbitmqһֱ�ڼ����Ƿ���������Ϣ�����������message,ȡ��requestId,������Ӧ��C�̣߳���C�߳���ȥ���Ѷ�Ӧ��A�߳�
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
