package kuchnia;

import baza_danych.dishes.*;
import baza_danych.querySQL;
import baza_danych.objectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Stworzyc klase Model w ktorej beda collection diszes i metody je zwracajace a pozniej tylko uzywac tutaj tych metod.
public class Controller {

        private Model theModel;
        private View theView;
        private String type;
        private int pozycja=0;

        /// private Vievobject View;
        public Controller(Model m,View v) {
            this.theModel = m;
            this.theView = v;
            this.theView.dodajPrzepisListener(new DishesListener());
            this.theView.odczytajPrzepisListener(new DishesListener2());
            this.theView.wczytajPrzepisyListener(new DishesListener3());
        }

        class DishesListener implements ActionListener{
            public void actionPerformed(ActionEvent arg0)
            {
                objectSQL o = null;
                try{
                    o = theView.getobjectSQL();
                    theModel.dodajPrzepis(o);
                    theView.setPanel(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
                    // wyswietlic
                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,"Blad w kontrolerze");
                }
            }
        }
    class DishesListener2 implements ActionListener{
        public void actionPerformed(ActionEvent arg0)
        {
            try{
                pozycja = theView.getPozycja();
                System.out.println(type + " " + pozycja);
                theModel.setIter(type, pozycja);
                theView.setPanel(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
                // wyswietlic
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Blad w kontrolerze");
            }
        }
    }
    class DishesListener3 implements ActionListener{
        public void actionPerformed(ActionEvent arg0)
        {
            //objectSQL o = null;
            try{
                type = theView.getType();   //TODO zrobic cos co zwroci obiekt od buttona(tego przezroczystego na ktorym bedzie nazwa).
                System.out.println("" + type);
                theModel.setIterForType(type);
                theView.setPrzepisy(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
                // wyswietlic
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Blad w kontrolerze");
            }
        }
    }
}

/*
String name;
try{
        name = theView.getName();   //TODO zrobic cos co zwroci obiekt od buttona(tego przezroczystego na ktorym bedzie nazwa).
        System.out.println(name);   //dla sprawdzenia
        theModel.setIterForNAME(name);  //ustawia iterator odpowiednio od przepisu
        theView.setPanel(theModel.getIter());   //przekazuje juz ten konkretny iterator i moja metoda rysuje przepis
        */