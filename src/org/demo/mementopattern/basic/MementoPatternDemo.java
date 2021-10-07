package org.demo.mementopattern.basic;

import java.lang.reflect.Field;

public class MementoPatternDemo {
	
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());
		
		// testing reflection
		printFields(originator);
		
		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());
	}
	
	public static void printFields(Object obj) {
		System.out.println("Testing reflection _ printFields()");
		
		Field[] thisFields = obj.getClass().getFields();
		
		System.out.println("thisFields.length=" + thisFields.length);
		
		for (Field f : thisFields) {
			System.out.println("field_name=" + f.getName() + ", .toGenericString=" + f.toGenericString());
		}
	}
}
