package factoryPackage;

import itemsPackage.DrinkTypeA;
import itemsPackage.DrinkTypeB;
import itemsPackage.DrinkTypeC;
import itemsPackage.Product;
import itemsPackage.SnackTypeA;
import itemsPackage.SnackTypeB;
import itemsPackage.SnackTypeC;
import repoPackage.ProductRepo;

public class ProductFactory {
	//Using Factory design pattern here
	//I used this factory to create all of the products and to add the products to the repo on creation
	String[] drinks = {"Cola", "Juice", "Water"};
	String[] foods = {"chips", "chocolate", "pretzels"};

	ProductRepo repo = ProductRepo.getInstance();
	

	public Product getProduct(String name, double price, int quantity) {
		if(repo.getMap().containsKey(name)){
			return null;
		}
		for(String drink: drinks) {
			if(drink.equals(name)) {
				if(price <= 4) {
					Product newproduct = new DrinkTypeA(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
				else if(price > 4 && price <=6) {
					Product newproduct = new DrinkTypeB(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
				else if(price > 6) {
					Product newproduct = new DrinkTypeC(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
			}
		}
		for(String food: foods) {
			if(food.equals(name)) {
				if(price <= 4) {
					Product newproduct = new SnackTypeA(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
				else if(price > 4 && price <=6) {
					Product newproduct = new SnackTypeB(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
				else if(price > 6) {
					Product newproduct = new SnackTypeC(name, price, quantity);
					this.repo.add(newproduct.getName(), newproduct);
					return newproduct;
				}
			}
		}
		
		return null;
	}
}
