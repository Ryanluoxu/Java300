package io.ryanluoxu.designpattern.bridge;

/**
 * Apply when object is generated from multiple degree<br>
 * Brand: Dell, HP, Lenovo
 * Computer: Desktop, Laptop, Pad
 * @author luoxu
 *
 */
public class BridgeDemo {

	public static void main(String[] args) {
		Computer computer01 = new Desktop(new Dell());
		program(computer01);
		
		Computer computer02 = new Laptop(new HP());
		program(computer02);
	}

	private static void program(Computer computer) {
		computer.program();
	}

}
