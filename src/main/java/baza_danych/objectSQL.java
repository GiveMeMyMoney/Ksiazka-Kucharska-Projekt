package baza_danych;

/**
 * Created by Wojciech Zachwieja on 2015-05-13.
 */
public abstract class objectSQL {
    private int ID;
    private String title;
    private String describe;
    private String ingredients;
    private String comments;
    private String path;
    private double rate;

    public objectSQL(int ID,String title, String describe, String ingredients, String comments, String path, double rate) {
        this.title = title;
        this.ID = ID;
        this.describe = describe;
        this.ingredients = ingredients;
        this.comments = comments;
        this.path = path;
        this.rate = rate;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescribe() {
        return describe;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getComments() {
        return comments;
    }

    public String getPath() {
        return path;
    }

    public int getRate() {

        if(rate == 0.01 || rate == 0.0)
            return 0;
        else
            return (int) ((int)rate / ((rate - (int)rate) * 100)); // for example 10.02 10 is sigma 02 is counter  rate = sigma / counter
    }
}

