package kuchnia;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
//

public class GUI {

    public JFrame frame;
    public JTextField SearchField;
    private int width=1075, height=700;
    private int widthKlawisz=200;
    private int srodkujKlawisz=(width-widthKlawisz)/2;
    private JTextField textFieldNazwaPrzepisu;
    private JTextField textFieldCzasPrzygotowania;
    private JTextField textFieldLiczbaOsob;
    private JPanel Przepis;
    private JLabel lblNic;
    private Image gwSzaraImage;
    private Image gwZoltaImage;
    private JLabel labelGwiazdki;
    private JLabel gwiazdka1, gwiazdka2, gwiazdka3, gwiazdka4, gwiazdka5;


    private int ocenaTemp=0;

    /*----------------MAIN-----------------*/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /*----------------MAIN-----------------*/


    public GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, width, height);
        frame.setResizable(false);	//zmiana rozmiaru okienka-ustawiona na false.
        frame.setLocationRelativeTo(null);    //null- okienko wyskakuje na srodku ekranu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));

//=======================  Panele  =============================================================

        final JPanel MenuGlowne = new JPanel();
        frame.getContentPane().add(MenuGlowne, "Menu Glowne");
        MenuGlowne.setLayout(null);
        MenuGlowne.setVisible(true);

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

        Przepis = new JPanel(); //TODO nie final bo musze sie pozniej odwolac do klasy obslugujaca myszke
        frame.getContentPane().add(Przepis, "Przepis");
        Przepis.setLayout(null);
        Przepis.setVisible(false);

//======================= Elementy w panelu Menu Glowne  =========================================

        JButton btnGUIisy = new JButton("Przepisy");
        btnGUIisy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnGUIisy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MenuGlowne.setVisible(false);
                Kategorie.setVisible(true);
            }
        });
        btnGUIisy.setBounds(780, 156, widthKlawisz, 50);
        MenuGlowne.add(btnGUIisy);

        JButton btnWyszukiwarka = new JButton("Wyszukiwarka");
        btnWyszukiwarka.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Wyszukiwanie.setVisible(true);
            }
        });
        btnWyszukiwarka.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyszukiwarka.setBounds(780, 256, widthKlawisz, 50);
        MenuGlowne.add(btnWyszukiwarka);

        JButton btnAutorzy = new JButton("Autorzy");
        btnAutorzy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuGlowne.setVisible(false);
                Autorzy.setVisible(true);
            }
        });
        btnAutorzy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnAutorzy.setBounds(780, 363, widthKlawisz, 50);
        MenuGlowne.add(btnAutorzy);

        JButton btnWyjscie = new JButton("Wyjscie");
        btnWyjscie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnWyjscie.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnWyjscie.setBounds(780, 474, widthKlawisz, 50);
        MenuGlowne.add(btnWyjscie);

        //TYMCZASOWO:
        JButton btnPrzepisyKonkretne = new JButton("PrzepisyKonkretne");
        btnPrzepisyKonkretne.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPrzepisyKonkretne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MenuGlowne.setVisible(false);
                Przepis.setVisible(true);
            }
        });
        btnPrzepisyKonkretne.setBounds(150, 156, widthKlawisz, 50);
        MenuGlowne.add(btnPrzepisyKonkretne);
        //TYMCZASOWO

        JLabel loggo = new JLabel("");
        Image logoImage = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
        loggo.setIcon(new ImageIcon(logoImage));
        loggo.setBounds(59, 156, 619, 369);
        MenuGlowne.add(loggo);


