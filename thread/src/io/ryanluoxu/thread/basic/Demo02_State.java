package io.ryanluoxu.thread.basic;

public class Demo02_State {
	
	/**
	 * start() -> READY 
	 * READY  <-> RUNNING (if tread cannot finish within one single time slot, may be back to READY)
	 * RUNNING -> TERMINATED
	 * RUNNING -> BLOCKED -> READY 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * Termination: 
		 */
		Student student = new Student();
		new Thread(student).start();
		student.stop();
		
		/*
		 * BLOCK
		 * - join(): stop other
		 * - yield(): stop itself for a while
		 * - sleep(): still lock resource
		 */
		JoinDemo joinDemo = new JoinDemo();
		Thread joinThread = new Thread(joinDemo);
		joinThread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main ->->-> " + i);
			if (i==10) {
				joinThread.join();	// joinThread join, make main thread BLOCK.
			}
		}
		
		System.out.println("======= yield demo =========");
		yieldTest();
		
	}
	
	static void yieldTest() {
		JoinDemo joinDemo = new JoinDemo();
		Thread joinThread = new Thread(joinDemo);
		joinThread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("yieldTest ->->-> " + i);
			if (i==10) {
				Thread.yield();	// make main thread itself BLOCK for a while.
			}
		}
	}

}

class Student implements Runnable {
	private boolean flag = true;
	@Override
	public void run() {
		while (flag) {
			System.out.println("student balabala..");
		}
	}
	public void stop() {
		this.flag = false;
	}
}

class JoinDemo implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("join ->  "  + i);
		}
	}
}