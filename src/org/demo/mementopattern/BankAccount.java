package org.demo.mementopattern;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BankAccount {
	
	private String accountNo;
	private String accountName;
	private float balance;
	
	// do we need this? 
	//	its just the container to copy fields from Originator to Memento
	// HashMap<String, Object> state; 
	
	public BankAccount(String accNo, String accName, float initBalance) {
		this.accountNo = accNo;
		this.accountName = accName;
		this.balance = initBalance;
	}
	
	public void debit(float amount) {
		this.balance -= amount;
	}
	
	public void credit(float amount) {
		this.balance += amount;
	}
	
	// set/get fields
	//	set:
	public void setAccountNo(String accNo) {
		this.accountNo = accNo;
	}
	public void setAccountName(String accName) {
		this.accountName = accName;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	// get:
	public String getAccountNo() {
		return this.accountNo;
	}
	public String getAccountName() {
		return this.accountName;
	}
	public float getBalance() {
		return this.balance;
	}
	
	/*
	 * Memento pattern
	 */
	//	setState: 
	private void setState(HashMap<String, Object> state) throws IllegalArgumentException, IllegalAccessException {
		this.accountNo = state.get("accountNo").toString();
		this.accountName = state.get("accountName").toString();
		this.balance = (float) state.get("balance");
		
		//System.out.println("BankAccount.setSate:" + this.accountNo + "," + this.accountName + "," + this.balance);
	}
	
	/*
	public Memento saveStateToMemento() {
		this.state = new HashMap<>();
		this.state.put("accountNo", this.accountNo);
		this.state.put("accountName", this.accountName);
		this.state.put("balance", this.balance);
		
		System.out.println("Bankaccount saving to memento, balance= " + this.balance);
		
		return new Memento(this.state);
	}*/
	
	// undo - go to the state saved in the memento
	public void undo(Memento memento) throws IllegalArgumentException, IllegalAccessException {
		this.setState(memento.getState());
	}
	
}
