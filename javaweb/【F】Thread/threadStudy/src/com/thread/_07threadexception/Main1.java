package com.thread._07threadexception;

import java.lang.Thread.UncaughtExceptionHandler;

public class Main1 {
	public static void main(String[] args) {
		/*Mythread mythread1 = new Mythread();
		mythread1.setName("�߳�t1");
		mythread1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("�߳�:" + t.getName() + "�������쳣��");
				e.printStackTrace();
			}
		});
		mythread1.start();
		
		Mythread mythread2 = new Mythread();
		mythread2.setName("�߳�t2");
		mythread2.start();
	}*/
		Mythread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
			}
		});
		
	}
}
