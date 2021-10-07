package org.demo.mementopattern.basic;

public class Memento {

	// a simple example of a state
	private String state;
	
	public Memento(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	}	

}
