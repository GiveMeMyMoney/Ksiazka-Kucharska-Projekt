package kuchnia;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//na razie nie u¿ywam
class Przycisk extends JButton implements ActionListener {
    private String nazwa;

    Przycisk(String co) {
        super(co);
        nazwa=co;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(nazwa=="wyszukaj") {
            System.out.println("Wyszukano konkretnego przepisu");
        }
        else if(nazwa=="ocen")
            System.out.println("DZIEKUJEMY ZA OCENE! :)");
    }
}
