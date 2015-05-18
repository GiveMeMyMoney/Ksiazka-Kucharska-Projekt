package kuchnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import static com.sun.deploy.uitoolkit.impl.awt.Applet2ImageFactory.createImage;

public class GUI {

    public JFrame frame;
    public JTextField SearchField;
    Graphics gc;
    Image image;
    private static Image[] gwiazdkiSzare = new Image[5];    //TODO to na razie jest wstepne...
    private static Image[] gwiazdkiZolte = new Image[5];    //gwiazdki trzeba wgrac jako tablice by je pozniej zakodzic
    //np. najezdza kursorem na trzecia gwiazdke to pierwsze 3 zamieniaja sie na zolte itp...

    public GUI() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 960, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

//=======================  Panele  =============================================================

        final JPanel MenuGlowne = new JPanel();
        frame.getContentPane().add(MenuGlowne, "Menu Glowne");
        MenuGlowne.setLayout(null);
        MenuGlowne.setVisible(true);

/*
        for(int i=0; i<gwiazdkiSzare.length; i++) {
            gwiazdkiSzare[i] = new ImageIcon("raki.png").getImage();
            //gc.drawImage(gwiazdkiSzare[i], 26*i, 26*i, null);
        }
*/

/*
        for(int i=0; i<gwiazdkiZolte.length; i++) {
            gwiazdkiZolte[i] = new ImageIcon("res/tileset_air.png").getImage();
            gwiazdkiZolte[i] = createImage(new FilteredImageSource(gwiazdkiZolte[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
*/
        final JPanel Kategorie = new JPanel();
        frame.getContentPane().add(Kategorie, "Kategorie");
        Kategorie.setLayout(null);
        Kategorie.setVisible(false);

        final JPanel Wyszukiwanie = new JPanel();
        frame.getContentPane().add(Wyszukiwanie, "Wyszukiwanie");
        Wyszukiwanie.setLayout(null);
        Wyszukiwanie.setVisible(false);

        final JPanel Autorzy = new JPanel();
        frame.getContentPane().add(Autorzy, "Autorzy");
        Autorzy.setLayout(null);
        Autorzy.setVisible(false);

        final JPanel Zupy = new JPanel();
        frame.getContentPane().add(Zupy, "Zupy");
        Zupy.setLayout(null);
        Zupy.setVisible(false);

        final JPanel DaniaMiesne = new JPanel();
        frame.getContentPane().add(DaniaMiesne, "Dania Miesne");
        DaniaMiesne.setLayout(null);
        DaniaMiesne.setVisible(false);

        final JPanel CiastaIDesery = new JPanel();
        frame.getContentPane().add(CiastaIDesery, "Ciasta i desery");
        CiastaIDesery.setLayout(null);
        CiastaIDesery.setVisible(false);

        final JPanel Napoje = new JPanel();
        frame.getContentPane().add(Napoje, "Napoje");
        Napoje.setLayout(null);
        Napoje.setVisible(false);

        final JPanel SalatkiIPrzystawki = new JPanel();
        frame.getContentPane().add(SalatkiIPrzystawki, "Salatki i przystawki");
        SalatkiIPrzystawki.setLayout(null);
        SalatkiIPrzystawki.setVisible(false);

        final JPanel RybyIOwoceMorza = new JPanel();
        frame.getContentPane().add(RybyIOwoceMorza, "Ryby i owoce morza");
        RybyIOwoceMorza.setLayout(null);
        RybyIOwoceMorza.setVisible(false);

        final JPanel DodawaniePrzepisow = new JPanel();
        frame.getContentPane().add(DodawaniePrzepisow, "Dodawanie Przepisow");
        DodawaniePrzepisow.setLayout(null);

//======================= Elementy w panelu Menu Glowne  =========================================

        JButton btnPrzepisy = new JButton("Przepisy");
        btnPrzepisy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPrzepisy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MenuGlowne.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPrzepisy.setBounds(385, 134, 200, 50);
        MenuGlowne.add(btnPrzepisy);

