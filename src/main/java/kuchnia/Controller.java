package kuchnia;

import baza_danych.dishes.*;
import baza_danych.querySQL;
import baza_danych.objectSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 */
public class Controller {

        private Model theModel;
        //private Viev theView;

        /// private Vievobject View;
        public Controller(Model m/*,Vievobject v*/) {
            this.theModel = m;
            //this.theView = v;
            //this.theView.dodajPrzepisListener(new DishesListener());
            //this.theView.odczytajPrzepisListener(new DishesListener2());
        }

        class DishesListener implements ActionListener{
            public void actionPerformed(ActionEvent arg0)
            {
                objectSQL o = null;
                try{
                    //o = theViev.getobjectSQL();
                    theModel.dodajPrzepis(o);
                    //theView.setPanel(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
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
            objectSQL o = null;
            try{
                //o = theViev.getobjectSQL();
                theModel.setIter(o);
                //theView.setPanel(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
                // wyswietlic
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Blad w kontrolerze");
            }
        }
    }

}
