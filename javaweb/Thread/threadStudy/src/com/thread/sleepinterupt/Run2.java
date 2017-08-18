package com.thread.sleepinterupt;

public class Run2 {
	public static void main(String[] args) {
		MyThrrad myThrrad = new MyThrrad();
		myThrrad.setDaemon(true);
		myThrrad.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		myThrrad.interrupt();
	}
}
