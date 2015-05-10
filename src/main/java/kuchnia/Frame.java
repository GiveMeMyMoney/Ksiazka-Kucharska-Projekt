package kuchnia;

import com.sun.xml.internal.bind.v2.TODO;
import javax.swing.*;
import java.awt.*;	//grafika

public class Frame extends JFrame {
    private static String title = "Kuchenne Rewolucje";
    private static Dimension size = new Dimension (1000, 650);

    public Frame() {		//constr.
        setTitle(title);    //tytul
        setSize(size);      //rozmiar
        setResizable(false);	//zmiana rozmiaru okienka-ustawiona na true.
        //setLayout(null);
        setLocationRelativeTo(null);	//null- okienko wyskakuje na srodku ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //asd




        init();
    }

    private void init() {
        setLayout(new GridLayout(1,1,0,0));
        MyScreen screen = new MyScreen(this);
        add(screen);


        setVisible(true);	//wyswietlanie
    }


    public static void main(String[] args) {
        //aby unikn¹æ zakleszczeñ tworzenie GUI zawsze zlecamy dla w¹tku obs³ugi zdarzeñ
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Frame frame = new Frame();;
            }
        });


    }

}
