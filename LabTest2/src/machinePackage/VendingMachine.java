package machinePackage;

import java.util.Scanner;

import factoryPackage.ProductFactory;
import repoPackage.ProductRepo;
import userSelectionPackage.userSelection;

public class VendingMachine {
    private ProductFactory factory = new ProductFactory();
	private ProductRepo repo = ProductRepo.getInstance();
	private userSelection uselect = new userSelection();
	private Scanner myScanner = new Scanner(System.in);


    public void Welcome(){
        System.out.println("------------------------------");
        System.out.println("Welcome to the vending machine");
        System.out.println("------------------------------");
        factory.getProduct("Cola", 10, 2);
        factory.getProduct("Juice", 20, 3);
        factory.getProduct("Water", 5, 5);
    }
    public void Wait(){
        System.out.println("Press any key to continue");
        myScanner.nextLine();
    }
    public void selectItem(){
        System.out.println("Please select item to purchase: "+ uselect.getProductNamesAsString());
        String itemPick = myScanner.nextLine();

        if(repo.getMap().containsKey(itemPick)){
            uselect.setSelection(itemPick);
            uselect.grabProduct();
        }
        else{
            System.out.println("incorrect selection, please choose again");
            this.selectItem();
        }
    }
    public void depositMoney(){
        System.out.println("Please deposit money. Your selection costs "+uselect.getProductPrice()+" dollars");
        double inputMoney = myScanner.nextDouble();
        uselect.deposit(inputMoney);
    }
    public void checkQuantity(){
        if(uselect.getProductState().equals("instock")){
            System.out.println("We have "+uselect.getProductQuantity()+ " item(s) of "+ uselect.getProductName());
            uselect.calculateChange();
        }
        else if(uselect.getProductState().equals("outofstock")){
            System.out.println("We have "+uselect.getProductQuantity()+ " item(s) of "+ uselect.getProductName());
            System.out.println("Item "+ uselect.getProductName()+ " is not available and cannot be dispensed. Your funds of "+ uselect.getDeposit()+ " are returned");
        }
        else{
            System.out.println("cannot get item state");
        }
    }
    public void transactionEnd(){
        System.out.println("Transaction ended for item "+ uselect.getProductName());
        myScanner.nextLine();
    }


}
