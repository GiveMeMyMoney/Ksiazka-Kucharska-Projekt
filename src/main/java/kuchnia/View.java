package kuchnia;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import baza_danych.*;


public class View {
    final static int iloscKategorii=6;
    final static int odlegloscYbtn=60;
    //private int[] kategoria = new int[iloscKategorii];
    //+TODO zmienne
    public JFrame frame;
    public JTextField SearchField;
    private int width=1075, height=700;
    private int widthKlawisz=200;
    private int srodkujKlawisz=(width-widthKlawisz)/2;
    private JTextField textFieldNazwaPrzepisu, textFieldCzasPrzygotowania, textFieldLiczbaOsob;
    private JPanel Kategorie, MenuGlowne, Przepis, DodawaniePrzepisow, Zupy, DaniaMiesne, CiastaIDesery, Napoje, SalatkiIPrzystawki, RybyIOwoceMorza;;
    private JLabel lblNic;
    private Icon gwSzaraIcon;
    private Icon gwZoltaIcon;
    private JLabel labelGwiazdki;
    private JLabel gwiazdka1, gwiazdka2, gwiazdka3, gwiazdka4, gwiazdka5;
    //private JButton btnPrzepisowy, btnPrzepisowy2;
    private JButton btnDodajPrzepis, btnDodajZdjecie;   //batony "dodaj przepis"
    private JComboBox comboBoxKategorieDan, comboBoxPoziomTrudnosci;
    private JTextArea textAreaSkladniki, textAreaOpisPrzygotowania;
    private JDesktopPane desktopPaneZdjecieDania;
    private ArrayList<JButton> btnPrzepisowyZupy = new ArrayList<JButton>();
    private ArrayList<JButton> btnPrzepisowyDaniaMiesne = new ArrayList<JButton>();
    private ArrayList<JButton> btnPrzepisowyCiastaIDesery = new ArrayList<JButton>();
    private ArrayList<JButton> btnPrzepisowyNapoje = new ArrayList<JButton>();
    private ArrayList<JButton> btnPrzepisowySalatkiIPrzystawki = new ArrayList<JButton>();
    private ArrayList<JButton> btnPrzepisowyRybyIOwoceMorza = new ArrayList<JButton>();
    private JButton btnZupy, btnDanieMiesne, btnCiastaIDesery, btnNapoje, btnRybyIOwoce, btnSalatkiIPrzystawki;


    Icon tloGlowneImage = new ImageIcon("tlo.png");
    Icon tloImage = new ImageIcon("tlo2.png");

    private double rate=0.0;
    private StringBuffer typ = new StringBuffer();
    private int pozycja=0;


    public View() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, width, height);
        frame.setResizable(false);	//zmiana rozmiaru okienka-ustawiona na false.
        frame.setLocationRelativeTo(null);    //null- okienko wyskakuje na srodku ekranu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

//=======================  Panele  ============================================================//

        MenuGlowne = new JPanel();
        frame.getContentPane().add(MenuGlowne, "Menu Glowne");
        MenuGlowne.setLayout(null);
        MenuGlowne.setVisible(true);

        Kategorie = new JPanel();
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

        Zupy = new JPanel();
        frame.getContentPane().add(Zupy, "Zupy");
        Zupy.setLayout(null);
        Zupy.setVisible(false);

        DaniaMiesne = new JPanel();
        frame.getContentPane().add(DaniaMiesne, "Dania Miesne");
        DaniaMiesne.setLayout(null);
        DaniaMiesne.setVisible(false);

        CiastaIDesery = new JPanel();
        frame.getContentPane().add(CiastaIDesery, "Ciasta i desery");
        CiastaIDesery.setLayout(null);
        CiastaIDesery.setVisible(false);

        Napoje = new JPanel();
        frame.getContentPane().add(Napoje, "Napoje");
        Napoje.setLayout(null);
        Napoje.setVisible(false);

        SalatkiIPrzystawki = new JPanel();
        frame.getContentPane().add(SalatkiIPrzystawki, "Salatki i przystawki");
        SalatkiIPrzystawki.setLayout(null);
        SalatkiIPrzystawki.setVisible(false);

        RybyIOwoceMorza = new JPanel();
        frame.getContentPane().add(RybyIOwoceMorza, "Ryby i owoce morza");
        RybyIOwoceMorza.setLayout(null);
        RybyIOwoceMorza.setVisible(false);

        DodawaniePrzepisow = new JPanel();
        frame.getContentPane().add(DodawaniePrzepisow, "Dodawanie Przepisow");
        DodawaniePrzepisow.setLayout(null);

        /*
        Przepis = new JPanel();
        frame.getContentPane().add(Przepis, "Przepis");
        Przepis.setLayout(null);
        Przepis.setVisible(false);
        */

//======================= Elementy w panelu Menu Glowne  =========================================

        JButton btnGUIisy = new JButton("Przepisy");
        btnGUIisy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnGUIisy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MenuGlowne.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnGUIisy.setBounds(751, 156, widthKlawisz, 50);;
        MenuGlowne.add(btnGUIisy);

        JButton btnWyszukiwarka = new JButton("Wyszukiwarka");
        btnWyszukiwarka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Wyszukiwanie.setVisible(true);
            }
        });
        btnWyszukiwarka.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyszukiwarka.setBounds(751, 267, widthKlawisz, 50);
        MenuGlowne.add(btnWyszukiwarka);

        JButton btnAutorzy = new JButton("Autorzy");
        btnAutorzy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Autorzy.setVisible(true);
            }
        });
        btnAutorzy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnAutorzy.setBounds(751, 380, widthKlawisz, 50);
        MenuGlowne.add(btnAutorzy);

        JButton btnWyjscie = new JButton("Wyjscie");
        btnWyjscie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnWyjscie.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyjscie.setBounds(751, 495, widthKlawisz, 50);
        MenuGlowne.add(btnWyjscie);


        JLabel lblTlo1 = new JLabel("");
        //Image tloImage = new ImageIcon(this.getClass().getResource("/tlo.png")).getImage();
        lblTlo1.setIcon(tloGlowneImage);
        lblTlo1.setBounds(0, 0, 1069, 672);
        MenuGlowne.add(lblTlo1);

        /*
        JLabel loggo = new JLabel("");
        Icon logoIcon = new ImageIcon("Logo.png");
        loggo.setIcon(logoIcon);
        loggo.setBounds(59, 156, 619, 369);
        MenuGlowne.add(loggo);
        */

