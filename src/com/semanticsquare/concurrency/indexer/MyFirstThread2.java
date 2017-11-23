package com.semanticsquare.concurrency.indexer;

import java.util.concurrent.TimeUnit;

public class MyFirstThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Thread thread = new Thread(task); //NEW
		thread.start(); //RUNNABLE
		try {
			TimeUnit.SECONDS.sleep(3);
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside main...");
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run...");
		// real business logic goes here
		try {
			TimeUnit.SECONDS.sleep(9);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted!");
		}
		go();
	}

	private void more() {
		System.out.println("Inside more()...");

	}

	private void go() {
		System.out.println("Inside go()...");
		more();
	}

}