//=======================  Elementy w panelu Kategorie  =============================================

        JButton btnZupy = new JButton("Zupy");
        btnZupy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                Zupy.setVisible(true);
            }
        });
        btnZupy.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnZupy.setBounds(437, 63, widthKlawisz, 50);
        Kategorie.add(btnZupy);

        JButton btnDanieMiesne = new JButton("Dania \r\nmi\u0119sne");
        btnDanieMiesne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                DaniaMiesne.setVisible(true);
            }
        });
        btnDanieMiesne.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDanieMiesne.setBounds(437, 148, widthKlawisz, 50);
        Kategorie.add(btnDanieMiesne);

        JButton btnCiastaIDesery = new JButton("Ciasta i desery");
        btnCiastaIDesery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                CiastaIDesery.setVisible(true);
            }
        });
        btnCiastaIDesery.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnCiastaIDesery.setBounds(437, 225, widthKlawisz, 50);
        Kategorie.add(btnCiastaIDesery);

        JButton btnNapoje = new JButton("Napoje");
        btnNapoje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                Napoje.setVisible(true);
            }
        });
        btnNapoje.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnNapoje.setBounds(437, 300, widthKlawisz, 50);
        Kategorie.add(btnNapoje);

        JButton btnRybyIOwoce = new JButton("Ryby i owoce morza");
        btnRybyIOwoce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                RybyIOwoceMorza.setVisible(true);
            }
        });
        btnRybyIOwoce.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnRybyIOwoce.setBounds(437, 378, widthKlawisz, 50);
        Kategorie.add(btnRybyIOwoce);

        JButton btnSalatkiIPrzystawki = new JButton("Sa\u0142atki i przystawki");
        btnSalatkiIPrzystawki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kategorie.setVisible(false);
                SalatkiIPrzystawki.setVisible(true);
            }
        });
        btnSalatkiIPrzystawki.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSalatkiIPrzystawki.setBounds(srodkujKlawisz, 462, widthKlawisz, 50);
        Kategorie.add(btnSalatkiIPrzystawki);

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

        ImageIcon szukajImage = new ImageIcon("Lupamala.png");
        JButton btnSzukaj = new JButton("Szukaj", szukajImage); //moze byc tez bez napisu
        btnSzukaj.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnSzukaj.setBounds(428, 400, 98, 39);
        Wyszukiwanie.add(btnSzukaj);

//=======================  Elementy w panelu Autorzy  ================================================

        JButton btnPowrotDoMenu3 = new JButton("Powr\u00F3t do menu");
        btnPowrotDoMenu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Autorzy.setVisible(false);
                MenuGlowne.setVisible(true);
            }
        });

        Image marcinImage = new ImageIcon(this.getClass().getResource("/Marcin.png")).getImage();
        Image wojtekImage = new ImageIcon(this.getClass().getResource("/Marcin.png")).getImage();
        Image jacekImage = new ImageIcon(this.getClass().getResource("/Marcin.png")).getImage();
        Image pawelImage = new ImageIcon(this.getClass().getResource("/Marcin.png")).getImage();
        Image arturImage = new ImageIcon(this.getClass().getResource("/Marcin.png")).getImage();

        btnPowrotDoMenu3.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnPowrotDoMenu3.setBounds(859, 611, widthKlawisz, 50);
        Autorzy.add(btnPowrotDoMenu3);
        Autorzy.setVisible(false);

        JLabel lblWojciechZachwieja = new JLabel("");
        lblWojciechZachwieja.setBounds(142, 53, 171, 217);
        Autorzy.add(lblWojciechZachwieja);
        lblWojciechZachwieja.setIcon(new ImageIcon(wojtekImage));

        JLabel lblMarcinStyczen = new JLabel("");
        lblMarcinStyczen.setBounds(751, 53, 171, 217);
        Autorzy.add(lblMarcinStyczen);
        lblMarcinStyczen.setIcon(new ImageIcon(marcinImage));

        JLabel lblArturUrbanowicz = new JLabel("");
        lblArturUrbanowicz.setBounds(456, 53, 171, 217);
        Autorzy.add(lblArturUrbanowicz);
        lblArturUrbanowicz.setIcon(new ImageIcon(arturImage));

        JLabel lblJacekZawodny = new JLabel("");
        lblJacekZawodny.setBounds(300, 323, 171, 217);
        Autorzy.add(lblJacekZawodny);
        lblJacekZawodny.setIcon(new ImageIcon(jacekImage));

        JLabel lblPawelWilczek = new JLabel("");
        lblPawelWilczek.setBounds(600, 323, 171, 217);
        Autorzy.add(lblPawelWilczek);
        lblPawelWilczek.setIcon(new ImageIcon(pawelImage));

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

//=======================  Elementy w panelu Zupy  ====================================================

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

