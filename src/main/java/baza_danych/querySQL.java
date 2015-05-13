package baza_danych; /**
 * Created by Wojciech Zachwieja on 2015-05-12.
 */

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import kuchnia.Factory;
public class querySQL {
    private Connection connection;
    private Statement stat;
    private PreparedStatement prepStmt;
    public querySQL()
    {
        try {
            connection = sqliteConnection.dbConnector();
            stat = connection.createStatement();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void selectAll() {
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Dishes");
            int id;
            String title, type, describe, path, comments;
            double rate;
            while(result.next()) {
                id = result.getInt("ID");
                title = result.getString("Title");
                type = result.getString("Type");
                describe = result.getString("Describe");
                path = result.getString("Path");
                comments = result.getString("Comments");
                rate = result.getDouble("Rate");
                JOptionPane.showMessageDialog(null, "ID " + id + " Tytul " + title + " Kategoria " + type + " Opis " + describe + " Wiecej danych nie wypisuje to tylko dla testowania");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertAll(double rate, String ... args) {
        try {
            prepStmt = connection.prepareStatement(
                    "insert into Dishes values (null, ?, ?, ?, ?, ?, ?, ?);");

            //prepStmt.setInt(1,12);
            for(int i = 1;i < 8;++i) {
                if(i < 4)
                    prepStmt.setString(i, args[i - 1]);
                else if(i == 4)
                    prepStmt.setDouble(i,rate);
                else
                    prepStmt.setString(i, args[i - 2]);
            }
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    public objectSQL selectDish(String type)
    {
        ResultSet result = null;
        try {
            prepStmt = connection.prepareStatement(" Select * from dishes where title = ?");

            prepStmt.setString(1, type);
            result = prepStmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        objectSQL date = null;
        try {
            date = Factory.FactoryDishes(result.getInt("ID"), result.getString("Title"), result.getString("Describe"),
                    result.getString("Ingredients"), result.getString("Comments"), result.getString("Path"),
                    result.getDouble("Rate"), result.getString("Type"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return date;
    }
    public boolean deleteDish(String Title) {
        try {
            prepStmt = connection.prepareStatement(
                    "DELETE from Dishes where title = ?;");

            prepStmt.setString(1,Title);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    public objectSQL[] selectDishes(String type)
    {
        ResultSet result = null;
        try {
            prepStmt = connection.prepareStatement(" Select * from dishes where type = ? order by title");
            prepStmt.setString(1, type);
            result = prepStmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        int lenghtbase = 1;
        try {
            while(result.next()) {
                lenghtbase = result.getRow();
            }
            result.close();
            result = prepStmt.executeQuery();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        objectSQL[] arr_data = new objectSQL[lenghtbase];
        objectSQL date;
        try {
            int i = 0;
            while(result.next()) {
                date = Factory.FactoryDishes(result.getInt("ID"), result.getString("Title"), result.getString("Describe"),
                        result.getString("Ingredients"), result.getString("Comments"), result.getString("Path"),
                        result.getDouble("Rate"), result.getString("Type"));
                arr_data[i++] = date;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return arr_data;
    }
}
