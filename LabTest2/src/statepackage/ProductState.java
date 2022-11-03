package statepackage;

public interface ProductState {

	void prev(ProductContext productContext);

	void next(ProductContext productContext);

	String printStatus();

}
