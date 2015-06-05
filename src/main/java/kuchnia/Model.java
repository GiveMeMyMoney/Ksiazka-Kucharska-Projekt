package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;

import javax.swing.*;

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
    private querySQL query = new querySQL();
    public Model() {

            zupy = new CollectionDishes(query.selectDishes("ZUPY"));
            DaniaMiesne = new CollectionDishes(query.selectDishes("DANIA_MIESNE"));
            CiastaDesery = new CollectionDishes(query.selectDishes("CIASTA_DESERY"));
            Napoje = new CollectionDishes(query.selectDishes("Napoje"));
            SalatkaPrzystawka = new CollectionDishes(query.selectDishes("SALATKA_PRZYSTAWKI"));
            RybyOwoceMorza = new CollectionDishes(query.selectDishes("RYBY_OWOCE_MORZA"));

    }
    private void wczytaj(String o,int n,boolean x)
    {
            if (o.toUpperCase().equals("ZUPY")) {
                if(x) {
                    zupy = new CollectionDishes(query.selectDishes("ZUPY"));
                    iter = zupy.iteratorID(n);
                }
                else
                    iter = zupy.iteratorPos(n);
            }
            else if(o.toUpperCase().equals("DANIA_MIESNE")) {
                if(x) {
                    DaniaMiesne = new CollectionDishes(query.selectDishes("DANIA_MIESNE"));
                    iter = DaniaMiesne.iteratorID(n);
                }
                else
                    iter = DaniaMiesne.iteratorPos(n);
            }

            else if(o.toUpperCase().equals("CIASTA_DESERY")) {
                if(x) {
                    CiastaDesery = new CollectionDishes(query.selectDishes("CIASTA_DESERY"));
                    iter = CiastaDesery.iteratorID(n);
                }
                else
                    iter = CiastaDesery.iteratorPos(n);
            }
            else if(o.toUpperCase().equals("NAPOJE")) {
                if(x) {
                    Napoje = new CollectionDishes(query.selectDishes("NAPOJE"));
                    iter = Napoje.iteratorID(n);
                }
                else
                    iter = Napoje.iteratorPos(n);
            }
            else if(o.toUpperCase().equals("SALATKA_PRZYSTAWKI")) {
                if(x) {
                    SalatkaPrzystawka = new CollectionDishes(query.selectDishes("SALATKA_PRZYSTAWKI"));
                    iter = SalatkaPrzystawka.iteratorID(n);
                }
                else
                    iter = SalatkaPrzystawka.iteratorPos(n);
            }
            else if(o.toUpperCase().equals("RYBY_OWOCE_MORZA")) {
                if(x) {
                    RybyOwoceMorza = new CollectionDishes(query.selectDishes("RYBY_OWOCE_MORZA"));
                    iter = SalatkaPrzystawka.iteratorID(n);
                }
                else
                    iter = SalatkaPrzystawka.iteratorPos(n);
            }

    }
    public void dodajPrzepis(objectSQL o)
    {
            // wstawianie do bazy danych
            query.insertAll(o.getRate(), o.getTitle(),
                    o.getIngredients(), o.getDescribe(), o.getComments(),
                    o.getPath(),o.toString());
            // wczytuje dane do obiektu
            this.wczytaj(o.toString(), o.getID(), true);
              //obiektwidoku.wpisz(iter); /// wypisuje to co mamy na ekran


    }
    public void setIter(String Type,int pos)
    {
        this.wczytaj(Type,pos,false);
    }
    public void setIterForType(String Type)
    {
        this.wczytaj(Type,0,false);
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(query.getConnection() != null) try { query.getConnection().close(); } catch (Exception e) { e.printStackTrace(); }

    }
}
