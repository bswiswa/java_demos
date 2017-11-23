package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stop;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			public void run() {
				System.out.println("running");
				while(!stop) {
					System.out.println("not stopped");
				}
			}
		}).start();
		TimeUnit.SECONDS.sleep(1);
		stop = true;
	}

}
