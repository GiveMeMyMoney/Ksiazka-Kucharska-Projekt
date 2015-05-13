package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;

import javax.swing.*;
import java.awt.*;	//grafika
//testtest
//class MyScreen;


public class Frame extends JFrame {
    private static String title = "Kuchenne Rewolucje";
    private static Dimension size = new Dimension (1000, 650);

    public Frame() {		//constr.
        setTitle(title);    //tytul
        setSize(size);      //rozmiar
        setResizable(false);	//zmiana rozmiaru okienka-ustawiona na true.
        setLocationRelativeTo(null);	//null- okienko wyskakuje na srodku ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        //setLayout(new FlowLayout());
        MyScreen screen = new MyScreen();
        add(screen);

        setVisible(true);	//wyswietlanie
    }


    public static void main(String[] args) {
        querySQL query = new querySQL(); //instrukcja do polaczenia z baza i przygotowania do zapytan
        /*
        Dodalem nowe funkcje:
        selectAll wyswietla wszystko co jest w bazie funckja bardziej do testowania
        insertAll wstawia dane do bazy trzeba podac wszytskie argumenty
        selectDishes pobiera wszystko z danej kategorii i zwraca do tablicy
        deleteDish usuwa pozycje o zadanej nazwie
        objectSQL ma metody do zwracania wszystkich danych
        tutaj pokazalem przykladowe uzycie
        wiec mozecie usunac wszystko poza
        querySQL query = new querySQL();
        Frame frame = new Frame();
         */
        query.insertAll(5.,"Salatka Grecka","Pomidory ogorki favita","Wymieszaj ladnie","Smaczna w chuj","chuj na razie z obrazkiem","Salatka");
        objectSQL[] danie2 = query.selectDishes("Salatka");
        for(int i = 0; i < danie2.length;++i)
        {
            JOptionPane.showMessageDialog(null,danie2[i].getID());
            JOptionPane.showMessageDialog(null,danie2[i].getDescribe());
        }
        query.deleteDish("Salatka Grecka");
        Frame frame = new Frame();


    }

}
