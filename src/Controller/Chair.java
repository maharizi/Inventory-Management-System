package Controller;

public class Chair extends Product{
	protected double Height;
	protected double Length;

	public Chair() {
		super();
		this.Height = 0;
		this.Length = 0;
	}
	
	public Chair(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length){
		super(name, id, Pprovider, Cprice, Sprice, color, quantity);
		this.Height = height;
		this.Length = length;
	}
	
	public Chair(Chair C) {
		this.Height = C.Height;
		this.Length = C.Length;
	}
	
	//Getters & Setters
	
	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		this.Height = height;
	}

	public double getLength() {
		return Length;
	}

	public void setLength(double length) {
		this.Length = length;
	}
	
}