//=======================  Elementy w panelu Kategorie  =============================================
///TODO kategorie

        Buttonclass btnHandler = new Buttonclass();

        btnZupy = new JButton("Zupy");
        btnZupy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnZupy.setBounds(437, 63, widthKlawisz, 50);
        Kategorie.add(btnZupy);

        btnDanieMiesne = new JButton("Dania \r\nmi\u0119sne");
        btnDanieMiesne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typ.append("DANIA_MIESNE");
                Kategorie.setVisible(false);
                DaniaMiesne.setVisible(true);
            }
        });
        btnDanieMiesne.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDanieMiesne.setBounds(437, 148, widthKlawisz, 50);
        Kategorie.add(btnDanieMiesne);

        btnCiastaIDesery = new JButton("Ciasta i desery");
        btnCiastaIDesery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typ.append("CIASTA_DESERY");
                Kategorie.setVisible(false);
                CiastaIDesery.setVisible(true);
            }
        });
        btnCiastaIDesery.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnCiastaIDesery.setBounds(437, 225, widthKlawisz, 50);
        Kategorie.add(btnCiastaIDesery);

        btnNapoje = new JButton("Napoje");
        btnNapoje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typ.append("NAPOJE");
                Kategorie.setVisible(false);
                Napoje.setVisible(true);
            }
        });
        btnNapoje.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnNapoje.setBounds(437, 300, widthKlawisz, 50);
        Kategorie.add(btnNapoje);

        btnRybyIOwoce = new JButton("Ryby i owoce morza");
        btnRybyIOwoce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typ.append("RYBY_OWOCE_MORZA");
                Kategorie.setVisible(false);
                RybyIOwoceMorza.setVisible(true);
            }
        });
        btnRybyIOwoce.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnRybyIOwoce.setBounds(437, 378, widthKlawisz, 50);
        Kategorie.add(btnRybyIOwoce);

        btnSalatkiIPrzystawki = new JButton("Sa\u0142atki i przystawki");
        btnSalatkiIPrzystawki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //typ="SALATKA_PRZYSTAWKI";
                Kategorie.setVisible(false);
                SalatkiIPrzystawki.setVisible(true);
            }
        });
        btnSalatkiIPrzystawki.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSalatkiIPrzystawki.setBounds(srodkujKlawisz, 462, widthKlawisz, 50);
        Kategorie.add(btnSalatkiIPrzystawki);

        btnZupy.addActionListener(btnHandler);  //--------------------------------------------------------
        //button2.addActionListener(this);

        JButton btnPowrotDoMenu = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu.setBounds(859, 611, widthKlawisz, 50);
        Kategorie.add(btnPowrotDoMenu);

        JButton btnDodajPrzepis2 = new JButton("Dodaj Przepis");
        btnDodajPrzepis2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                DodawaniePrzepisow.setVisible(true);
            }
        });
        btnDodajPrzepis2.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDodajPrzepis2.setBounds(10, 611, widthKlawisz, 50);
        Kategorie.add(btnDodajPrzepis2);

        JLabel lblTlo2 = new JLabel("");
        lblTlo2.setIcon(tloImage);
        lblTlo2.setBounds(0, 0, 1069, 672);
        Kategorie.add(lblTlo2);


//=======================  Elementy w panelu Wyszukiwanie  ===========================================

        JButton btnPowrotDoMenu2 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Wyszukiwanie.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu2.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu2.setBounds(859, 611, widthKlawisz, 50);
        Wyszukiwanie.add(btnPowrotDoMenu2);

        SearchField = new JTextField();
        SearchField.setBounds(322, 339, 300, 40);
        Wyszukiwanie.add(SearchField);
        SearchField.setColumns(10);

        Icon szukajImage = new ImageIcon("Lupamala.png");
        JButton btnSzukaj = new JButton("Szukaj", szukajImage); //moze byc tez bez napisu
        btnSzukaj.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSzukaj.setBounds(428, 400, 98, 39);
        Wyszukiwanie.add(btnSzukaj);

        JLabel lblTlo3 = new JLabel("");
        lblTlo3.setIcon(tloImage);
        lblTlo3.setBounds(0, 0, 1069, 672);
        Wyszukiwanie.add(lblTlo3);

