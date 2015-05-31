package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;

/**
 * Created by Wojciech on 2015-05-31.
 */
public class Model {
    private CollectionDishes zupy;
    private CollectionDishes DaniaMiesne;
    private CollectionDishes CiastaDesery;
    private CollectionDishes Napoje;
    private CollectionDishes SalatkaPrzystawka;
    private CollectionDishes RybyOwoceMorza;
    private IteratorDishes iter;

    public Model() {
        querySQL query = new querySQL();
        try {
            zupy = new CollectionDishes(query.selectDishes("ZUPY"));
            DaniaMiesne = new CollectionDishes(query.selectDishes("DANIA_MIESNE"));
            CiastaDesery = new CollectionDishes(query.selectDishes("CIASTA_DESERY"));
            Napoje = new CollectionDishes(query.selectDishes("Napoje"));
            SalatkaPrzystawka = new CollectionDishes(query.selectDishes("SALATKA_PRZYSTAWKI"));
            RybyOwoceMorza = new CollectionDishes(query.selectDishes("RYBY_OWOCE_MORZA"));

        } finally {
            if (query.getConnection() != null) try {
                query.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void wczytaj(String o,int ID,boolean x)
    {
        querySQL query = new querySQL();
        try{
            if (o.toUpperCase().equals("ZUPY")) {
                if(x) zupy = new CollectionDishes(query.selectDishes("ZUPY"));
                iter = zupy.iterator(ID);
            }
            else if(o.toUpperCase().equals("DANIA_MIESNE")) {
                if(x)DaniaMiesne = new CollectionDishes(query.selectDishes("DANIA_MIESNE"));
                iter = DaniaMiesne.iterator(ID);
            }
            else if(o.toUpperCase().equals("CIASTA_DESERY")) {
                if(x)CiastaDesery = new CollectionDishes(query.selectDishes("CIASTA_DESERY"));
                iter = CiastaDesery.iterator(ID);
            }
            else if(o.toUpperCase().equals("NAPOJE")) {
                if(x)Napoje = new CollectionDishes(query.selectDishes("NAPOJE"));
                iter = Napoje.iterator(ID);
            }
            else if(o.toUpperCase().equals("SALATKA_PRZYSTAWKI")) {
                if(x)SalatkaPrzystawka = new CollectionDishes(query.selectDishes("SALATKA_PRZYSTAWKI"));
                iter = SalatkaPrzystawka.iterator(ID);
            }
            else if(o.toUpperCase().equals("RYBY_OWOCE_MORZA")) {
                if(x)RybyOwoceMorza = new CollectionDishes(query.selectDishes("RYBY_OWOCE_MORZA"));
                iter = SalatkaPrzystawka.iterator(ID);
            }
        }
        finally {
            if (query.getConnection() != null) try {
                query.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void dodajPrzepis(objectSQL o)
    {
        querySQL query = new querySQL();
        try {
            // wstawianie do bazy danych
            query.insertAll(o.getRate(), o.getTitle(),
                    o.getIngredients(), o.getDescribe(), o.getComments(),
                    o.getPath(),o.toString());
            // wczytuje dane do obiektu
            this.wczytaj(o.toString(),o.getID(),true);
              //obiektwidoku.wpisz(iter); /// wypisuje to co mamy na ekran


        }
        finally {
            if (query.getConnection() != null) try {
                query.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void setIter(objectSQL o)
    {
        this.wczytaj(o.toString(),o.getID(),false);
    }
    public IteratorDishes getNextIter()
    {
        iter.next(); // przestawia iterator o jeden dalej
        return iter;
    }

    public IteratorDishes getIter()
    {
        return iter;
    }
}
