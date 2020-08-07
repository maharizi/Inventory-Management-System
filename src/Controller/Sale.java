package Controller;

public class Sale {
	
	public String Name;
	public String Product;
	public int Id;
	public String Address;
	public int Month;
	private int Price;
	
	public Sale(){
		this.Name = "nothing";
		this.Product = "nothing";
		this.Id = 0;
		this.Address = "nothing";
		this.Month = 0;
	    this.Price = 0;
	}
	
	public Sale(String name, String Product, int id, String address, int month, int price) {
		this.Name = name;
		this.Product = Product;
		this.Id = id;
		this.Address = address;
		this.Month = month;
		this.Price = price;
	}
	
	public Sale(Sale S) {
		this.Name = S.Name + "";
		this.Product = S.Product + "";
		this.Id = S.Id;
		this.Address = S.Address + "";
		this.Month = S.Month;
		this.Price = S.Price;
	}
	
	public String toString() {
		return "Name = " + this.Name + "\n" +
	           "LastName = " + this.Product + "\n" +
			   "Id = " + this.Id + "\n" +
	   		   "Address = " + this.Address + "\n" +
			   "Month = " + this.Month + "\n" + 
			   "Price = " + this.Price + "\n" + "\n";
	}
	
	//Getters & Setters

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		this.Product = product;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		this.Month = month;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		this.Price = price;
	}
	
}