//=======================  Elementy w panelu Dodawanie Przepisow  ===============================================

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

        JComboBox comboBoxKategorieDan = new JComboBox();
        comboBoxKategorieDan.setBounds(10, 172, 263, 28);
        DodawaniePrzepisow.add(comboBoxKategorieDan);

        JTextArea textAreaSkladniki = new JTextArea();
        textAreaSkladniki.setBounds(10, 257, 317, 325);
        DodawaniePrzepisow.add(textAreaSkladniki);

        JLabel lblSkladniki = new JLabel("Sk\u0142adniki:");
        lblSkladniki.setBounds(10, 221, 98, 37);
        DodawaniePrzepisow.add(lblSkladniki);

        JDesktopPane desktopPaneZdjecieDania = new JDesktopPane();
        desktopPaneZdjecieDania.setBounds(793, 68, 250, 250);
        DodawaniePrzepisow.add(desktopPaneZdjecieDania);

        JLabel lblZdjecieDania = new JLabel("");
        lblZdjecieDania.setBounds(10, 11, 230, 228);
        desktopPaneZdjecieDania.add(lblZdjecieDania);

        JTextArea textAreaOpisPrzygotowania = new JTextArea();
        textAreaOpisPrzygotowania.setBounds(362, 377, 681, 205);
        DodawaniePrzepisow.add(textAreaOpisPrzygotowania);

        JLabel lblOpisPrzygotowania = new JLabel("Opis przygotowania:");
        lblOpisPrzygotowania.setBounds(362, 338, 179, 28);
        DodawaniePrzepisow.add(lblOpisPrzygotowania);

        JButton btnDodajZdjecie = new JButton("Dodaj zdj\u0119cie");
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

        JComboBox comboBoxPoziomTrudnosci = new JComboBox();
        comboBoxPoziomTrudnosci.setBounds(608, 100, 101, 25);
        DodawaniePrzepisow.add(comboBoxPoziomTrudnosci);

        JLabel lblLiczbaOsob = new JLabel("Liczba os\u00F3b:");
        lblLiczbaOsob.setBounds(400, 168, 116, 37);
        DodawaniePrzepisow.add(lblLiczbaOsob);

        textFieldLiczbaOsob = new JTextField();
        textFieldLiczbaOsob.setBounds(400, 194, 64, 28);
        DodawaniePrzepisow.add(textFieldLiczbaOsob);
        textFieldLiczbaOsob.setColumns(10);

        JButton btnDodajPrzepis = new JButton("Dodaj przepis");
        btnDodajPrzepis.setFont(new Font("Calibri", Font.PLAIN, 17));
        btnDodajPrzepis.setEnabled(true);
        btnDodajPrzepis.setBounds(434, 611, 200, 50);
        DodawaniePrzepisow.add(btnDodajPrzepis);
        DodawaniePrzepisow.setVisible(false);


