package Controller;

public class Bed extends Product{
	protected double Height;
	protected double Length;

	public Bed() {
		super();
		this.Height = 0;
		this.Length = 0;
	}
	
	public Bed(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length){
		super(name, id, Pprovider, Cprice, Sprice, color, quantity);
		this.Height = height;
		this.Length = length;
	}
	
	public Bed(Bed B) {
		this.Height = B.Height;
		this.Length = B.Length;
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
