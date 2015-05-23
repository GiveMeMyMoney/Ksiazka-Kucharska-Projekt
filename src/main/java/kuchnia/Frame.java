package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;
import baza_danych.sqliteConnection;

import javax.swing.*;
import java.awt.*;	//grafika
import java.awt.geom.Arc2D;
//test
//class MyScreen;


public class Frame extends JFrame {

    public static void main(String[] args) {
        querySQL[] query = new querySQL[10];
        for(int i = 0;i < 10;++i)
        {
            query[i] = new querySQL();
        }
        try {
            CollectionDishes zupy = new CollectionDishes(query[0].selectDishes("ZUPY"));
            IteratorDishes iter = zupy.iterator(0);
            while(iter.hasNext())
            {
               objectSQL c = iter.next();
               System.out.println(c.toString());
            }
            CollectionDishes DaniaMiesne = new CollectionDishes(query[1].selectDishes("DANIA_MIESNE"));
            IteratorDishes iter2 = DaniaMiesne.iterator(0);
            while(iter2.hasNext())
            {
                objectSQL c = iter2.next();
              //  System.out.println(c.toString());
            }
            CollectionDishes CiastaDesery = new CollectionDishes(query[2].selectDishes("CIASTA_DESERY"));
            IteratorDishes iter3 = CiastaDesery.iterator(0);
            while(iter3.hasNext())
            {
                objectSQL c = iter3.next();
                System.out.println(c.toString());
            }
            CollectionDishes Napoje = new CollectionDishes(query[3].selectDishes("Napoje"));
            IteratorDishes iter4 = Napoje.iterator(0);
            while(iter4.hasNext())
            {
                objectSQL c = iter4.next();
                System.out.println(c.toString());
            }
            CollectionDishes SalatkaPrzystawka = new CollectionDishes(query[4].selectDishes("SALATKA_PRZYSTAWKI"));
            IteratorDishes iter5 = SalatkaPrzystawka.iterator(0);
            while(iter5.hasNext())
            {
                objectSQL c = iter5.next();
                System.out.println(c.toString());
            }
            CollectionDishes RybyOwoceMorza = new CollectionDishes(query[5].selectDishes("RYBY_OWOCE_MORZA"));
            IteratorDishes iter6 = RybyOwoceMorza.iterator(0);
            while(iter6.hasNext())
            {
                objectSQL c = iter6.next();
                System.out.println(c.toString());
            }
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        GUI window = new GUI();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        finally
        {
            for (int i = 0;i < 10;++i)
                if(query[i].getConnection() != null) try { query[i].getConnection().close(); } catch (Exception e) { e.printStackTrace(); }

        }
    }

}
