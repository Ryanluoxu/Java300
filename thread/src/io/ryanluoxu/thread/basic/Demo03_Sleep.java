package io.ryanluoxu.thread.basic;

public class Demo03_Sleep {

	public static void main(String[] args) throws InterruptedException {
		
		// count down
		int number = 100;
		while (number > 0) {
			System.out.println(number--);
			Thread.sleep(1000);
		}
	}

}
