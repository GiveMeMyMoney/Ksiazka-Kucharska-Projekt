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
            connection = SingletonsqliteConnection.getInstance().getConnInst();
            stat = connection.createStatement();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public Connection getConnection()
    {
        return connection;
    }
    /*
    Wyswietla wszystkie informacje z bazy danych
     */
    public void selectAll() {
        try {
            stat = connection.createStatement();
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
    /*
    Wstawianie nowych potraw ilosc argumentow musi byc zgodna tzn trzeba wpisac wszystko oprocz ID
     */
    public boolean insertAll(double rate, String ... args) {
        try {
            prepStmt = connection.prepareStatement(
                    "insert into Dishes values (null, ?, ?, ?, ?, ?, ?, ?);");

            rate += 0.01; // counter + 1

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
    /*
    Wybieranie potrawy po tytule raczej malo uzyteczne bedzie mozna pozniej wywalic raczej
     */
    public objectSQL selectDish(String type)
    {
        ResultSet result = null;
        try {
            PreparedStatement prepStmt;
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
    /*
    Funkcja do usuwania usuwa cos pod warunkiem czegos search to nazwa kolumny np Title a type to konkretnie np bigos
    Wazne!! Przy wowylywaniu mozna uczywac tylko obiektow tzn nie wolno wpisac ("rate",4) trzeba u�y� obiektu Double a nie double !!
     */
    public <T> boolean deleteDish(String search,T type) {
        try {
            prepStmt = connection.prepareStatement(
                    "DELETE from Dishes where " + search + " = ?;");
            if(search.toLowerCase().equals("rate"))
                prepStmt.setDouble(1, (Double) type);
            else if(search.toLowerCase().equals("id"))
                prepStmt.setInt(1, (Integer) type);
            else
                prepStmt.setString(1,(String) type);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    /*
    Wybiera caly dzial np Salatki i wpisuje wszystkie salatki do tablicy obiektow
     */
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
    /*
    Wyszukiwarka przyjmuje po czym szukamy i konkretnie co przyjmuje tylko obiekty
     */
    public <T> objectSQL browsedDish(String search,T type)
    {
        ResultSet result = null;
        try {
            prepStmt = connection.prepareStatement(" Select * from dishes where " + search + " = ?");
            if(search.toLowerCase().equals("rate"))
                prepStmt.setDouble(1, (Double) type);
            else if(search.toLowerCase().equals("id"))
                prepStmt.setInt(1, (Integer) type);
            else
                prepStmt.setString(1,(String) type);
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

    public int lastID()
    {
        int id;
        try {
            stat = connection.createStatement();
            ResultSet result = stat.executeQuery("SELECT ID FROM Dishes order by ID DESC");
            id = result.getInt("ID");

        } catch (SQLException e) {
            e.printStackTrace();
            id = 0;
        }
        JOptionPane.showMessageDialog(null,id + " TO jest ID");
        return id;
    }

    /*
    Dodawanie komentarzy po ID
     */
    public void addComments(int id,String comments)
    {
        ResultSet result = null;
        String fullComments = "";
        try {
            prepStmt = connection.prepareStatement(" Select comments from dishes where id = ? ");
            prepStmt.setInt(1, id);
            result = prepStmt.executeQuery();

            fullComments += result.getString("Comments") + "\n" +comments;

            result.close();
            prepStmt.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        try {
            prepStmt = connection.prepareStatement(" UPDATE Dishes SET Comments = ? WHERE ID = ? ;");
            prepStmt.setString(1, fullComments);
            prepStmt.setInt(2, id);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    /*
    Modyfikacja danych kol nazwa np title pozniej obiekt ktory chcemy wpisac i unikalne ID
     */
    public<T> void modify(String kol,T mod,int ID)
    {
        ResultSet result = null;
        try {
            prepStmt = connection.prepareStatement(" UPDATE Dishes SET "+ kol + " = ? WHERE ID = ? ;");
            if(kol.toLowerCase().equals("rate"))
                prepStmt.setDouble(1, (Double) mod + 0.1);
            else if(kol.toLowerCase().equals("id"))
                prepStmt.setInt(1, (Integer) mod);
            else
                prepStmt.setString(1,(String) mod);
            prepStmt.setInt(2, ID);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    /*
    Ocena po ID
    Tutaj zastsowa�em kodowanie do oceny wpisujemy tylko wartosci calkowite wszedzie przy wstawianiu modyfikacji itd.
    dla oceny 10.03 oznacza ze 10 to suma a 03 to licznik czyli ocena 10/3 = 3 bo dalem calkowite
     */
    public void rating(int rate,int id)
    {
        ResultSet result = null;
        double newrate = 0.;
        double x = 0.01;
        try {
            prepStmt = connection.prepareStatement(" Select rate from dishes where id = ? ");
            prepStmt.setInt(1, id);
            result = prepStmt.executeQuery();
            newrate = result.getDouble("Rate");
            if(result.getDouble("Rate")- (int)result.getDouble("Rate") == 0.99)
                JOptionPane.showMessageDialog(null,"Blad nie mozna dodac wiecej ocen");
            else {
                newrate += rate;
                newrate += x;
            }
            result.close();
            prepStmt.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        try {
            prepStmt = connection.prepareStatement(" UPDATE Dishes SET Rate = ? WHERE ID = ? ;");
            prepStmt.setDouble(1, newrate);
            prepStmt.setInt(2, id);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
}
