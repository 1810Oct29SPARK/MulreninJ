package com.revature.exercise;

public abstract class Clothing {
	
	private String color;
	private String size;
	private String style;
	private String brand;
	private String fabric;
	private boolean top;
	private boolean bottom;
	
	public Clothing() {
		super();
		System.out.println("Clothing  noargs constructor initialized");
	}
	
	public Clothing(String color, String size, String style, String brand, boolean top, boolean bottom, String fabric) {
		this();
		this.setColor(color);
		this.setSize(size);
		this.setStyle(style);
		this.setBrand(brand);
		this.setFabric(fabric);
		this.setBottom(bottom);
		this.setTop(top);
	}
	
	public abstract boolean isRequired(int temperature);

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}
}
