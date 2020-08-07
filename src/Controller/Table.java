package Controller;

public abstract class Table extends Product{
	protected double Height;
	protected double Length;

	public Table() {
		super();
		this.Height = 0;
		this.Length = 0;
	}
	
	public Table(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length){
		super(name, id, Pprovider, Cprice, Sprice, color, quantity);
		this.Height = height;
		this.Length = length;
	}
	
	public Table(Table T) {
		this.Height = T.Height;
		this.Length = T.Length;
	}
	
	//Getters & Setters
	
	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public double getLength() {
		return Length;
	}

	public void setLength(double length) {
		Length = length;
	}
	
}