        JButton btnWyszukiwarka = new JButton("Wyszukiwarka");
        btnWyszukiwarka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Wyszukiwanie.setVisible(true);
            }
        });
        btnWyszukiwarka.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyszukiwarka.setBounds(385, 245, 200, 50);
        MenuGlowne.add(btnWyszukiwarka);

        JButton btnAutorzy = new JButton("Autorzy");
        btnAutorzy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Autorzy.setVisible(true);
            }
        });
        btnAutorzy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnAutorzy.setBounds(385, 356, 200, 50);
        MenuGlowne.add(btnAutorzy);

        JButton btnWyjscie = new JButton("Wyjscie");
        btnWyjscie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnWyjscie.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyjscie.setBounds(385, 467, 200, 50);
        MenuGlowne.add(btnWyjscie);

//=======================  Elementy w panelu Kategorie  =============================================

        JButton btnZupy = new JButton("Zupy");
        btnZupy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                Zupy.setVisible(true);
            }
        });
        btnZupy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnZupy.setBounds(385, 82, 200, 50);
        Kategorie.add(btnZupy);

        JButton btnDanieMiesne = new JButton("Dania \r\nmi\u0119sne");
        btnDanieMiesne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                DaniaMiesne.setVisible(true);
            }
        });
        btnDanieMiesne.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDanieMiesne.setBounds(385, 158, 200, 50);
        Kategorie.add(btnDanieMiesne);

        JButton btnCiastaIDesery = new JButton("Ciasta i desery");
        btnCiastaIDesery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                CiastaIDesery.setVisible(true);
            }
        });
        btnCiastaIDesery.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnCiastaIDesery.setBounds(385, 234, 200, 50);
        Kategorie.add(btnCiastaIDesery);

        JButton btnNapoje = new JButton("Napoje");
        btnNapoje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                Napoje.setVisible(true);
            }
        });
        btnNapoje.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnNapoje.setBounds(385, 310, 200, 50);
        Kategorie.add(btnNapoje);

        JButton btnRybyIOwoce = new JButton("Ryby i owoce morza");
        btnRybyIOwoce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                RybyIOwoceMorza.setVisible(true);
            }
        });
        btnRybyIOwoce.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnRybyIOwoce.setBounds(385, 386, 200, 50);
        Kategorie.add(btnRybyIOwoce);

        JButton btnSalatkiIPrzystawki = new JButton("Sa\u0142atki i przystawki");
        btnSalatkiIPrzystawki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                SalatkiIPrzystawki.setVisible(true);
            }
        });
        btnSalatkiIPrzystawki.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSalatkiIPrzystawki.setBounds(385, 462, 200, 50);
        Kategorie.add(btnSalatkiIPrzystawki);

        JButton btnPowrotDoMenu = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu.setBounds(702, 563, 200, 50);
        Kategorie.add(btnPowrotDoMenu);

        JButton btnDodajPrzepis = new JButton("Dodaj przepis");
        btnDodajPrzepis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                DodawaniePrzepisow.setVisible(true);
            }
        });
        btnDodajPrzepis.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDodajPrzepis.setBounds(50, 563, 200, 50);
        Kategorie.add(btnDodajPrzepis);

//=======================  Elementy w panelu Wyszukiwanie  ===========================================

        JButton btnPowrotDoMenu2 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Wyszukiwanie.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu2.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu2.setBounds(702, 563, 200, 50);
        Wyszukiwanie.add(btnPowrotDoMenu2);

        SearchField = new JTextField();
        SearchField.setBounds(322, 339, 300, 40);
        Wyszukiwanie.add(SearchField);
        SearchField.setColumns(10);

        ImageIcon szukajImage = new ImageIcon("Lupamala.png");  //TODO wstawiæ lupe od Jacka.
        JButton btnSzukaj = new JButton("Szukaj", szukajImage); //moze byc tez bez napisu
        btnSzukaj.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSzukaj.setBounds(428, 400, 175, 102);  //poprzednie ustawienia: btnSzukaj.setBounds(428, 400, 98, 39);
        Wyszukiwanie.add(btnSzukaj);

