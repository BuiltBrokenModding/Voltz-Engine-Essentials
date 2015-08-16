package com.builtbroken.vee.logging.block;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/** http://zetcode.com/db/mysqljava/
 * Created by Robert on 7/28/2015.
 */
public class LoggingDatabase
{
    private Connection con = null;

    // Constructor; makes database connecion
    public LoggingDatabase(String ip, String port, String username, String password) throws ClassNotFoundException, SQLException
    {
        if (con == null)
        {
            //String url = "jdbc:mysql://localhost:3306/StockTracker?user=root";
            String url = "jdbc:mysql://" + ip + ":" + port + "/BlockLogger";

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException ex)
            {
                throw new ClassNotFoundException(ex.getMessage() + "\nCannot locate com.mysql.jdbc.Driver");
            }

            try
            {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex)
            {
                throw new SQLException(ex.getMessage());
            }
        }
    }

    // Close makes database connection; null reference to connection
    public void close() throws SQLException, IOException, ClassNotFoundException
    {
        con.close();
        con = null;
    }

    // Method to serialize object to byte array
    private byte[] serializeObj(Object obj) throws IOException
    {
        ByteArrayOutputStream ba0Stream = new ByteArrayOutputStream();
        ObjectOutputStream obj0Stream = new ObjectOutputStream(ba0Stream);

        obj0Stream.writeObject(obj); // obj must be Serializable
        obj0Stream.flush();
        obj0Stream.close();
        return ba0Stream.toByteArray(); // return stream as byte array
    }

    // Method to deserialize byte from a byte array into an object
    private Object deserializeObj(byte[] buf) throws IOException, ClassNotFoundException
    {
        Object obj = null;

        if (buf != null)
        {
            ObjectInputStream objIStream = new ObjectInputStream(new ByteArrayInputStream(buf));

            obj = objIStream.readObject(); // IOException, ClassNotFoundException
        }
        return obj;
    }

    public void addPlayer(String username, UUID uuid) throws SQLException, IOException, ClassNotFoundException
    {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Players VALUES ('" + username + "','" + uuid + "')");
        stmt.close();
    }

    public void addStock(String stockSymbol, String stockDesc) throws SQLException, IOException, ClassNotFoundException
    {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Stocks VALUES ('" + stockSymbol + "','" + stockDesc + "')");
        stmt.close();
    }

    // delete a record from from the Stocks table
    private void delStock(String stockSymbol) throws SQLException, IOException, ClassNotFoundException
    {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM Stocks WHERE symbol = '" + stockSymbol + "'");
        stmt.close();
    }
}
