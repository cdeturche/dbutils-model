package fr.altis.dbutils.model.schema;

import java.util.ArrayList;
import java.util.List;

public class SchemaHelper
{
    
    public static List<String> getTableNames(List<Table> tables) {
        List<String> names = new ArrayList<String>();
        
        for(Table table : tables) {
            names.add(table.getName());
        }
        
        return names;
    }
    
    public static List<String> getFieldNames(List<Field> fields) {
        List<String> names = new ArrayList<String>();
        
        for(Field field : fields) {
            names.add(field.getName());
        }
        
        return names;
    }
    
    public static List<String> getFieldNames(Table table) {
        return getFieldNames(table.getFields());
    }

}
