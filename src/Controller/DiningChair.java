package Controller;

public class DiningChair extends Table{
	private String Fabric;
	
	public DiningChair() {
		super();
		this.Fabric = "nothing";
	}
	
	public DiningChair(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length, String Fabric) {
		super(name, id, Pprovider, Cprice, Sprice, color, quantity, height, length);
	    this.Fabric = Fabric;
	}
	
	public DiningChair(DiningChair D) {
		super();
		this.Fabric = D.Fabric;
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
		       "Fabric = " + this.Fabric + "\n" + "\n");
	}

	public String getFabric() {
		return Fabric;
	}

	public void setFabric(String Fabric) {
		this.Fabric = Fabric;
	}
	
}
