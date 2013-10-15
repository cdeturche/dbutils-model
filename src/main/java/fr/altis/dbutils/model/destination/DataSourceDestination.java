package fr.altis.dbutils.model.destination;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DataSourceDestination implements Destination
{
    private final DataSource dataSource;
    
    private final String schemaName;
    
    /**
     * Constructor
     * @param dataSource the wrapped DataSource
     */
    public DataSourceDestination(DataSource dataSource, String schemaName) {
        this.dataSource = dataSource;
        this.schemaName = schemaName;
    }

    @Override
    public Connection getConnection() throws SQLException
    {
        return dataSource.getConnection();
    }

    @Override
    public String getSchemaName()
    {
        return schemaName;
    }

}
