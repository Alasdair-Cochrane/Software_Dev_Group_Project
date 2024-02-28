//example of a different way to parse objects into a text file implementing the interface//
// Recieves an object and writes its instance variables to a text string using reflection//

import java.lang.reflect.*;

public class ReflectionWriter implements AppDataWriter {

 public <T> void writeObject(T t)
 {
    String output = t.getClass().getName();
    output += "/";
    Field[] fields = t.getClass().getDeclaredFields();
    Field.setAccessible(fields,true);
    for (Field field : fields) {
        output += field.getName();
        output += "=";
        if(field.getType().isArray())
        {
            output += writeArray(field, t);
        }
        else{
        try {

            output += field.get(t).toString();
        } catch (IllegalAccessException e) {
            output += " ,";
            System.out.println("can't get value");
        }        
    }  
    output += ",";  
    }
    output += "\n";
    System.out.println(output);
 }


 private static String writeArray(Field array, Object t)
 {
    String str = "{";    
    Object[] entries = null;
    try {
        entries = (Object[])array.get(t);
    } catch (IllegalAccessException e) {

        e.printStackTrace();
    }    
    for (int i = 0; i < entries.length; i++) {
        str += Array.get(entries, i);
        if (i < entries.length -1) {
            str += ";";
        }  
    }
    str += "}";
    return str;
 }




}
