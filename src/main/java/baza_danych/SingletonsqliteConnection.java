package baza_danych;
/**
 * Created by Wojciech on 2015-05-23.
 */
import java.sql.Connection;
import java.sql.SQLException;



public class SingletonsqliteConnection
{
    private static SingletonsqliteConnection singleInstance;
    private static Connection dbConnect;

    private SingletonsqliteConnection()
    {
            try
            {
                dbConnect  = sqliteConnection.dbConnector();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
    }

    public static SingletonsqliteConnection getInstance()
    {
        if(singleInstance == null)
        {
            synchronized (SingletonsqliteConnection.class)
            {
                if(singleInstance == null)
                {
                    singleInstance = new SingletonsqliteConnection();
                }
            }
        }
        return singleInstance;
    }

    public static Connection getConnInst()
    {
        if(dbConnect == null)
        {
                try
                {
                    dbConnect  = sqliteConnection.dbConnector();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }

        return dbConnect;
    }
}

