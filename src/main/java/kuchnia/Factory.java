package kuchnia;
import baza_danych.dishes.*;
import baza_danych.objectSQL;
/**
 * Created by Wojciech Zachwieja on 2015-05-13.
 */
public class Factory {
    public enum Dishes {
        SALATKA_PRZYSTAWKI,
        CIASTA_DESERY,
        ZUPY,
        DANIA_MIESNE,
        NAPOJE,
        RYBY_OWOCE_MORZA,
    }
    public static objectSQL FactoryDishes(int ID, String title,
                                          String describe, String ingredients, String comments, String path, double rate, String type)
    {

        Dishes currentDishes = Dishes.valueOf(type.toUpperCase());
        System.out.println("Fabryka" + currentDishes);
    switch (currentDishes) {
        case NAPOJE: return  new Napoje(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case CIASTA_DESERY: return  new Ciasta_Desery(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case SALATKA_PRZYSTAWKI: return  new Salatka_Przystawki(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case ZUPY: return new Zupy(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case RYBY_OWOCE_MORZA: return new Ryby_Owoce_Morza(ID,title, describe,  ingredients,  comments,  path,  rate,  type);
        case DANIA_MIESNE: return new Dania_Miesne(ID,title, describe,  ingredients,  comments,  path,  rate,  type);

    }
        return null;
    }


}