//=======================  Elementy w panelu Autorzy  ================================================


        JButton btnPowrotDoMenu3 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Autorzy.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });

        Icon marcinIcon = new ImageIcon("Marcin.png");
        Icon wojtekIcon = new ImageIcon("Marcin.png");
        Icon jacekIcon = new ImageIcon("Marcin.png");
        Icon pawelIcon = new ImageIcon("Marcin.png");
        Icon arturIcon = new ImageIcon("Marcin.png");

        btnPowrotDoMenu3.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu3.setBounds(859, 611, widthKlawisz, 50);
        Autorzy.add(btnPowrotDoMenu3);
        Autorzy.setVisible(false);

        JLabel lblWojciechZachwieja = new JLabel("");
        lblWojciechZachwieja.setBounds(142, 53, 171, 217);
        Autorzy.add(lblWojciechZachwieja);
        lblWojciechZachwieja.setIcon(wojtekIcon);

        JLabel lblMarcinStyczen = new JLabel("");
        lblMarcinStyczen.setBounds(751, 53, 171, 217);
        Autorzy.add(lblMarcinStyczen);
        lblMarcinStyczen.setIcon(marcinIcon);

        JLabel lblArturUrbanowicz = new JLabel("");
        lblArturUrbanowicz.setBounds(456, 53, 171, 217);
        Autorzy.add(lblArturUrbanowicz);
        lblArturUrbanowicz.setIcon(arturIcon);

        JLabel lblJacekZawodny = new JLabel("");
        lblJacekZawodny.setBounds(300, 323, 171, 217);
        Autorzy.add(lblJacekZawodny);
        lblJacekZawodny.setIcon(jacekIcon);

        JLabel lblPawelWilczek = new JLabel("");
        lblPawelWilczek.setBounds(600, 323, 171, 217);
        Autorzy.add(lblPawelWilczek);
        lblPawelWilczek.setIcon(pawelIcon);

        JLabel lblJacekZawodny_1 = new JLabel("Jacek 'Niko\u015B' Zawodny");
        lblJacekZawodny_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
        lblJacekZawodny_1.setVerticalAlignment(SwingConstants.TOP);
        lblJacekZawodny_1.setBounds(280, 551, 215, 29);
        Autorzy.add(lblJacekZawodny_1);

        JLabel lblWojciechZachwieja_1 = new JLabel("Wojciech 'Pseudonim' Zachwieja");
        lblWojciechZachwieja_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
        lblWojciechZachwieja_1.setVerticalAlignment(SwingConstants.TOP);
        lblWojciechZachwieja_1.setBounds(106, 272, 278, 31);
        Autorzy.add(lblWojciechZachwieja_1);

        JLabel lblArturUrbanowicz_1 = new JLabel("Artur 'asapa' Urbanowicz");
        lblArturUrbanowicz_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
        lblArturUrbanowicz_1.setVerticalAlignment(SwingConstants.TOP);
        lblArturUrbanowicz_1.setBounds(420, 272, 267, 29);
        Autorzy.add(lblArturUrbanowicz_1);

        JLabel lblMarcinStycze = new JLabel("Marcin 'Luter' Stycze\u0144");
        lblMarcinStycze.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
        lblMarcinStycze.setVerticalAlignment(SwingConstants.TOP);
        lblMarcinStycze.setBounds(736, 272, 256, 29);
        Autorzy.add(lblMarcinStycze);

        JLabel lblPaweWilczek = new JLabel("Pawe\u0142 'Magik' Wilczek");
        lblPaweWilczek.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
        lblPaweWilczek.setVerticalAlignment(SwingConstants.TOP);
        lblPaweWilczek.setBounds(582, 551, 306, 29);
        Autorzy.add(lblPaweWilczek);

        JLabel lblTlo4 = new JLabel("");
        lblTlo4.setIcon(tloImage);
        lblTlo4.setBounds(0, 0, 1069, 661);
        Autorzy.add(lblTlo4);

//=======================  Elementy w panelu Zupy  ====================================================
//TODO zupy
        JButton btnPowrotDoMenu4 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu4.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu4.setBounds(859, 611, widthKlawisz, 50);
        Zupy.add(btnPowrotDoMenu4);

        JButton btnPowrotDoKategorii = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Zupy.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii.setBounds(10, 611, widthKlawisz, 50);
        Zupy.add(btnPowrotDoKategorii);

        /*
        btnPrzepisowy = new JButton("Pomidorowa o smaku koksu");
        btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
        btnPrzepisowy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
        btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
        btnPrzepisowy.setBounds(199, 61, 356, 40);
        Zupy.add(btnPrzepisowy);

        btnPrzepisowy2 = new JButton("Zurek");
        btnPrzepisowy2.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
        btnPrzepisowy2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisowy2.setBackground(new Color(255, 255, 255, 0));
        btnPrzepisowy2.setBorderPainted(false);
        btnPrzepisowy2.setBounds(199, 112, 356, 40);
        Zupy.add(btnPrzepisowy2);

        JButton btnPrzepisowy3 = new JButton("Mleczna");
        btnPrzepisowy3.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
        btnPrzepisowy3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisowy3.setBorderPainted(false);
        btnPrzepisowy3.setBackground(new Color(255, 255, 255, 0));
        btnPrzepisowy3.setBounds(199, 163, 356, 40);
        Zupy.add(btnPrzepisowy3);

        JButton btnPrzepisowy4 = new JButton("Mozgowatowatowa");
        btnPrzepisowy4.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
        btnPrzepisowy4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisowy4.setBorderPainted(false);
        btnPrzepisowy4.setBackground(new Color(255, 255, 255, 0));
        btnPrzepisowy4.setBounds(199, 214, 356, 40);
        Zupy.add(btnPrzepisowy4);

        JButton btnPrzepisowy5 = new JButton("BarSZCZY");
        btnPrzepisowy5.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
        btnPrzepisowy5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Zupy.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisowy5.setBorderPainted(false);
        btnPrzepisowy5.setBackground(new Color(255, 255, 255, 0));
        btnPrzepisowy5.setBounds(199, 265, 356, 40);
        Zupy.add(btnPrzepisowy5);
        */

        JLabel lblTlo5 = new JLabel("");
        lblTlo5.setIcon(tloImage);
        lblTlo5.setBounds(0, 0, 1069, 672);
        Zupy.add(lblTlo5);

//=======================  Elementy w panelu Dania Miesne ==============================================

        JButton btnPowortDoMenu5 = new JButton("Powr\u00F3t do menu");
        btnPowortDoMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaniaMiesne.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowortDoMenu5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowortDoMenu5.setBounds(859, 611, widthKlawisz, 50);
        DaniaMiesne.add(btnPowortDoMenu5);

        JButton btnPowrotDoKategorii2 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaniaMiesne.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii2.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii2.setBounds(10, 611, widthKlawisz, 50);
        DaniaMiesne.add(btnPowrotDoKategorii2);

        JLabel lblTlo6 = new JLabel("");
        lblTlo6.setIcon(tloImage);
        lblTlo6.setBounds(0, 0, 1069, 672);
        DaniaMiesne.add(lblTlo6);

