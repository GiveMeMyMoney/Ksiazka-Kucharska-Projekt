import kuchnia.Model;

import static org.junit.Assert.assertNotNull;


/**
 * Created by Pawel on 2015-06-24.
 */
public class test3 {
    @org.junit.Test
    public void test() {
        Model m = new Model();
        assertNotNull(m.zupy);
        assertNotNull(m.Napoje);
        assertNotNull(m.DaniaMiesne);
        System.out.println("Inicjalizacja poprawna");
    }
}
