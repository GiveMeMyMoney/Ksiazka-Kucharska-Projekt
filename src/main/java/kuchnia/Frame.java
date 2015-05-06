package kuchnia;

import com.sun.xml.internal.bind.v2.TODO;
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
        Frame frame = new Frame();


    }

}
