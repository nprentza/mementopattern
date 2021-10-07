package org.demo.customtype;

import java.util.HashMap;
import java.util.Map;

public class FieldsGroup {

	private Map<Field<?>, Object> fields= 
			new HashMap<Field<?>, Object>();
	
    public <T> void putField(Field<T> type, T instance) {
        if (type == null)
              throw new NullPointerException("Type is null");

        fields.put(type, instance.getClass().cast(instance));
    }
    
    public <T> T getField(Field<T> type) {

        return type.cast(fields.get(type));
    }    

}
