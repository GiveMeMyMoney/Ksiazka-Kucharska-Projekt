package kuchnia;
import baza_danych.dishes.*;
import baza_danych.objectSQL;
/**
 * Created by Wojciech Zachwieja on 2015-05-13.
 */
public class Factory {
    public enum Dishes {

        SALATKA,
        DESER,
        CIASTO,
    }
    public static objectSQL FactoryDishes(int ID, String title,
                                          String describe, String ingredients, String comments, String path, double rate, String type)
    {

        Dishes currentDishes = Dishes.valueOf(type.toUpperCase());

    switch (currentDishes) {
        case SALATKA: return  new Salatka(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case DESER: return  new Deser(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case CIASTO: return  new Ciasto(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
    }
        return null;
    }


}
