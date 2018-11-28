package com.revature.exercise;

public class Sweater extends Clothing implements Wearable, Outerwear {
	public Sweater() {
		super();
	}
	
	public Sweater(String color, String size, String style, String brand, boolean top, boolean bottom, String fabric) {
		super(color, size, style, brand, top, bottom, fabric);
	}
	public boolean isRequired(int temperature) {
		if(temperature <= 40) {
			System.out.println("Sweater is required");
			return true;
		}else {
			System.out.println("Sweater is  NOT required");
			return false;
		}
	}
	@Override
	public void putOn() {
		System.out.println("Put over head and pull down");
	}

	@Override
	public void takeOff() {
		System.out.println("Grab from bottom and pull over head");
	}
	
	public void warmUp() {
		System.out.println("The sweater warms you up");
	}
	
}
