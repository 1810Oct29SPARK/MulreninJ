public class Airplane extends Vehicle {
	
	public Airplane(int numPassengers, String brand){
		this.numPassengers = numPassengers;
		this.brand = brand;
	}
	
	private int numPassengers;
	private String brand;

	@Override
	public void move(){
		System.out.println("The plane is flying");
	}

	public int getNumPassengers(){
		return this.numPassengers;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setNumPassengers(int numPassengers){
		this.numPassengers = numPassengers;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public void getDirections(){
		System.out.println("Fly to Detroit");
	}
}
