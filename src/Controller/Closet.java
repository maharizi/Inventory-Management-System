package Controller;

public class Closet extends Product{
	private double Height;
	private double Length;
	private String Sliding;

	public Closet() {
		super();
		this.Height = 0;
		this.Length = 0;
		this.Sliding = "false";
	}
	
	public Closet(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length, String sliding){
		super(name, id, Pprovider, Cprice, Sprice, color, quantity);
		this.Height = height;
		this.Length = length;
		this.Sliding = sliding;
	}
	
	public Closet(Closet C) {
		this.Height = C.Height;
		this.Length = C.Length;
		this.Sliding = C.Sliding;
	}
	
	public void print ()
	{
		System.out.print(
			   "Name = " + this.Name + "\n" +
	           "ID = " + this.ID + "\n" +
			   "Product Provider = " + this.ProductProvider + "\n" +
	   		   "Cost Price = " + this.CostPrice + "\n" +
			   "Selling Price = " + this.SellingPrice + "\n" +
		       "Color = " + this.Color + "\n" +
			   "Quantity = " + this.Quantity + "\n" +
		       "Height = " + this.Height + "\n" + 
		       "Length = " + this.Length + "\n" + 
		       "Sliding = " + this.Sliding + "\n" + "\n");
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
	
	public String getisSliding() {
		return Sliding;
	}

	public void setSliding(String sliding) {
		this.Sliding = sliding;
	}
}
