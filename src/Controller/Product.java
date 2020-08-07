package Controller;

public class Product{
	
	public String Name;
	public int ID;
	public String ProductProvider;
	public double CostPrice;
	public double SellingPrice;
	public String Color;
	public int Quantity;
	
	public Product(){
		this.Name = "nothing";
		this.ID = 00000;
		this.ProductProvider = "nothing";
		this.CostPrice = 0;
		this.SellingPrice = 0;
	    this.Color = "nothing";
	    this.Quantity = 1;
	}
	
	public Product(String name, int id, String Pprovider, double Cprice, double Sprice, String color, int quantity) {
		this.Name = name;
		this.ID = id;
		this.ProductProvider = Pprovider;
		this.CostPrice = Cprice;
		this.SellingPrice = Sprice;
		this.Color = color;
		this.Quantity = quantity;
	}
	
	public Product(Product P) {
		this.Name = P.Name + "";
		this.ID = P.ID;
		this.ProductProvider = P.ProductProvider + "";
		this.CostPrice = P.CostPrice;
		this.SellingPrice = P.SellingPrice;
		this.Color = P.Color + "";
		this.Quantity = P.Quantity;
	}
	
	public String toString() {
		return "Name = " + this.Name + "\n" +
	           "ID = " + this.ID + "\n" +
			   "Product Provider = " + this.ProductProvider + "\n" +
	   		   "Cost Price = " + this.CostPrice + "\n" +
			   "Selling Price = " + this.SellingPrice + "\n" +
		       "Color = " + this.Color + "\n" +
			   "Quantity = " + this.Quantity + "\n" + "\n";
	}
	
	//public abstract void print();
	
	//Getters & Setters

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getProductProvider() {
		return ProductProvider;
	}

	public void setProductProvider(String productProvider) {
		this.ProductProvider = productProvider;
	}

	public double getCostPrice() {
		return CostPrice;
	}

	public void setCostPrice(double costPrice) {
		this.CostPrice = costPrice;
	}

	public double getSellingprice() {
		return SellingPrice;
	}

	public void setSellingprice(double sellingprice) {
		this.SellingPrice = sellingprice;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		this.Color = color;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}

}
