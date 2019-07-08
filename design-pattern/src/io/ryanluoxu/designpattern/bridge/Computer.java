package io.ryanluoxu.designpattern.bridge;

public class Computer {
	
	protected Brand brand;
	
	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	
	void program() {
		System.out.println(brand.getBrand()+" computer is programming");
	}
}

class Desktop extends Computer {
	public Desktop(Brand brand) {
		super(brand);
	}
	
	@Override
	void program() {
		System.out.println(brand.getBrand()+" [desktop] is programming");
	}
}

class Laptop extends Computer {
	public Laptop(Brand brand) {
		super(brand);
	}
	
	@Override
	void program() {
		System.out.println(brand.getBrand()+" [laptop] is programming");
	}
}
