package org.demo.mementopattern;

import java.util.HashMap;

public class Memento {
	
	private HashMap<String, Object> state;
	
	public Memento(HashMap<String, Object> state) {
		this.state = state;
	}
	public HashMap<String, Object> getState() {
		return this.state;
	}
}
