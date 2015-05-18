package baza_danych.dishes;
import baza_danych.objectSQL;
/**
 * Created by Wojciech Zachwieja on 2015-05-13.
 */
public class Salatka extends objectSQL {
    String type;

    public Salatka(int ID, String title, String describe, String ingredients, String comments, String path, double rate, String type) {
        super(ID, title, describe, ingredients, comments, path, rate);
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}