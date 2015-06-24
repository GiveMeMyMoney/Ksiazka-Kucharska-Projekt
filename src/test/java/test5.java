import baza_danych.querySQL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pawel on 2015-06-24.
 */
public class test5 {
    @org.junit.Test
    public void test() {
        querySQL q = new querySQL();
        assertEquals(q.insertAll(5.0, "jakisTytul", "jakiesSkladniki", "jakisOpis", "jakisKomentarz", "jakasSciezka", "jakasKategoria"), true);
        System.out.println("Wpisywanie do bazy poprawne");
    }
}
