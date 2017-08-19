package com.thread.sleepinterupt;

import java.awt.List;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Run2 {
	public static void main(String[] args) {
		/*MyThrrad myThrrad = new MyThrrad();
		myThrrad.setDaemon(true);
		myThrrad.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		myThrrad.interrupt();*/
		String a = "a";
		String b = "a";
		System.out.println(a==b);
   
		
	}
}
