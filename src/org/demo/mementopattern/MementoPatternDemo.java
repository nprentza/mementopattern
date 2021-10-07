package org.demo.mementopattern;

public class MementoPatternDemo {
	public static void main(String[] args) {
		
		BankAccount accountABC = new BankAccount("012343214","Account name ABC",0f);
		accountABC.credit(1000);
		accountABC.debit(77);
		
		CareTaker careTaker = new CareTaker();
		//save state (balance 923)
		careTaker.add(accountABC.saveStateToMemento());
		
		accountABC.debit(220);
		accountABC.credit(100);
		
		//save state (balance 803)
		careTaker.add(accountABC.saveStateToMemento());
		
		accountABC.debit(555);
		System.out.println("Current balance: " + accountABC.getBalance());
		
		//undo 1 step
		accountABC.undo(careTaker.get(1));
		System.out.println("balance after undo(1): " + accountABC.getBalance());
		//undo 2 steps
		accountABC.undo(careTaker.get(0));
		System.out.println("balance after undo(2): " + accountABC.getBalance());
	}
}
