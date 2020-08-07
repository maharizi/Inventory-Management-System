package Controller;

public class ComputerTable extends Table{
	private String Drawer;
	private String Material;

	public ComputerTable() {
		super();
		this.Drawer = "false";
		this.Material = "nothing";
	}
	
	public ComputerTable(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length, String drawer, String material) {
		super(name, id, Pprovider, Cprice, Sprice, color, quantity, height, length);
	    this.Material = material;
	    this.Drawer = drawer;
	}
	
	public ComputerTable(ComputerTable C) {
		super();
		this.Drawer = C.Drawer;
		this.Material = C.Material;
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
			   "Drawer = " + this.Drawer + "\n" +
			   "Material = " + this.Material + "\n" + "\n");
	}
	
	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		this.Material = material;
	}

	public String getisDrawer() {
		return Drawer;
	}

	public void setDrawer(String drawer) {
		this.Drawer = drawer;
	}
	
}
