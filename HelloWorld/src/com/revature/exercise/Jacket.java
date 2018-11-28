package com.revature.exercise;

public class Jacket extends Clothing implements Wearable, Outerwear{
	public Jacket() {
		super();
	}
	private boolean hasZipper;
	public Jacket(String color, String size, String style, String brand, boolean top, boolean bottom, String fabric, boolean hasZipper) {
		super(color, size, style, brand, top, bottom, fabric);
		this.setHasZipper(hasZipper);
	}
	public boolean isRequired(int temperature) {
		if(temperature <= 50) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void putOn() {
		System.out.println("Put on sleeves first then pull over body");
	}

	@Override
	public void takeOff() {
		System.out.println("Make sure its unzipped and remove from arms");
	}
	
	public void zipUp() {
		System.out.println("You zip up the jacket");
	}
	public void unZip() {
		System.out.println("You unzip the jacket");
	}
	public boolean isHasZipper() {
		return hasZipper;
	}
	public void setHasZipper(boolean hasZipper) {
		this.hasZipper = hasZipper;
	}
	
}
