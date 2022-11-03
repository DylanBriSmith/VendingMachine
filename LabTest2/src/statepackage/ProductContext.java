package statepackage;

public class ProductContext {
	//Using State design pattern here
	//initially the greated ProductState was a CreatedState() but I realised that its redundant
	private ProductState state = new AvailableState();
	
	public void setState(ProductState state) {
		this.state = state;
	}
	public ProductState getState() {
		return this.state;
	}
	public void previousState() {
		this.state.prev(this);
	}
	public void nextState() {
		this.state.next(this);
	}
	public String printStatus() {
		return this.state.printStatus();
	}
	
}
