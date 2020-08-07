package Controller;

public class DiningTable extends Table{
	private int NumPlaces;
	private String IsOpen;
	
	public DiningTable() {
		super();
		this.NumPlaces = 0;
		this.IsOpen = "false";
	}
	
	public DiningTable(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity, double height, double length,int NumPlaces, String isopen) {
		super(name, id, Pprovider, Cprice, Sprice, color, quantity, height, length);
	    this.NumPlaces = NumPlaces;
	    this.IsOpen = isopen;
	}
	
	public DiningTable(DiningTable D) {
		super();
		this.NumPlaces = D.NumPlaces;
		this.IsOpen = D.IsOpen;
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
		       "Number of Places = " + this.NumPlaces + "\n" + 
		       "IsOpen = " + this.IsOpen + "\n" + "\n");
	}

	public int getNumPlaces() {
		return NumPlaces;
	}

	public void setNumPlaces(int numPlaces) {
		this.NumPlaces = numPlaces;
	}
	
	public String getisIsOpen() {
		return IsOpen;
	}

	public void setIsOpen(String isOpen) {
		this.IsOpen = isOpen;
	}
}
