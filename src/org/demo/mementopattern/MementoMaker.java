package org.demo.mementopattern;

import java.util.HashMap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class MementoMaker {
	
	public MementoMaker() {
		
	}
	/*
	 * using java reflection
	 */
	public Memento CreateMemento(Object originator) throws IllegalArgumentException, IllegalAccessException{
		HashMap<String, Object> memento =  new HashMap<>();

		for (Field field : originator.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			memento.put(field.getName(), field.get(originator));
			//System.out.println("CreateMemento_originator.FieldName=" + field.getName()+ ", FieldValue " + field.get(originator).toString());
		}
		return new Memento(memento);
	}
	
	/*
	 * using java.beans.Introspector
	 */
	public Memento CreateMementoIntrospect(Object originator)
			 throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		HashMap<String, Object> memento =  new HashMap<>();
		Object pdValue;
		
		//To get properties defined in the originator class, use the getBeanInfo method:
		BeanInfo info = Introspector.getBeanInfo(originator.getClass(), Object.class);
		for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
	      pdValue = null;
	      if (pd.getReadMethod() != null)
	    	  pdValue = pd.getReadMethod().invoke(originator);

	      memento.put(pd.getName(), pdValue);
	      
	     // System.out.println( "Name=" + pd.getName() + "-Type=" + pd.getPropertyType() + "," +
	    //		  pd.getReadMethod().invoke(originator));
		}

		return new Memento(memento);
	}

}
