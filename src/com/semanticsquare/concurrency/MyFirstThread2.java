package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread2 extends Thread {
	
	public void run() {
		System.out.println("Inside run...");
		go();
	}
	private void go() {
		System.out.println("Inside go()...");
		more();
		
	}
	private void more() {
		System.out.println("Inside more()...");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFirstThread2 thread = new MyFirstThread2();
		thread.start();
		try {
			//Thread.sleep(3000); //current thread should cease execution for 3000 milliseconds
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside main...");
	}

}
