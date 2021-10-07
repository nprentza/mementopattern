package org.demo.customtype;

public class testing {

    public static void main(String[] args) {
        Field<Integer> integerColumn = new Field<Integer>(Integer.class);
        Field<String> stringColumn = new Field<String>(String.class);

        FieldsGroup group = new FieldsGroup();
        group.putField(integerColumn, 3);
        group.putField(stringColumn, "3");

        System.out.println("The integer + 1: "+ (group.getField(integerColumn)+1));
        System.out.println("The string: "+ group.getField(stringColumn));
    }
	
}
