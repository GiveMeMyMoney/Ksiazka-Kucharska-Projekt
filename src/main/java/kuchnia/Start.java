package kuchnia;

import java.awt.*;

/**
 * Created by Marcin on 2015-06-04.
 */
public class Start {

    /*----------------MAIN-----------------*/
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Model theModel = new Model();
                    View theView = new View();
                    //View window = new View();


                    Controller theController = new Controller(theModel, theView);

                    theView.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /*----------------MAIN-----------------*/
}
