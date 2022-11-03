package statepackage;

public class OutOfStockState implements ProductState{

	@Override
	public void prev(ProductContext productContext) {
		// TODO Auto-generated method stub
		productContext.setState(new AvailableState());
	}

	@Override
	public void next(ProductContext productContext) {
		// TODO Auto-generated method stub
		System.out.println("Product is in its final state");
	}

	@Override
	public String printStatus() {
		// TODO Auto-generated method stub
		return"outofstock";
	}

}
