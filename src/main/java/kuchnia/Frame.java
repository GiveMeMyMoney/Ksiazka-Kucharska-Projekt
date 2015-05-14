package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;

import javax.swing.*;
import java.awt.*;	//grafika
import java.awt.geom.Arc2D;
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
        //MyScreen screen = new MyScreen();
        //add(screen);

        setVisible(true);	//wyswietlanie
    }


    public static void main(String[] args) {
        querySQL query = new querySQL(); //instrukcja do polaczenia z baza i przygotowania do zapytan

        Double x = 4.; /// do oceniania niezbedne sa obiekty
        query.insertAll(5, "Salatka Grecka", "Pomidory ogorki favita", "Wymieszaj ladnie", "Smaczna w chuj", "chuj na razie z obrazkiem", "Salatka");
        objectSQL danie1 = query.browsedDish("TITLE","Salatka Grecka");
        query.rating(4,danie1.getID());
        JOptionPane.showMessageDialog(null, danie1.getRate());
        danie1 = query.browsedDish("ID", danie1.getID());
        JOptionPane.showMessageDialog(null,danie1.getRate());
        query.modify("Rate",x, danie1.getID());
        JOptionPane.showMessageDialog(null, danie1.getRate());
        query.deleteDish("TITLE","Salatka Grecka");

        GUI myGUI = new GUI();
    }

}
