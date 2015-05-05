package kuchnia;

import com.sun.xml.internal.bind.v2.TODO;
import javax.swing.*;
import java.awt.*;	//grafika

//class MyScreen;

public class Frame extends JFrame {
    private static String title = "Kuchenne Rewolucje";
    private static Dimension size = new Dimension (1000, 650);

    public Frame() {		//constr.
        setTitle(title);    //tytul
        setSize(size);      //rozmiar
        setResizable(true);	//zmiana rozmiaru okienka-ustawiona na true. //TODO zmienic pozniej na TRUE poniewaz moze powodowac problemy.
        setLocationRelativeTo(null);	//null- okienko wyskakuje na srodku ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        //setLayout(new GridLayout(1, 1, 0, 0));
        MyScreen screen = new MyScreen();
        add(screen);

        setVisible(true);	//wyswietlanie
    }


    public static void main(String[] args) {
        new Frame();
    }

}
