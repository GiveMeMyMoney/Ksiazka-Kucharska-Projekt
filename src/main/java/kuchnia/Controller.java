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

        /// private Vievobject View;
        public Controller(Model m,View v) {
            this.theModel = m;
            this.theView = v;
            this.theView.dodajPrzepisListener(new DishesListener());
            //this.theView.odczytajPrzepisListener(new DishesListener2());
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
                //o = theViev.getobjectSQL();   //TODO zrobic cos co zwroci obiekt od buttona(tego przezroczystego na ktorym bedzie nazwa).
                //theModel.setIter();
                //theView.setPanel(theModel.getIter());  // tutaj wstawia ci iterator nastawiony na to co ma
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
            objectSQL o = null;
            String type;
            try{
                type = theView.getType();   //TODO zrobic cos co zwroci obiekt od buttona(tego przezroczystego na ktorym bedzie nazwa).
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
