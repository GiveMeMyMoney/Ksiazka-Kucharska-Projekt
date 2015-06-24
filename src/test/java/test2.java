import kuchnia.View;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pawel on 2015-06-24.
 */
public class test2 {
    @org.junit.Test
    public void test() {
        View v = new View();
        assertEquals(v.modyfikPrzepis(), true);
        System.out.println("Modyfikowanie dziala poprawnie");
    }
}
