package kuchnia; /**
 * Created by Wojciech Zachwieja on 2015-05-11.
 */
import java.lang.Class;import java.lang.Exception;import java.sql.*;import java.sql.Connection;import java.sql.DriverManager;
import javax.swing.*;import javax.swing.JOptionPane;


public  class sqliteConnection {
    Connection conn = null;
    public static Connection dbConnector()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Wojciech\\IdeaProjects\\Ksiazka-Kucharska-Projekt\\DishesDataBase.sqlite");
            JOptionPane.showMessageDialog(null,"Succesful connection.");
            return conn;
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
