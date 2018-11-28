package com.revature.exercise;

public class Coat extends Clothing implements Wearable, Outerwear{
	public Coat() {
		super();
	}
	private boolean hasZipper;
	public Coat(String color, String size, String style, String brand, boolean top, boolean bottom, String fabric, boolean hasZipper) {
		super(color, size, style, brand, top, bottom, fabric);
		this.setHasZipper(hasZipper);
	}
	public boolean isRequired(int temperature) {
		if(temperature <= 30) {
			System.out.println("You need a coat today");
			return true;
		}else {
			System.out.println("You don't need a coat today");
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