package Controller;

public class Mattress extends Bed{
	private String Orthopedic;
	
	public Mattress() {
		super();
		this.Orthopedic = "false";
	}
	
	public Mattress(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length, String orthopedic) {
		super(name, id, Pprovider, Cprice, Sprice, color, quantity, height, length);
	    this.Orthopedic = orthopedic;
	}
	
	public Mattress(Mattress M) {
		this.Orthopedic = M.Orthopedic;
	}
	
	public void print ()
	{
		System.out.print("Name = " + this.Name + "\n" +
	           "ID = " + this.ID + "\n" +
			   "Product Provider = " + this.ProductProvider + "\n" +
	   		   "Cost Price = " + this.CostPrice + "\n" +
			   "Selling Price = " + this.SellingPrice + "\n" +
		       "Color = " + this.Color + "\n" +
			   "Quantity = " + this.Quantity + "\n" +
			   "Height = " + this.Height + "\n" + 
		       "Length = " + this.Length + "\n" + 
		       "Orthopedic = " + this.Orthopedic + "\n" + "\n");
	}

	public String getOrthopedic() {
		return Orthopedic;
	}

	public void setOrthopedic(String Orthopedic) {
		this.Orthopedic = Orthopedic;
	}
	
}
