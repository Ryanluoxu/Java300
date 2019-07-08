package io.ryanluoxu.designpattern.bridge;

public interface Brand {
	String getBrand();
}

class Dell implements Brand {
	@Override
	public String getBrand() {
		return "[Dell]";
	}
}

class HP implements Brand {
	@Override
	public String getBrand() {
		return "[HP]";
	}
}