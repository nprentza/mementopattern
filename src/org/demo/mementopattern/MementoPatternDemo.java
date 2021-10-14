package org.demo.mementopattern;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MementoPatternDemo {
	
	/**
	 *	TESTING with MementoMaker 
	 */
	public static void main(String[] args) {
		
		CareTaker careTaker = new CareTaker(); //the container of mementos, currently for a particular object
		MementoMaker mementoMaker = new MementoMaker(); // the memento maker, for any given object
		
		// testing with a bankaccount as the originator object
		BankAccount accountABC = new BankAccount("012343214","Account name ABC",0f);
		accountABC.credit(1000);
		accountABC.debit(77);
		
		try {
			//Memento m = mementoMaker.CreateMementoIntrospect(accountABC);
			
			
			//save state (balance 923)
			careTaker.add(mementoMaker.CreateMementoIntrospect(accountABC));
			//	mementos in careTaker object --> 1
			
			accountABC.debit(220);
			accountABC.credit(100);

			//save state (balance 803)
			careTaker.add(mementoMaker.CreateMementoIntrospect(accountABC));
			//	mementos in careTaker object --> 2
			
			accountABC.debit(555);
			System.out.println("Current balance: " + accountABC.getBalance());

			//undo 1 step
			accountABC.undo(careTaker.get(1));
			System.out.println("balance after undo(1): " + accountABC.getBalance());
			//undo 2 steps
			accountABC.undo(careTaker.get(0));
			System.out.println("balance after undo(2): " + accountABC.getBalance());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	
	
	/*
	 * Testing BankAccount creating the Memento
	 */
	/*public static void main_(String[] args) {
		
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
	}*/
}
