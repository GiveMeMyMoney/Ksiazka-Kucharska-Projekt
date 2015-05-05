package kuchnia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MyScreen extends JPanel implements ActionListener {
    //public static final int HEIGHT = 650;
    //public static final int WIDTH = 700;
    private BufferedImage tloImage;    //obrazki
    private JButton wyszukajButton; boolean przycisk1 = false;
    private JButton ocenButton;     boolean przycisk2 = false;

    public MyScreen() {
        Images();
        Buttony();

    }

    private void Buttony() { //tworzenie potrzebnych przyciskow.
        wyszukajButton = new JButton("wyszukaj");
        ocenButton = new JButton("ocen");
        wyszukajButton.addActionListener(this);
        ocenButton.addActionListener(this);
        add(wyszukajButton);
        add(ocenButton);
    }

    private void Images() { //wyswietlanie obrazkow
        File imageFile = new File("tlo.jpg");
        try {
            tloImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(tloImage, 0, 0, this);
        if(przycisk1==true) {
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("Wyszukano konkretnego przepisu", 400 / 2, 400 / 2);
            przycisk1=false;
        }
        if(przycisk2==true) {
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("DZIEKUJEMY ZA OCENE! :)", 400 / 2, 400 / 2);
            przycisk2=false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==wyszukajButton) {
            System.out.println("Wyszukano konkretnego przepisu");
            przycisk1=true;
        }
        else if(source==ocenButton) {
            System.out.println("DZIEKUJEMY ZA OCENE! :)");
            przycisk2=true;
        }
    }

}