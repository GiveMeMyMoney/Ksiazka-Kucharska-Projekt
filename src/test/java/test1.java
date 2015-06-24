import kuchnia.View;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pawel on 2015-06-24.
 */
public class test1 {
    @org.junit.Test
    public void test() {
        View v = new View();
        assertEquals(v.usunPrzepis(), true);
        System.out.println("Usuwanie dziala poprawnie");
    }
}