//=======================  Eleemnty w panelu Ciasta i desery  =============================================

        JButton btnPowrotDoMenu5 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CiastaIDesery.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu5.setBounds(859, 611, widthKlawisz, 50);
        CiastaIDesery.add(btnPowrotDoMenu5);

        JButton btnPowrotDoKategorii3 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CiastaIDesery.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii3.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii3.setBounds(10, 611, widthKlawisz, 50);
        CiastaIDesery.add(btnPowrotDoKategorii3);

        JLabel lblTlo7 = new JLabel("");
        lblTlo7.setIcon(tloImage);
        lblTlo7.setBounds(0, 0, 1069, 672);
        CiastaIDesery.add(lblTlo7);

//=======================  Elementy w panelu Napoje  =======================================================

        JButton btnPowrotDoMenu6 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Napoje.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu6.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu6.setBounds(859, 611, widthKlawisz, 50);
        Napoje.add(btnPowrotDoMenu6);

        JButton btnPowrotDoKategorii4 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Napoje.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii4.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii4.setBounds(10, 611, widthKlawisz, 50);
        Napoje.add(btnPowrotDoKategorii4);

        JLabel lblTlo8 = new JLabel("");
        lblTlo8.setIcon(tloImage);
        lblTlo8.setBounds(0, 0, 1069, 672);
        Napoje.add(lblTlo8);

//=======================  Elementy w panelu Ryby i owoce morza  =============================================

        JButton btnPowrotDoMenu7 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RybyIOwoceMorza.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu7.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu7.setBounds(859, 611, widthKlawisz, 50);
        RybyIOwoceMorza.add(btnPowrotDoMenu7);

        JButton btnPowrotDoKategorii5 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RybyIOwoceMorza.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii5.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii5.setBounds(10, 611, widthKlawisz, 50);
        RybyIOwoceMorza.add(btnPowrotDoKategorii5);

        JLabel lblTlo10 = new JLabel("");
        lblTlo10.setIcon(tloImage);
        lblTlo10.setBounds(0, 0, 1069, 672);
        RybyIOwoceMorza.add(lblTlo10);

//======================= Elementy w panelu Salatki i przystawki  ==============================================

        JButton btnPowrotDoMenu8 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalatkiIPrzystawki.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu8.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu8.setBounds(859, 611, widthKlawisz, 50);
        SalatkiIPrzystawki.add(btnPowrotDoMenu8);

        JButton btnPowrotDoKategorii6 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SalatkiIPrzystawki.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii6.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii6.setBounds(10, 611, widthKlawisz, 50);
        SalatkiIPrzystawki.add(btnPowrotDoKategorii6);

        JLabel lblTlo9 = new JLabel("");
        lblTlo9.setIcon(tloImage);
        lblTlo9.setBounds(0, 0, 1069, 672);
        SalatkiIPrzystawki.add(lblTlo9);

