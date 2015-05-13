package kuchnia;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener {
    private static String title = "Kuchenne Rewolucje";
    private JPanel rootPanel;
    private JButton spisTresciButton;
    BufferedImage tloImage;
    //BufferedImage Image1;


    public GUI() {          //constr.
        setContentPane(rootPanel);
        setTitle(title);    //tytul
        pack();
        setResizable(false);	//zmiana rozmiaru okienka-ustawiona na true.
        setLocationRelativeTo(null);	//null- okienko wyskakuje na srodku ekranu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Przyciski:
        spisTresciButton.addActionListener(this);

        setVisible(true);	//wyswietlanie
    }

/*  //TODO blad wczytywania obrazka.
    private void Images() { //wyswietlanie obrazkow
        File imageFile1 = new File("tlo.jpg");
        //File imageFile2 = new File("jav.jpg");
        try {
            tloImage = ImageIO.read(imageFile1);
            //Image1 = ImageIO.read(imageFile2);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
    }
*/

    protected void paintComponent(Graphics g) { //metoda JPanel która s³u¿y do wyœwietlania grafiki
        Graphics2D g2d = (Graphics2D) g;        //tutaj trzeba jakoœ odpaliæ obraz
        g2d.drawImage(tloImage, 0, 0, this);
        //g2d.drawImage(Image1, 0, 0, this);

    }

    public void actionPerformed(ActionEvent e) {    //co robi konkretny klawisz
        Object source = e.getSource();
        if(source==spisTresciButton) {
            JOptionPane.showConfirmDialog(GUI.this, "Sprawdzam klawisz");
        }
    }
}
