package fr.altis.dbutils.model.schema;

public class Field
{

    private String name;
    
    private String type;
    
    private int size;

    public Field(String name, String type, int size)
    {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public String getName()
    {
        return name;
    }
    
    public String getType()
    {
        return type;
    }

    public int getSize()
    {
        return size;
    }

}