//=======================  Elementy w panelu Dodawanie Przepisow  ===============================================
//TODO dodawanie przepisu
        JButton btnPowrotDoMenu9 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DodawaniePrzepisow.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotDoMenu9.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu9.setBounds(859, 611, widthKlawisz, 50);
        DodawaniePrzepisow.add(btnPowrotDoMenu9);

        JButton btnPowrotDoKategorii7 = new JButton("Powr\u00F3t do kategorii");
        btnPowrotDoKategorii7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DodawaniePrzepisow.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnPowrotDoKategorii7.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoKategorii7.setBounds(10, 611, widthKlawisz, 50);
        DodawaniePrzepisow.add(btnPowrotDoKategorii7);

        JLabel lblDodawaniePrzepisu = new JLabel("Dodawanie przepisu");
        lblDodawaniePrzepisu.setFont(new Font("Tahoma", Font.PLAIN, 39));
        lblDodawaniePrzepisu.setBounds(315, -3, 359, 90);
        DodawaniePrzepisow.add(lblDodawaniePrzepisu);

        textFieldNazwaPrzepisu = new JTextField();
        textFieldNazwaPrzepisu.setBounds(10, 98, 317, 28);
        DodawaniePrzepisow.add(textFieldNazwaPrzepisu);
        textFieldNazwaPrzepisu.setColumns(10);

        JLabel lblNazwaPrzepisu = new JLabel("Nazwa przepisu:");
        lblNazwaPrzepisu.setBounds(10, 68, 141, 37);
        DodawaniePrzepisow.add(lblNazwaPrzepisu);

        JLabel lblKategoria = new JLabel("Kategoria:");
        lblKategoria.setBounds(10, 140, 123, 37);
        DodawaniePrzepisow.add(lblKategoria);

        ///TODO comboKATEGORIE
        comboBoxKategorieDan = new JComboBox();
        comboBoxKategorieDan.addItem("ZUPY");
        comboBoxKategorieDan.addItem("DANIA_MIESNE");
        comboBoxKategorieDan.addItem("CIASTA_DESERY");
        comboBoxKategorieDan.addItem("NAPOJE");
        comboBoxKategorieDan.addItem("SALATKA_PRZYSTAWKI");
        comboBoxKategorieDan.addItem("RYBY_OWOCE_MORZA");
        comboBoxKategorieDan.setBounds(10, 172, 263, 28);
        DodawaniePrzepisow.add(comboBoxKategorieDan);

        textAreaSkladniki = new JTextArea();
        textAreaSkladniki.setBounds(10, 257, 317, 325);
        DodawaniePrzepisow.add(textAreaSkladniki);

        JLabel lblSkladniki = new JLabel("Sk\u0142adniki:");
        lblSkladniki.setBounds(10, 221, 98, 37);
        DodawaniePrzepisow.add(lblSkladniki);

        desktopPaneZdjecieDania = new JDesktopPane();
        desktopPaneZdjecieDania.setBounds(793, 68, 250, 250);
        DodawaniePrzepisow.add(desktopPaneZdjecieDania);

        JLabel lblZdjecieDania = new JLabel("");
        lblZdjecieDania.setBounds(10, 11, 230, 228);
        desktopPaneZdjecieDania.add(lblZdjecieDania);

        textAreaOpisPrzygotowania = new JTextArea();
        textAreaOpisPrzygotowania.setBounds(362, 377, 681, 205);
        DodawaniePrzepisow.add(textAreaOpisPrzygotowania);

        JLabel lblOpisPrzygotowania = new JLabel("Opis przygotowania:");
        lblOpisPrzygotowania.setBounds(362, 338, 179, 28);
        DodawaniePrzepisow.add(lblOpisPrzygotowania);

        ///TODO btnDODAJzdjecie
        btnDodajZdjecie = new JButton("Dodaj zdj\u0119cie");
        btnDodajZdjecie.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDodajZdjecie.setBounds(847, 329, 151, 41);
        DodawaniePrzepisow.add(btnDodajZdjecie);

        textFieldCzasPrzygotowania = new JTextField();
        textFieldCzasPrzygotowania.setBounds(400, 97, 98, 29);
        DodawaniePrzepisow.add(textFieldCzasPrzygotowania);
        textFieldCzasPrzygotowania.setColumns(10);

        JLabel lblCzasPrzygotowania = new JLabel("Czas przygotowania:");
        lblCzasPrzygotowania.setBounds(400, 68, 141, 37);
        DodawaniePrzepisow.add(lblCzasPrzygotowania);

        JLabel lblPoziomTrudnosci = new JLabel("Poziom trudno\u015Bci:");
        lblPoziomTrudnosci.setBounds(608, 68, 129, 37);
        DodawaniePrzepisow.add(lblPoziomTrudnosci);

        comboBoxPoziomTrudnosci = new JComboBox();
        comboBoxPoziomTrudnosci.addItem("latwe");
        comboBoxPoziomTrudnosci.addItem("srednie");
        comboBoxPoziomTrudnosci.addItem("trudne");
        comboBoxPoziomTrudnosci.setBounds(608, 100, 101, 25);
        DodawaniePrzepisow.add(comboBoxPoziomTrudnosci);

        JLabel lblLiczbaOsob = new JLabel("Liczba os\u00F3b:");
        lblLiczbaOsob.setBounds(400, 168, 116, 37);
        DodawaniePrzepisow.add(lblLiczbaOsob);

        textFieldLiczbaOsob = new JTextField();
        textFieldLiczbaOsob.setBounds(400, 194, 64, 28);
        DodawaniePrzepisow.add(textFieldLiczbaOsob);
        textFieldLiczbaOsob.setColumns(10);

        btnDodajPrzepis = new JButton("Dodaj przepis");
        btnDodajPrzepis.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDodajPrzepis.setEnabled(true);
        btnDodajPrzepis.setBounds(434, 611, 200, 50);
        DodawaniePrzepisow.add(btnDodajPrzepis);
        DodawaniePrzepisow.setVisible(false);

        JLabel lblTlo11 = new JLabel("");
        lblTlo11.setIcon(tloImage);
        lblTlo11.setBounds(0, 0, 1069, 675);
        DodawaniePrzepisow.add(lblTlo11);
        DodawaniePrzepisow.setVisible(false);


