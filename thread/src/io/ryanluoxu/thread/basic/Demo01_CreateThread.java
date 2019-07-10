package io.ryanluoxu.thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 01: extends Thread and override run()
 * 02: implement Runnable and override run()
 * 03: implement Callable<T>. T is the return type. override call()
 * @author luoxu
 *
 */
public class Demo01_CreateThread {
	
	public static void main(String[] args) {
		/*
		 * 01
		 */
		Rabbit rabbit = new Rabbit();
		rabbit.start();
		
		/*
		 * 02: static proxy: car(real), thread(proxy)
		 */
		Car car = new Car();	
		Thread t01 = new Thread(car);
		t01.start();
		
		/*
		 * 03: able to return value and handle exception
		 */
		SumTask sumTask = new SumTask(10);
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<Integer> future = executorService.submit(sumTask);
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * 01: extends Thread and override run()
 * @author luoxu
 */
class Rabbit extends Thread {
	@Override
	public void run() {
		System.out.println("Rabbit is running..2m/s");
	}
}

/**
 * 02: implement Runnable and override run()
 * 	- static proxy: override run() for the action of real role.
 * @author luoxu
 */
class Car implements Runnable{
	@Override
	public void run() {
		System.out.println("Car is running..10m/s");
	}
}

/**
 * 03: implement Callable<T>. T is the return type. override call()
 * @author luoxu
 */
class SumTask implements Callable<Integer>{
	private int n;
	public SumTask(int n) {
		this.n = n;
	}
	@Override
	public Integer call() throws Exception {
		Integer result = 0;
		for (int i = 0; i < n; i++) {
			result+=i;
		}
		return result;
	}
}