package fr.altis.dbutils.model.check;

public class Difference
{
    private Object object;
    
    private String checkName;
    
    public Difference(String object, String checkName) {
        this.object = object;
        this.checkName = checkName;
    }

    public Object getObject()
    {
        return object;
    }
    
    public String getCheckName()
    {
        return checkName;
    }

}
