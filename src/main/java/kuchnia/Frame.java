package kuchnia;

import baza_danych.objectSQL;
import baza_danych.querySQL;
import baza_danych.sqliteConnection;

import javax.swing.*;
import java.awt.*;	//grafika
import java.awt.geom.Arc2D;
//testtest
//class MyScreen;


public class Frame extends JFrame {

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

}
