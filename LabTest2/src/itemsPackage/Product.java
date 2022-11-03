package itemsPackage;

import statepackage.ProductContext;
import statepackage.ProductState;

public abstract class Product{
	//the abstract class that all the items extend
	private String name;
	private double price;
	private int quantity;
	
	private ProductContext statecontext= new ProductContext();

	
	
	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//integration of state in the product itself
	public ProductState getState(){
		return this.statecontext.getState();
	}
	public void setState(ProductState newstate){
			this.statecontext.setState(newstate);
	}
	public String getPrintStatus(){
		return this.statecontext.printStatus();
	}
	
	
}