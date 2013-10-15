package fr.altis.dbutils.model.destination;

import java.sql.Connection;
import java.sql.SQLException;

public interface Destination
{
    
    Connection getConnection() throws SQLException;
    
    String getSchemaName();

}
