package com.builtbroken.vee.logging.block;

import java.sql.SQLException;

/**
 * Created by Cow Pi on 7/28/2015.
 */
public class LoggingWritingThread extends Thread
{
    //TODO if in database mod ensure that the SQL call always goes threw
    //TODO if a call fails roll back the call and try 2 more times
    //TODO if a call fails 3 times print to console and move on
    LoggingDatabase database;
    String ip;
    String port;
    String username;
    String password;

    @Override
    public void run()
    {
        super.run();
        if(database == null)
        {
            try
            {
                database = new LoggingDatabase(ip, port, username, password);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            //TODO open connection to database
            //TODO que a clean database for later
            //TODO track how long the database has been open
            //TODO if database is open to long && we havn't had anything to write in the last few mins close connection and set to null
        }

        if(database != null)
        {

        }
    }
}