//=======================  Elementy w panelu PRZEPIS  ===============================================
///TODO przepis-----------------

        //Przepis.addMouseListener(handler);
        //Przepis.addMouseMotionListener(handler);



    }

    //TODO getobjectSQL()
    void dodajPrzepisListener(ActionListener listenForBtnDodaj) {
        btnDodajPrzepis.addActionListener(listenForBtnDodaj);
    }


    void odczytajPrzepisListener(ActionListener listenForBtnOdczyt) {
        //cos jest chyba to zle.
        System.out.println("JESTEM W ListenerVIEW2 ");
        for(int i=0; i<btnPrzepisowyZupy.size(); i++) {
            pozycja=i;
            btnPrzepisowyZupy.get(i).addActionListener(listenForBtnOdczyt);
        }
        for(int i=0; i<btnPrzepisowyDaniaMiesne.size(); i++) {
            pozycja=i;
            btnPrzepisowyDaniaMiesne.get(i).addActionListener(listenForBtnOdczyt);
        }
        for(int i=0; i<btnPrzepisowyCiastaIDesery.size(); i++) {
            pozycja=i;
            btnPrzepisowyCiastaIDesery.get(i).addActionListener(listenForBtnOdczyt);
        }
        for(int i=0; i<btnPrzepisowyNapoje.size(); i++) {
            btnPrzepisowyNapoje.get(i).addActionListener(listenForBtnOdczyt);
            pozycja=i;
        }
        for(int i=0; i<btnPrzepisowySalatkiIPrzystawki.size(); i++) {
            pozycja=i;
            btnPrzepisowySalatkiIPrzystawki.get(i).addActionListener(listenForBtnOdczyt);
        }
        for(int i=0; i<btnPrzepisowyRybyIOwoceMorza.size(); i++) {
            pozycja=i;
            btnPrzepisowyRybyIOwoceMorza.get(i).addActionListener(listenForBtnOdczyt);
        }
        System.out.println("WYCHODZE Z ListenerVIEW2 ");
    }

    void wczytajPrzepisyListener(ActionListener listenForBtnKategoria) {
        btnZupy.addActionListener(listenForBtnKategoria);
        btnCiastaIDesery.addActionListener(listenForBtnKategoria);
        btnDanieMiesne.addActionListener(listenForBtnKategoria);
        btnNapoje.addActionListener(listenForBtnKategoria);
        btnSalatkiIPrzystawki.addActionListener(listenForBtnKategoria);
        btnRybyIOwoce.addActionListener(listenForBtnKategoria);
    }


    /* ------------------LISTENER III ------------------*/
    public String getType() {
        //String cosik = typ.toString();

        return "ZUPY"; //typ.toString();
    }

    public void setPrzepisy(IteratorDishes iter) {
        String nazwa;
        int[] setYbtn = new int[iloscKategorii];
        for (int i=0; i<iloscKategorii; i++) setYbtn[i] = 35;

            int poz=0;
            if (iter.get().toString().toUpperCase().equals("ZUPY")) {
                //Zupy.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Zupy.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(22, 255, 255/*, 0*/));    //przezroczyste
                    //btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    Zupy.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowyZupy.add(btnPrzepisowy);   //nie wiem czy to potrzebne ale na wszelki wypadek jest.
                iter.next();
                }

                nazwa = iter.get().getTitle();
                JButton btnPrzepisowy = new JButton(nazwa);
                btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                btnPrzepisowy.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        Zupy.setVisible(false);
                        Przepis.setVisible(true);
                    }
                });
                btnPrzepisowy.setBackground(new Color(22, 255, 255/*, 0*/));    //przezroczyste
                //btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                Zupy.add(btnPrzepisowy);
                setYbtn[poz] += odlegloscYbtn;  //25
                btnPrzepisowyZupy.add(btnPrzepisowy);   //nie wiem czy to potrzebne ale na wszelki wypadek jest.
            }
            else if(iter.get().toString().toUpperCase().equals("DANIA_MIESNE")) {
                poz++;
                //DaniaMiesne.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            DaniaMiesne.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
                    btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    DaniaMiesne.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowyDaniaMiesne.add(btnPrzepisowy);
                    iter.next();
                }
            }
            else if(iter.get().toString().toUpperCase().equals("CIASTA_DESERY")) {
                poz++;
                //CiastaIDesery.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            CiastaIDesery.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
                    btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    CiastaIDesery.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowyCiastaIDesery.add(btnPrzepisowy);
                    iter.next();
                }
            }
            else if(iter.get().toString().toUpperCase().equals("NAPOJE")) {
                poz++;
                //Napoje.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            Napoje.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
                    btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    Napoje.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowyNapoje.add(btnPrzepisowy);
                    iter.next();
                }
            }
            else if(iter.get().toString().toUpperCase().equals("SALATKA_PRZYSTAWKI")) {
                poz++;
                //SalatkiIPrzystawki.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            SalatkiIPrzystawki.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
                    btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    SalatkiIPrzystawki.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowySalatkiIPrzystawki.add(btnPrzepisowy);
                    iter.next();
                }
            }
            else if(iter.get().toString().toUpperCase().equals("RYBY_OWOCE_MORZA")) {
                poz++;
                //SalatkiIPrzystawki.setVisible(true);
                while(iter.hasNext()) {
                    nazwa = iter.get().getTitle();
                    JButton btnPrzepisowy = new JButton(nazwa);
                    btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
                    btnPrzepisowy.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            RybyIOwoceMorza.setVisible(false);
                            Przepis.setVisible(true);
                        }
                    });
                    btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
                    btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
                    btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
                    RybyIOwoceMorza.add(btnPrzepisowy);
                    setYbtn[poz] += odlegloscYbtn;  //25
                    btnPrzepisowyRybyIOwoceMorza.add(btnPrzepisowy);
                    iter.next();
                }
            }

    }

    /* ------------------LISTENER II ------------------*/
    public int getPozycja() {
        return pozycja;
    }


    /* ------------------LISTENER I ------------------*/
    public void setPanel(IteratorDishes iter) {
        String[] nazwa = new String[6];
        nazwa[0] = iter.get().getTitle(); //nazwa przepisu
        nazwa[1] = textFieldCzasPrzygotowania.getText(); //czas -dorobic
        nazwa[2] = textFieldLiczbaOsob.getText(); //liczba osob -dorobic
        nazwa[3] = iter.get().getIngredients(); //skladniki
        nazwa[4] = iter.get().getDescribe(); //opis
        nazwa[5] = iter.get().toString(); //typ - kategoria
        rate=iter.get().getRate();
        //int id=0;

        Przepis = new JPanel();
        frame.getContentPane().add(Przepis, "Przepis");
        Przepis.setLayout(null);
        DodawaniePrzepisow.setVisible(false);
        MenuGlowne.setVisible(false);
        Przepis.setVisible(true);

        JLabel lblNazwaKateg = new JLabel(nazwa[5]);
        lblNazwaKateg.setBounds(10, 11, 173, 64);
        Przepis.add(lblNazwaKateg);

        JLabel lblNazwaPrzepis = new JLabel(nazwa[0]);
        lblNazwaPrzepis.setBounds(195, 11, 383, 64);
        Przepis.add(lblNazwaPrzepis);

        JLabel lblCzasPrzyg = new JLabel("Czas przyg w min.");
        lblCzasPrzyg.setBounds(584, 11, 200, 64);
        Przepis.add(lblCzasPrzyg);

        JLabel lblOcena = new JLabel("" + rate);
        lblOcena.setBounds(961, 11, 98, 64);
        Przepis.add(lblOcena);

        JLabel lblLiczbaOsob2 = new JLabel("Liczba Osob");
        lblLiczbaOsob2.setBounds(857, 11, 98, 64);
        Przepis.add(lblLiczbaOsob2);

        JLabel lblPoziomTrudnoci = new JLabel("Poziom Trudno\u015Bci");
        lblPoziomTrudnoci.setBounds(753, 11, 98, 64);
        Przepis.add(lblPoziomTrudnoci);

        JLabel lblZdjecie = new JLabel("ZDJENNNCIIEIIE");
        lblZdjecie.setBounds(10, 81, 335, 200);
        Przepis.add(lblZdjecie);

        JLabel lblListaSkladnikow = new JLabel(nazwa[3]);
        lblListaSkladnikow.setBounds(10, 305, 335, 290);
        Przepis.add(lblListaSkladnikow);

        JLabel lblOpis = new JLabel(nazwa[4]);
        lblOpis.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 61));
        lblOpis.setVerticalAlignment(SwingConstants.TOP);
        lblOpis.setBounds(369, 86, 666, 509);
        Przepis.add(lblOpis);

        JButton btnPowrotSpisu = new JButton("Powr\u00F3t do spisu");
        btnPowrotSpisu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Przepis.setVisible(false);
                Zupy.setVisible(true);
            }
        });
        btnPowrotSpisu.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotSpisu.setBounds(10, 611, 200, 50);
        Przepis.add(btnPowrotSpisu);

        JButton btnPowrotMenu = new JButton("Powr\u00F3t do menu");
        btnPowrotMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Przepis.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });
        btnPowrotMenu.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotMenu.setBounds(859, 611, 200, 50);
        Przepis.add(btnPowrotMenu);

        Handlerclass handler = new Handlerclass();

        gwiazdka1 = new JLabel("");
        gwiazdka1.setBounds(382, 621, 52, 40);
        Przepis.add(gwiazdka1);
        gwiazdka1.setIcon(gwZoltaIcon);

        gwiazdka2 = new JLabel("");
        gwiazdka2.setBounds(444, 621, 52, 40);
        Przepis.add(gwiazdka2);
        //Icon gwZoltaIcon = new ImageIcon("/Zolta.png");
        if(rate>1.0)
            gwiazdka2.setIcon(gwZoltaIcon);
        else
            gwiazdka2.setIcon(gwSzaraIcon);

        gwiazdka3 = new JLabel("");
        gwiazdka3.setBounds(506, 621, 52, 40);
        Przepis.add(gwiazdka3);
        //Icon logoImage = new ImageIcon("/Logo.png");
        if(rate>2.0)
            gwiazdka3.setIcon(gwZoltaIcon);
        else
            gwiazdka3.setIcon(gwSzaraIcon);

        gwiazdka4 = new JLabel("");
        gwiazdka4.setBounds(568, 621, 52, 40);
        Przepis.add(gwiazdka4);
        //Icon logoIcon2 = new ImageIcon("/Logo.png");
        if(rate>3.0)
            gwiazdka4.setIcon(gwZoltaIcon);
        else
            gwiazdka4.setIcon(gwSzaraIcon);

        gwiazdka5 = new JLabel("");
        gwiazdka5.setBounds(630, 621, 52, 40);
        Przepis.add(gwiazdka5);
        //Icon logoIcon3 = new ImageIcon("/Logo.png");
        if(rate>4.0)
            gwiazdka5.setIcon(gwZoltaIcon);
        else
            gwiazdka5.setIcon(gwSzaraIcon);

        gwiazdka1.addMouseListener(handler);
        gwiazdka1.addMouseMotionListener(handler);
        gwiazdka2.addMouseListener(handler);
        gwiazdka2.addMouseMotionListener(handler);
        gwiazdka3.addMouseListener(handler);
        gwiazdka3.addMouseMotionListener(handler);
        gwiazdka4.addMouseListener(handler);
        gwiazdka4.addMouseMotionListener(handler);
        gwiazdka5.addMouseListener(handler);
        gwiazdka5.addMouseMotionListener(handler);

        /* Gwiazdki do panelu PRZEPIS */

        JLabel lblTlo12 = new JLabel("");
        lblTlo12.setIcon(tloImage);
        lblTlo12.setBounds(0, 0, 1069, 672);
        Przepis.add(lblTlo12);

        lblNic = new JLabel("\t\t\t\t\r\n\t\t\r\n\r\n\t\t\t\t\t\tNIC");
        lblNic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNic.setBounds(472, 188, 237, 139);
        Przepis.add(lblNic);


    }

    ///JButton.getBounds().x and JButton.getBounds().y

    public objectSQL getobjectSQL() {
        String[] nazwa = new String[6];
        nazwa[0] = textFieldNazwaPrzepisu.getText(); //nazwa przepisu
        nazwa[1] = textFieldCzasPrzygotowania.getText(); //czas -dorobic
        nazwa[2] = textFieldLiczbaOsob.getText(); //liczba osob -dorobic
        nazwa[3] = textAreaSkladniki.getText(); //skladniki
        nazwa[4] = textAreaOpisPrzygotowania.getText(); //opis
        nazwa[5] = (String)comboBoxKategorieDan.getSelectedItem(); //typ - kategoria
        rate=0.0;
        int id=3;   //zawsze zwraca id=0.

        /*
        int[] setYbtn = new int[iloscKategorii];
        for (int i=0; i<iloscKategorii; i++) setYbtn[i] = 45;

        int poz=0;
        if (comboBoxKategorieDan.getSelectedItem().equals("ZUPY")) {
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Zupy.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            Zupy.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowyZupy.add(btnPrzepisowy);   //nie wiem czy to potrzebne ale na wszelki wypadek jest.
        }
        else if(comboBoxKategorieDan.getSelectedItem().equals("DANIA_MIESNE")) {
            poz++;
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    DaniaMiesne.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            DaniaMiesne.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowyDaniaMiesne.add(btnPrzepisowy);
        }
        else if(comboBoxKategorieDan.getSelectedItem().equals("CIASTA_DESERY")) {
            poz++;
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    CiastaIDesery.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            CiastaIDesery.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowyCiastaIDesery.add(btnPrzepisowy);
        }
        else if(comboBoxKategorieDan.getSelectedItem().equals("NAPOJE")) {
            poz++;
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Napoje.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            Napoje.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowyNapoje.add(btnPrzepisowy);
        }
        else if(comboBoxKategorieDan.getSelectedItem().equals("SALATKA_PRZYSTAWKI")) {
            poz++;
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    SalatkiIPrzystawki.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            SalatkiIPrzystawki.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowySalatkiIPrzystawki.add(btnPrzepisowy);
        }
        else if(comboBoxKategorieDan.getSelectedItem().equals("RYBY_OWOCE_MORZA")) {
            poz++;
            JButton btnPrzepisowy = new JButton(nazwa[0]);
            btnPrzepisowy.setFont(new Font("BankGothic Md BT", Font.PLAIN, 17));
            btnPrzepisowy.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    RybyIOwoceMorza.setVisible(false);
                    Przepis.setVisible(true);
                }
            });
            btnPrzepisowy.setBackground(new Color(255, 255, 255, 0));    //przezroczyste
            btnPrzepisowy.setBorderPainted(false);  //brak obramowki buttona
            btnPrzepisowy.setBounds(199, setYbtn[poz], 356, 40);
            RybyIOwoceMorza.add(btnPrzepisowy);
            setYbtn[poz]+=odlegloscYbtn;  //25
            btnPrzepisowyRybyIOwoceMorza.add(btnPrzepisowy);
        }
        */

        objectSQL przepisObject = Factory.FactoryDishes(0, nazwa[0], nazwa[4], nazwa[3], "komentarz", "sciezka", rate, nazwa[5]);
        return przepisObject;

    }

    private void updateRate(double ocena) {
        if(rate<1.0)
            rate=ocena;
        else
            rate=(rate+ocena)/2.0;
    }

    ///TODO btnHandler
    private class Buttonclass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnZupy) {
                typ.append("ZUPY");
                Kategorie.setVisible(false);
                Zupy.setVisible(true);
                System.out.println("WYYYYYK");
            }
        }
    }




    //KLASA do obs?ugi zdarze? MYSZKI:
    private class Handlerclass implements MouseMotionListener, MouseListener {
        //private int gwiazdkaWys1=0, gwiazdkaWys2=40;
        int X=0, Y=0;
        public void mouseClicked(MouseEvent e) {    //klikniecie LPM.
            if(e.getSource()==gwiazdka1) {
                updateRate(1.0);
                //System.out.println("OCENA1: " + ocenaTemp);
                //lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if(e.getSource()==gwiazdka2) {
                updateRate(2.0);
                //System.out.println("OCENA2: " + ocenaTemp);
                //lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if(e.getSource()==gwiazdka3) {
                updateRate(3.0);
                //System.out.println("OCENA3: " + ocenaTemp);
                //lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if(e.getSource()==gwiazdka4) {
                updateRate(4.0);
                //System.out.println("OCENA4: " + ocenaTemp);
                //lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if(e.getSource()==gwiazdka5) {
                updateRate(5.0);
                //System.out.println("OCENA5: " + ocenaTemp);
                //lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
        }

        public void mouseEntered(MouseEvent e) {    //wejscie przez kursor w odpowiednia strefe
            gwiazdka1.setIcon(gwSzaraIcon); gwiazdka2.setIcon(gwSzaraIcon);
            gwiazdka3.setIcon(gwSzaraIcon); gwiazdka4.setIcon(gwSzaraIcon);
            gwiazdka5.setIcon(gwSzaraIcon);
            if(e.getSource()==gwiazdka1) {
                gwiazdka1.setIcon(gwZoltaIcon);

                lblNic.setText("STREFA 1");
                System.out.println("S1");

            }
            else if(e.getSource()==gwiazdka2) {
                gwiazdka1.setIcon(gwZoltaIcon);gwiazdka2.setIcon(gwZoltaIcon);

                lblNic.setText("STREFA 1");
                System.out.println("S1");
            }
            else if(e.getSource()==gwiazdka3) {
                gwiazdka1.setIcon(gwZoltaIcon);gwiazdka2.setIcon(gwZoltaIcon);
                gwiazdka3.setIcon(gwZoltaIcon);

                lblNic.setText("STREFA 1");
                System.out.println("S1");

            }
            else if(e.getSource()==gwiazdka4) {
                gwiazdka1.setIcon(gwZoltaIcon);gwiazdka2.setIcon(gwZoltaIcon);
                gwiazdka3.setIcon(gwZoltaIcon);gwiazdka4.setIcon(gwZoltaIcon);

                lblNic.setText("STREFA 1");
                System.out.println("S1");

            }
            else if(e.getSource()==gwiazdka5) {
                gwiazdka1.setIcon(gwZoltaIcon);gwiazdka2.setIcon(gwZoltaIcon);
                gwiazdka3.setIcon(gwZoltaIcon);gwiazdka4.setIcon(gwZoltaIcon);
                gwiazdka5.setIcon(gwZoltaIcon);

                lblNic.setText("STREFA 1");
                System.out.println("S1");

            }
        }

        public void mouseExited(MouseEvent e) {     //wyjscie ze kursora strefy
            gwiazdka1.setIcon(gwSzaraIcon); gwiazdka2.setIcon(gwSzaraIcon);
            gwiazdka3.setIcon(gwSzaraIcon); gwiazdka4.setIcon(gwSzaraIcon);
            gwiazdka5.setIcon(gwSzaraIcon);
            lblNic.setText("OUT STREFA 1");
            System.out.println("OUT S1");

        }

        public void mousePressed(MouseEvent e) {}   //trzymanie LPM
        public void mouseReleased(MouseEvent e) {}  //zwolnienie(nie trzymanie) LPM
        public void mouseDragged(MouseEvent e) {
            //Screen.mse = new Point ((e.getX()) + ((Frame.size.width - Screen.myWidth)/2), (e.getY()) + ((Frame.size.height - (Screen.myHeight)) - (Frame.size.width - Screen.myWidth)/2));
        }
        public void mouseMoved(MouseEvent e) {
            //Screen.mse = new Point ((e.getX()) - ((Frame.size.width - Screen.myWidth)/2), (e.getY()) - ((Frame.size.height - (Screen.myHeight)) - (Frame.size.width - Screen.myWidth)/2));
        }

    }

}
