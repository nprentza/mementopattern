package org.demo.customtype;

public class Field<T> {
	private final Class<T> type;
	
	public Field(Class<T> type) {
		this.type = type;
	}
	
	public T cast(Object obj) {
		return obj == null ? null : type.cast(obj);
	}
}