//=======================  Elementy w panelu Autorzy  ================================================

        JButton btnPowrotDoMenu3 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Autorzy.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu3.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu3.setBounds(702, 563, 200, 50);
        Autorzy.add(btnPowrotDoMenu3);
        Autorzy.setVisible(false);

//=======================  Elementy w panelu Zupy  ====================================================

        JButton btnPowrotDoMenu4 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu4.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu4.setBounds(702, 563, 200, 50);
        Zupy.add(btnPowrotDoMenu4);

        JButton btnPowrotDoKategorii = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Zupy.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii.setBounds(50, 563, 200, 50);
        Zupy.add(btnPowrotDoKategorii);

//=======================  Elementy w panelu Dania Miesne ==============================================

        JButton btnPowortDoMenu5 = new JButton("Powr\u00F3t do menu");
        btnPowortDoMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaniaMiesne.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowortDoMenu5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowortDoMenu5.setBounds(702, 563, 200, 50);
        DaniaMiesne.add(btnPowortDoMenu5);

        JButton btnPowrotDoKategorii2 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaniaMiesne.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii2.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii2.setBounds(50, 563, 200, 50);
        DaniaMiesne.add(btnPowrotDoKategorii2);

//=======================  Eleemnty w panelu Ciasta i desery  =============================================

        JButton btnPowrotDoMenu5 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CiastaIDesery.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu5.setBounds(702, 563, 200, 50);
        CiastaIDesery.add(btnPowrotDoMenu5);

        JButton btnPowrotDoKategorii3 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CiastaIDesery.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii3.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii3.setBounds(50, 563, 200, 50);
        CiastaIDesery.add(btnPowrotDoKategorii3);

//=======================  Elementy w panelu Napoje  =======================================================

        JButton btnPowrotDoMenu6 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Napoje.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu6.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu6.setBounds(702, 563, 200, 50);
        Napoje.add(btnPowrotDoMenu6);

        JButton btnPowrotDoKategorii4 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Napoje.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii4.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii4.setBounds(50, 563, 200, 50);
        Napoje.add(btnPowrotDoKategorii4);

//=======================  Elementy w panelu Ryby i owoce morza  =============================================

        JButton btnPowrotDoMenu7 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RybyIOwoceMorza.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu7.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu7.setBounds(702, 563, 200, 50);
        RybyIOwoceMorza.add(btnPowrotDoMenu7);

        JButton btnPowrotDoKategorii5 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RybyIOwoceMorza.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii5.setBounds(50, 563, 200, 50);
        RybyIOwoceMorza.add(btnPowrotDoKategorii5);

//======================= Elementy w panelu Salatki i przystawki  ==============================================

        JButton btnPowrotDoMenu8 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalatkiIPrzystawki.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu8.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu8.setBounds(702, 563, 200, 50);
        SalatkiIPrzystawki.add(btnPowrotDoMenu8);

        JButton btnPowrotDoKategorii6 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalatkiIPrzystawki.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii6.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii6.setBounds(50, 563, 200, 50);
        SalatkiIPrzystawki.add(btnPowrotDoKategorii6);

//=======================  Elementy w panelu Dodawanie przepisow  ===============================================

        JButton btnPowrotDoMenu9 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DodawaniePrzepisow.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu9.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu9.setBounds(702, 563, 200, 50);
        DodawaniePrzepisow.add(btnPowrotDoMenu9);

        JButton btnPowrotDoKategorii7 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DodawaniePrzepisow.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii7.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii7.setBounds(50, 563, 200, 50);
        DodawaniePrzepisow.add(btnPowrotDoKategorii7);
        DodawaniePrzepisow.setVisible(false);


    }
}
