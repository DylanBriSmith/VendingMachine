package repoPackage;

import java.util.HashMap;
import java.util.Set;

public class ProductRepo {
	//Using singleton here to ensure we only ever have one instantiation of this class
	private static ProductRepo repo;
	HashMap availableProducts = new HashMap<String, Object>();
	
	private ProductRepo() {}
	
	public static ProductRepo getInstance() {
		if(repo == null) {
			repo = new ProductRepo();
		}
		return repo;
	}

	public HashMap getMap() {
		return availableProducts;
	}

	public void setMap(HashMap map) {
		this.availableProducts = map;
	}
	
	public void add(String name, Object o) {
		this.availableProducts.put(name, o);
	}
	
	public Object getObject(String name) {
		return this.availableProducts.get(name);
	}

	public void remove(String name){
		this.availableProducts.remove(name);
	}
	public String getNames(){
		Set items= this.getMap().keySet();
		String joined = String.join(",", items);
		return joined;
	}
		
		
}
