/*package kuchnia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyScreen extends JPanel implements ActionListener {
    //public static final int HEIGHT = 650;
    //public static final int WIDTH = 700;
    //private BufferedImage cosImage;
    BufferedImage tloImage;
    BufferedImage Image1;
    JButton wyszukajButton; boolean przycisk1 = false;
    JButton ocenButton;     boolean przycisk2 = false;

    JTextField tf;

    public MyScreen() {
        //Images();
        Buttony();
        Tekst();
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
        File imageFile2 = new File("java.jpg");
        try {
            tloImage = ImageIO.read(imageFile);
            Image1 = ImageIO.read(imageFile2);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
    }

    private void Tekst() {
        tf = new JTextField();
        tf.setBounds(10, 10, 230, 50);
        tf.setSize(10, 10);
        add(tf);
    }

    @Override
    protected void paintComponent(Graphics g) {

        //Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(tloImage, 0, 0, this);
        //g2d.drawImage(Image1, 0, 0, this);

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
*/