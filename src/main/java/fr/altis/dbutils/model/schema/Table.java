package fr.altis.dbutils.model.schema;

import java.util.ArrayList;
import java.util.List;

public class Table
{
    
    private String name;
    
    private List<Field> fields = new ArrayList<Field>();

    public Table(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }

    public void setFields(List<Field> fields)
    {
        this.fields = fields;
    }

    public List<Field> getFields()
    {
        return fields;
    }

}
