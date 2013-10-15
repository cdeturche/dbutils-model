package fr.altis.dbutils.model.destination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerDestination implements Destination
{
    private final String url;

    private final String user;

    private final String password;

    public DriverManagerDestination(String url, String user, String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public String getSchemaName()
    {
        return "jademp";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + url.hashCode();
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        DriverManagerDestination other = (DriverManagerDestination) obj;
        if (password == null)
        {
            if (other.password != null)
            {
                return false;
            }
        }
        else if (!password.equals(other.password))
        {
            return false;
        }
        if (!url.equals(other.url))
        {
            return false;
        }
        if (user == null)
        {
            if (other.user != null)
            {
                return false;
            }
        }
        else if (!user.equals(other.user))
        {
            return false;
        }
        return true;
    }
}