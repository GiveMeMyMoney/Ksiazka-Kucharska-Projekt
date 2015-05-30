package kuchnia;

import baza_danych.dishes.*;
import baza_danych.querySQL;
import baza_danych.objectSQL;
/**
 */
public class Controller {

        private CollectionDishes zupy;
        private CollectionDishes DaniaMiesne;
        private CollectionDishes CiastaDesery;
        private CollectionDishes Napoje;
        private CollectionDishes SalatkaPrzystawka;
        private CollectionDishes RybyOwoceMorza;
        public IteratorDishes iter; // globalny iterator dla Viev

        /// private Vievobject View;
        public Controller(/*Vievobject View*/) {
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
        private void wczytaj(String o,int ID)
        {
            querySQL query = new querySQL();
            try{
            if (o.toUpperCase().equals("ZUPY")) {
                zupy = new CollectionDishes(query.selectDishes("ZUPY"));
                iter = zupy.iterator(ID);
            }
            else if(o.toUpperCase().equals("DANIA_MIESNE")) {
                DaniaMiesne = new CollectionDishes(query.selectDishes("DANIA_MIESNE"));
                iter = DaniaMiesne.iterator(ID);
            }
            else if(o.toUpperCase().equals("CIASTA_DESERY")) {
                CiastaDesery = new CollectionDishes(query.selectDishes("CIASTA_DESERY"));
                iter = CiastaDesery.iterator(ID);
            }
            else if(o.toUpperCase().equals("NAPOJE")) {
                Napoje = new CollectionDishes(query.selectDishes("NAPOJE"));
                iter = Napoje.iterator(ID);
            }
            else if(o.toUpperCase().equals("SALATKA_PRZYSTAWKI")) {
                SalatkaPrzystawka = new CollectionDishes(query.selectDishes("SALATKA_PRZYSTAWKI"));
                iter = SalatkaPrzystawka.iterator(ID);
            }
            else if(o.toUpperCase().equals("RYBY_OWOCE_MORZA")) {
                RybyOwoceMorza = new CollectionDishes(query.selectDishes("RYBY_OWOCE_MORZA"));
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

        public void dodaj()
        {
            querySQL query = new querySQL();
            try {
                /// zrob metode ktora tworzy obiekt SQL
                /// ObjectSQL o = obiektwidoku.dodaj(); // w metodzie zastosuj Factory
            /*
            query.insertAll(o.getRate(),o.getTitle(),
            o.getIngredients(),o.getDescribe(),o.getcomments(),
            o.getcomments(),o.gettype());
            // wstawianie do bazy danych
             this.wczytaj(); // wczytuje dane do obiektu
              obiektwidoku.wpisz(iter); /// wypisuje to co mamy na ekran
            */

            }
            finally {
                if (query.getConnection() != null) try {
                    query.getConnection().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}
