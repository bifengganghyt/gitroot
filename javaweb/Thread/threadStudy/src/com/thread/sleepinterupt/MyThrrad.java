package com.thread.sleepinterupt;

public class MyThrrad extends Thread{

	@Override
	public void run() {
		while(true) {
			if(this.isInterrupted()) {
				System.out.println("ֹͣ�ˣ�");
				return;
			}
			System.out.println("timer=" + System.currentTimeMillis());
		}
	}
}
