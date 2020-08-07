package Controller;

public class ComputerChair extends Table{
	private int NumWheels;
	
	public ComputerChair() {
		super();
		this.NumWheels = 0;
	}
	
	public ComputerChair(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length,int NWheels) {
		super(name, id, Pprovider, Cprice, Sprice, color, quantity, height, length);
	    this.NumWheels = NWheels;
	}
	
	public ComputerChair(ComputerChair C) {
		super();
		this.NumWheels = C.NumWheels;
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
		       "Number of Wheels = " + this.NumWheels + "\n" + "\n");
	}

	public int getNumWheels() {
		return NumWheels;
	}

	public void setNumWheels(int NumWheels) {
		this.NumWheels = NumWheels;
	}
	
}