//=======================  Elementy w panelu PRZEPIS  ===============================================
        /* Gwiazdki do panelu PRZEPIS */
        gwSzaraImage = new ImageIcon(this.getClass().getResource("/Szara.png")).getImage();
        gwZoltaImage = new ImageIcon(this.getClass().getResource("/Zolta.png")).getImage();

        Handlerclass handler = new Handlerclass();
        //Przepis.addMouseListener(handler);
        //Przepis.addMouseMotionListener(handler);

        labelGwiazdki = new JLabel("");
        labelGwiazdki.setBounds(768, 621, 268, 40);
        Przepis.add(labelGwiazdki);

        gwiazdka1 = new JLabel("");
        gwiazdka1.setBounds(768, 621, 52, 40);
        Przepis.add(gwiazdka1);
        gwiazdka1.setIcon(new ImageIcon(gwSzaraImage));

        gwiazdka2 = new JLabel("");
        gwiazdka2.setBounds(825, 621, 52, 40);
        Przepis.add(gwiazdka2);
        //Image gwZoltaImage = new ImageIcon(this.getClass().getResource("/Zolta.png")).getImage();
        gwiazdka2.setIcon(new ImageIcon(gwSzaraImage));

        gwiazdka3 = new JLabel("");
        gwiazdka3.setBounds(880, 621, 52, 40);
        Przepis.add(gwiazdka3);
        //Image logoImage = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
        gwiazdka3.setIcon(new ImageIcon(gwSzaraImage));

        gwiazdka4 = new JLabel("");
        gwiazdka4.setBounds(932, 621, 52, 40);
        Przepis.add(gwiazdka4);
        //Image logoImage = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
        gwiazdka4.setIcon(new ImageIcon(gwSzaraImage));

        gwiazdka5 = new JLabel("");
        gwiazdka5.setBounds(984, 621, 52, 40);
        Przepis.add(gwiazdka5);
        //Image logoImage = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
        gwiazdka5.setIcon(new ImageIcon(gwSzaraImage));

        labelGwiazdki.addMouseListener(handler);
        labelGwiazdki.addMouseMotionListener(handler);

        /* Gwiazdki do panelu PRZEPIS */

        lblNic = new JLabel("\t\t\t\t\r\n\t\t\r\n\r\n\t\t\t\t\t\tNIC");     //TODO usunac pozniej
        lblNic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNic.setBounds(472, 188, 237, 139);
        Przepis.add(lblNic);

    }

    //KLASA do obs³ugi zdarzeñ MYSZKI:
    private class Handlerclass implements MouseMotionListener, MouseListener {
        private int gwiazdkaWys1=0, gwiazdkaWys2=40;
        int X=0, Y=0;
        public void mouseClicked(MouseEvent e) {    //klikniecie LPM.
            X = e.getX();
            System.out.println("X: " + X);
            Y = e.getY();
            System.out.println("Y " + Y);
            if (X >= 0 && X <= 52 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                ocenaTemp += 1;
                System.out.println("OCENA1: " + ocenaTemp);
                lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if (X >= 109 - 52 && X <= 109 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                ocenaTemp += 1;
                System.out.println("OCENA2: " + ocenaTemp);
                lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if (X >= 164 - 52 && X <= 164 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                ocenaTemp += 1;
                System.out.println("OCENA3: " + ocenaTemp);
                lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if (X >= 216 - 52 && X <= 216 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                ocenaTemp += 1;
                System.out.println("OCENA4: " + ocenaTemp);
                lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
            else if (X >= 268 - 52 && X <= 268 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                ocenaTemp += 1;
                System.out.println("OCENA5: " + ocenaTemp);
                lblNic.setText(String.format("Cliced at %d , %d", e.getX(), e.getY()));
            }
        }

        public void mouseEntered(MouseEvent e) {    //wejscie przez kursor w odpowiednia strefe
                    X = e.getX();
                    System.out.println("X: " + X);
                    Y = e.getY();
                    System.out.println("Y " + Y);
                    if (X >= 0 && X <= 52 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                        gwiazdka1.setIcon(new ImageIcon(gwZoltaImage));
                        lblNic.setText("STREFA 1");
                        System.out.println("S1");
                        return;
                    } else if (X >= 109 - 52 && X <= 109 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                        gwiazdka1.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka2.setIcon(new ImageIcon(gwZoltaImage));
                        lblNic.setText("STREFA 2");
                        System.out.println("S2");
                    } else if (X >= 164 - 52 && X <= 164 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                        gwiazdka1.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka2.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka3.setIcon(new ImageIcon(gwZoltaImage));
                        lblNic.setText("STREFA 3");
                        System.out.println("S3");
                    } else if (X >= 216 - 52 && X <= 216 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                        gwiazdka1.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka2.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka3.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka4.setIcon(new ImageIcon(gwZoltaImage));
                        lblNic.setText("STREFA 4");
                        System.out.println("S4");
                    } else if (X >= 268 - 52 && X <= 268 && Y >= gwiazdkaWys1 && Y <= gwiazdkaWys2) {
                        gwiazdka1.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka2.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka3.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka4.setIcon(new ImageIcon(gwZoltaImage));
                        gwiazdka5.setIcon(new ImageIcon(gwZoltaImage));
                        lblNic.setText("STREFA 5");
                        System.out.println("S5");
                    }
                    System.out.println("SKONCZYLEM");
            return;
        }

        public void mouseExited(MouseEvent e) {     //wyjscie ze kursora strefy
            gwiazdka1.setIcon(new ImageIcon(gwSzaraImage)); gwiazdka2.setIcon(new ImageIcon(gwSzaraImage));
            gwiazdka3.setIcon(new ImageIcon(gwSzaraImage)); gwiazdka4.setIcon(new ImageIcon(gwSzaraImage));
            gwiazdka5.setIcon(new ImageIcon(gwSzaraImage));
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