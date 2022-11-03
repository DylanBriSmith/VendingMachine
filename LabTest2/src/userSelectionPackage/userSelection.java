package userSelectionPackage;

import itemsPackage.Product;
import repoPackage.ProductRepo;
import statepackage.OutOfStockState;


public class userSelection {
    //Im not completely sure on if this is a facade.  I didnt want to include it in the brief incase it isnt a facade 
    //Here I am doing some simple client math with the change function,
    //And implemented other methods that engage with the objects included below
    //I guess it is kind of a facade if it is holding all of these classes and functions
    private String selectedProductName;
    private Product selectedProduct;
    private double inputedMoney;
    private double change;
    ProductRepo repo = ProductRepo.getInstance();

    public void grabProduct(){
        Product product = (Product) this.repo.getObject(this.selectedProductName);
        this.selectedProduct = product;
    }
    public void deposit(double cash){
        this.inputedMoney = cash;
    }
    public double getDeposit(){
        double temp = this.inputedMoney;
        this.inputedMoney = 0;
        return temp;
    }

    public void calculateChange(){
        double price = this.selectedProduct.getPrice();
        if(this.inputedMoney >= price){
            this.change = this.inputedMoney - price;
            this.selectedProduct.setQuantity(this.selectedProduct.getQuantity() - 1);
            System.out.println("You provided "+ this.inputedMoney+" dollars. The product was "+ this.selectedProduct.getPrice()+ " . Your change is "+ this.change);
            this.change = 0;
            if(this.selectedProduct.getQuantity() == 0){
                this.selectedProduct.setState(new OutOfStockState());
            }
        }
        else if(this.inputedMoney < price){
            System.out.println("Insufficient funds for item "+ this.getProductName()+". You have provided "+ this.inputedMoney+ " dollars. Item costs "+ this.getProductPrice()+ " dollars. Funds returned");
        }
        this.inputedMoney =- price;
    }
    public void setSelection(String name){
        this.selectedProductName = name;
    }

    public double getProductPrice(){
        if(this.selectedProduct != null){
            return this.selectedProduct.getPrice();
        }
        return 0;
    }
    public int getProductQuantity(){
        return this.selectedProduct.getQuantity();
    }
    public String getProductName(){
        return this.selectedProduct.getName();
    }
    public String getProductState(){
        return this.selectedProduct.getPrintStatus();
    }
    public String getProductNamesAsString(){
        return this.repo.getNames();
    }
}
