package fr.altis.dbutils.model.check;

import java.util.List;

public interface Check
{

    public static final String MISSING_TABLES = "missing_tables";
    public static final String NO_LONGER_EXISTS_TABLES = "no_longer_exists_tables";
    public static final String MISSING_FIELDS = "missing_fields";
    public static final String NO_LONGER_EXISTS_FIELDS = "no_longer_exists_fields";
    public static final String DIFFERENT_TYPES_FIELDS = "different_types_fields";
    
    List<Difference> check();

}
