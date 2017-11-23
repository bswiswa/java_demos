package com.semanticsquare.concurrency;

public class MyFirstThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Thread thread = new Thread(task); //NEW
		thread.start(); //RUNNABLE
		System.out.println("Inside main...");
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside run...");
		// real business logic goes here
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