package kuchnia;

/**
 * Created by Marcin on 2015-05-26.
 */
public abstract class Spis {
    private String nazwa = "";
    private int poloX, poloY, width, height;

    public Spis(String nazwa, int poloX, int poloY, int width, int height) {
        this.nazwa=nazwa;
        this.poloX=poloX;
        this.poloY=poloY;
        this.width=width;
        this.height=height;
    }

}
