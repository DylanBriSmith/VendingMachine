package main;

import machinePackage.VendingMachine;

public class clientMain {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
 		
		while(true){
		machine.Welcome();
		machine.Wait();
		machine.selectItem();
		machine.depositMoney();
		machine.checkQuantity();
		machine.transactionEnd();
		}
		
		

		
		

	}
}
