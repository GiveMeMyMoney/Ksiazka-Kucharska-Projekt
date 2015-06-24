import baza_danych.querySQL;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Pawel on 2015-06-24.
 */
public class test4 {
    @org.junit.Test
    public void test() {
        querySQL qs = new querySQL();
        int q = qs.lastID();
        assertNotNull(q);
        System.out.println("Baza nie jest pusta");
    }
}
