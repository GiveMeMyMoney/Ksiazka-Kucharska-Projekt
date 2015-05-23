package baza_danych.dishes;
import baza_danych.objectSQL;
/**
 * Created by Wojciech on 2015-05-23.
 */

public class Ryby_Owoce_Morza extends objectSQL {
    String type;

    public Ryby_Owoce_Morza(int ID, String title, String describe, String ingredients, String comments, String path, double rate, String type) {
        super(ID, title, describe, ingredients, comments, path, rate);
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}
