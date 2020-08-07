package Controller;

public class Sofa extends Product{
	public double Height;
	private double Length;
	private String Opens;

	public Sofa() {
		super();
		this.Height = 0;
		this.Length = 0;
		this.Opens = "false";
	}
	
	public Sofa(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length, String opens){
		super(name, id, Pprovider, Cprice, Sprice, color, quantity);
		this.Height = height;
		this.Length = length;
		this.Opens = opens;
	}
	
	public Sofa(Sofa S) {
		this.Height = S.Height;
		this.Length = S.Length;
		this.Opens = S.Opens;
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
		       "Opens = " + this.Opens + "\n" + "\n");
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
	
	public String getisOpens() {
		return Opens;
	}

	public void setOpens(String opens) {
		this.Opens = opens;
	}
}
