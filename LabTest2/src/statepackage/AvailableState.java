package statepackage;

public class AvailableState implements ProductState{
	//the initial state of a product
	@Override
	public void prev(ProductContext productContext) {
		// TODO Auto-generated method stub
		System.out.println("Product is in root state");
		
	}

	@Override
	public void next(ProductContext productContext) {
		// TODO Auto-generated method stub
		productContext.setState(new OutOfStockState());
	}

	@Override
	public String printStatus() {
		// TODO Auto-generated method stub
		return ("instock");
	}

}
